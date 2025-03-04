package com.kiwimini.thingsapi.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.kiwimini.thingsapi.model.BatteryEntity;

@RepositoryRestResource(path = "batteries", collectionResourceRel = "batteries")
public interface BatteryRepository extends CrudRepository<BatteryEntity, UUID> {
}