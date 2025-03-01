package com.teamapplicationmini.things.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teamapplicationmini.things.model.Battery;

public interface BatteryRepository extends JpaRepository<Battery, String> {
}