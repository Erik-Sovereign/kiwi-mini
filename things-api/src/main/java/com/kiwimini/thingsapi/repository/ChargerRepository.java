package com.kiwimini.thingsapi.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.kiwimini.thingsapi.model.Charger;

@RepositoryRestResource(path = "chargers")
public interface ChargerRepository extends CrudRepository<Charger, UUID> {
}