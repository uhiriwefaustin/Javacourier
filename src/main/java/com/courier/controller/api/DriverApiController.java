package com.courier.controller.api;

import com.courier.model.Driver;
import com.courier.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/drivers")
public class DriverApiController {
    @Autowired private DriverService service;
    @GetMapping public List<Driver> getAll() { return service.findAll(); }
    @GetMapping("/{id}") public ResponseEntity<Driver> getById(@PathVariable Long id) {
        Driver driver = service.findById(id);
        return driver != null ? ResponseEntity.ok(driver) : ResponseEntity.notFound().build();
    }
    @PostMapping public Driver create(@RequestBody Driver driver) { return service.save(driver); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
