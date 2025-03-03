package com.kiwimini.thingsapi.controller;
// package com.kiwimini.things.controller;

// import java.util.Optional;
// import java.util.UUID;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;

// import com.kiwimini.things.model.Battery;
// import com.kiwimini.things.repository.BatteryRepository;

// @RestController
// public class ThingController {

// @Autowired
// private BatteryRepository batteryRepository;

// @GetMapping("/thing/battery/{id}")
// public ResponseEntity<Battery> getBattery(@PathVariable UUID id) {
// try {
// Optional<Battery> battery = batteryRepository.findById(id);

// return battery.map(ResponseEntity::ok).orElseGet(() ->
// ResponseEntity.notFound().build());
// } catch (IllegalArgumentException e) {
// return ResponseEntity.badRequest().build();
// }
// }

// @PostMapping("/thing/battery")
// public Battery createBattery(@RequestBody Battery battery) {
// return batteryRepository.save(battery);
// }

// @PutMapping("/thing/battery/{id}")
// public ResponseEntity<Battery> updateBattery(@PathVariable UUID id,
// @RequestBody Battery batteryDetails) {
// try {
// Optional<Battery> optionalBattery = batteryRepository.findById(id);

// if (optionalBattery.isPresent()) {
// Battery battery = optionalBattery.get();
// battery.setName(batteryDetails.getName());
// battery.setEnergyInputPerHour(batteryDetails.getEnergyInputPerHour());
// return ResponseEntity.ok(batteryRepository.save(battery));
// } else {
// return ResponseEntity.notFound().build();
// }
// } catch (IllegalArgumentException e) {
// return ResponseEntity.badRequest().build();
// }
// }

// @DeleteMapping("/thing/battery/{id}")
// public ResponseEntity<Void> deleteBattery(@PathVariable UUID id) {
// try {
// if (batteryRepository.existsById(id)) {
// batteryRepository.deleteById(id);
// return ResponseEntity.noContent().build();
// } else {
// return ResponseEntity.notFound().build();
// }
// } catch (IllegalArgumentException e) {
// return ResponseEntity.badRequest().build();
// }
// }

// }