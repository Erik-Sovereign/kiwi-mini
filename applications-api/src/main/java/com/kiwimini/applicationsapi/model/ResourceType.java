package com.kiwimini.applicationsapi.model;

import com.kiwimini.sharedmodels.model.Battery;
import com.kiwimini.sharedmodels.model.Charger;
import com.kiwimini.sharedmodels.model.SolarPanel;

public enum ResourceType {
    BATTERY("/batteries", Battery.class),
    CHARGER("/chargers", Charger.class),
    SOLARPANEL("/solarpanels", SolarPanel.class);

    public final String path;
    public final Class<?> type;

    ResourceType(String path, Class<?> type) {
        this.path = path;
        this.type = type;
    }
}