package com.kiwimini.things.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "batteries")
@Data
@NoArgsConstructor
public class Battery {
    @Id
    private String id;
    private String name;
    private Double energyInputPerHour;
}