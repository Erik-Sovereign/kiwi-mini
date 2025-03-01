package com.kiwimini.things.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThingController {

    @GetMapping("/thing/battery/{id}")
    public String getBattery(@PathVariable String id) {
        return new String();
    }

}