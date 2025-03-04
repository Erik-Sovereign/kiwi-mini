package com.kiwimini.thingsapi.model;

import com.kiwimini.sharedmodels.model.SolarPanel;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "solarpanels")
@NoArgsConstructor
public class SolarPanelEntity extends SolarPanel {
}