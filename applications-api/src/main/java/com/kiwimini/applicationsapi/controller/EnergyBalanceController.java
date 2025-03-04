package com.kiwimini.applicationsapi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kiwimini.applicationsapi.model.ResourceType;
import com.kiwimini.applicationsapi.service.ThingsApiService;
import com.kiwimini.sharedmodels.model.Battery;
import com.kiwimini.sharedmodels.model.Charger;
import com.kiwimini.sharedmodels.model.SolarPanel;

import lombok.Data;

@RestController
@RequestMapping("/api/energy")
public class EnergyBalanceController {

    private final ThingsApiService thingsApiService;

    public EnergyBalanceController(ThingsApiService thingsApiService) {
        this.thingsApiService = thingsApiService;
    }

    private static final Logger logger = LoggerFactory.getLogger(ThingsApiService.class);

    @GetMapping("/balance")
    public ResponseEntity<EnergyBalance> getEnergyBalance() {
        // Alle Geräte abrufen
        List<Battery> batteries = thingsApiService.getAllItemsOfType(ResourceType.BATTERY);
        List<Charger> chargers = thingsApiService.getAllItemsOfType(ResourceType.CHARGER);
        List<SolarPanel> solarPanels = thingsApiService.getAllItemsOfType(ResourceType.SOLARPANEL);

        // Energie-Bilanz berechnen
        int totalProduction = solarPanels.stream()
                .mapToInt(SolarPanel::getEnergyOutputPerHour)
                .sum();

        int totalConsumption = chargers.stream()
                .filter(Charger::isCharging)
                .mapToInt(Charger::getEnergyInputPerHour)
                .sum()
                + batteries.stream()
                        .mapToInt(Battery::getEnergyInputPerHour)
                        .sum();

        logger.info("{} {}", totalProduction, totalConsumption);

        int netBalance = totalProduction - totalConsumption;

        return ResponseEntity.ok(new EnergyBalance(
                netBalance));
    }

    @Data
    public static class EnergyBalance {
        private final int energyBalance;
    }
}
