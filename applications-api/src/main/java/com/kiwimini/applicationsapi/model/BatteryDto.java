package com.kiwimini.applicationsapi.model;

import java.util.UUID;

import com.kiwimini.sharedmodels.model.Battery;

public class BatteryDto extends Battery {
    private UUID id;
    private String name;
    private int energyInputPerHour;
}