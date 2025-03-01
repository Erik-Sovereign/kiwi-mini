package com.kiwimini.things.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kiwimini.things.model.Battery;

public interface BatteryRepository extends JpaRepository<Battery, String> {
}