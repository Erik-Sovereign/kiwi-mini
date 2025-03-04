package com.kiwimini.thingsapi.model;

import com.kiwimini.sharedmodels.model.Battery;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "batteries")
@NoArgsConstructor
public class BatteryEntity extends Battery {

}
