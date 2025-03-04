package com.kiwimini.thingsapi.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.kiwimini.thingsapi.model.ChargerEntity;

@RepositoryRestResource(path = "chargers", collectionResourceRel = "chargers")
public interface ChargerRepository extends CrudRepository<ChargerEntity, UUID> {
}