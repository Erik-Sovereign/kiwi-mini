package com.kiwimini.thingsapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.kiwimini.thingsapi.model.BatteryEntity;
import com.kiwimini.thingsapi.model.ChargerEntity;
import com.kiwimini.thingsapi.model.SolarPanelEntity;

@Configuration
public class RestConfiguration implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        // ID-Felder in der JSON-Antwort sichtbar machen
        config.exposeIdsFor(
                BatteryEntity.class,
                ChargerEntity.class,
                SolarPanelEntity.class);
    }
}