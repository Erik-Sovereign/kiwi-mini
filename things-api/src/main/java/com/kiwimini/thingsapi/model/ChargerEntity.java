package com.kiwimini.thingsapi.model;

import com.kiwimini.sharedmodels.model.Charger;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "chargers")
@NoArgsConstructor
public class ChargerEntity extends Charger {

}