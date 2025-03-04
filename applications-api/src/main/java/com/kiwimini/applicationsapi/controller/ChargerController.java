package com.kiwimini.applicationsapi.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kiwimini.applicationsapi.model.ResourceType;
import com.kiwimini.applicationsapi.service.ThingsApiService;
import com.kiwimini.sharedmodels.model.Charger;
import com.kiwimini.sharedmodels.model.Result;

@RestController
@RequestMapping("/api/chargers")
public class ChargerController {

    private final ThingsApiService thingsApiService;

    public ChargerController(ThingsApiService thingsApiService) {
        this.thingsApiService = thingsApiService;
    }

    @GetMapping("")
    public List<Charger> getChargers() {
        return thingsApiService.getAllItemsOfType(ResourceType.CHARGER);
    }

    @PutMapping("/{id}/charging")
    public ResponseEntity<?> updateChargingStatus(
            @PathVariable UUID id,
            @RequestBody Charger charger) {

        Result<Void, Error> result = thingsApiService.updateChargerStatus(id, charger.isCharging());

        if (result.isSuccess()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(result.getError());
        }
    }
}