package com.kiwimini.thingsapi.model;

import com.kiwimini.sharedmodels.model.Battery;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "batteries")
public class BatteryEntity extends Battery {

}
