package com.kiwimini.thingsapi.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.kiwimini.sharedmodels.model.Battery;

@RepositoryRestResource(path = "batteries")
public interface BatteryRepository extends CrudRepository<Battery, UUID> {
}