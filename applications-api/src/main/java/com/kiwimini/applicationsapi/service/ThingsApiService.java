package com.kiwimini.applicationsapi.service;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kiwimini.applicationsapi.model.ResourceType;
import com.kiwimini.sharedmodels.model.Charger;
import com.kiwimini.sharedmodels.model.Result;

@Service
public class ThingsApiService {
    private final RestTemplate restTemplate;
    private final String thingsApiBaseUrl;
    private final ObjectMapper objectMapper;

    public ThingsApiService(RestTemplate restTemplate,
            @Value("${things-api.base-url}") String thingsApiBaseUrl, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.thingsApiBaseUrl = thingsApiBaseUrl;
        this.objectMapper = objectMapper;

    }

    private static final Logger logger = LoggerFactory.getLogger(ThingsApiService.class);

    private static class ResourceCollection<T> {
        private List<T> items;

        @JsonProperty("batteries")
        public void setBatteries(List<T> items) {
            this.items = items;
        }

        @JsonProperty("chargers")
        public void setChargers(List<T> items) {
            this.items = items;
        }

        @JsonProperty("solarpanels")
        public void setSolarPanels(List<T> items) {
            this.items = items;
        }

        public List<T> getItems() {
            return items != null ? items : Collections.emptyList();
        }
    }

    private static class ResourceResponse<T> {
        @JsonProperty("_embedded")
        private ResourceCollection<T> _embedded;

        public ResourceCollection<T> getEmbedded() {
            return _embedded;
        }
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> getAllItemsOfType(ResourceType resourceType) {
        try {
            ResponseEntity<ResourceResponse<LinkedHashMap>> response = restTemplate.exchange(
                    thingsApiBaseUrl + resourceType.path,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<ResourceResponse<LinkedHashMap>>() {
                    });

            List<LinkedHashMap> result_object = Optional.ofNullable(response.getBody()).map(body -> body.getEmbedded())
                    .map(embedded -> embedded.getItems()).orElse(Collections.emptyList());

            List<T> result = result_object.stream()
                    .map(object -> (T) objectMapper.convertValue(object, resourceType.type))
                    .collect(Collectors.toList());

            return result;
        } catch (Exception e) {
            logger.error("Fehler beim Abrufen von {}: {}", resourceType, e.getMessage());

            return Collections.emptyList();
        }
    }

    @SuppressWarnings("unchecked")
    public <T> Optional<T> getEntityById(ResourceType resourceType, UUID id) {
        try {
            Object entity = restTemplate.getForObject(thingsApiBaseUrl + resourceType.path + "/" + id,
                    resourceType.type);
            return Optional.ofNullable((T) entity);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public Result<Void, Error> updateChargerStatus(UUID id, boolean isCharging) {
        try {
            // Lade aktuellen Zustand
            Optional<Charger> charger = getEntityById(ResourceType.CHARGER, id);
            if (charger.isPresent()) {
                charger.get().setCharging(isCharging);

                restTemplate.put(thingsApiBaseUrl + "/chargers/" + id, charger);

                return Result.success();
            } else {
                return Result.failure(new Error("ID nicht in Datenbank vorhanden"));
            }
        } catch (Exception e) {
            return Result.failure(new Error(e.toString()));
        }
    }
}
