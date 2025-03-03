package com.kiwimini.thingsapi.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.kiwimini.thingsapi.model.SolarPanel;

@RepositoryRestResource(path = "solarpanels")
public interface SolarPanelRepository extends CrudRepository<SolarPanel, UUID> {
}