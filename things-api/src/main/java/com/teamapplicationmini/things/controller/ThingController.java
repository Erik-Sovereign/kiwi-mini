package com.teamapplicationmini.things.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.teamapplicationmini.things.model.Battery;

@RestController
public class ThingController {

    @GetMapping("/thing/battery/{id}")
    public Battery getBattery(@PathVariable String id) {
        return new String();
    }

}