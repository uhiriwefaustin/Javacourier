package com.courier.controller.api;

import com.courier.model.Station;
import com.courier.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/stations")
public class StationApiController {
    @Autowired private StationService service;
    @GetMapping public List<Station> getAll() { return service.findAll(); }
    @GetMapping("/{id}") public ResponseEntity<Station> getById(@PathVariable Long id) {
        Station station = service.findById(id);
        return station != null ? ResponseEntity.ok(station) : ResponseEntity.notFound().build();
    }
    @PostMapping public Station create(@RequestBody Station station) { return service.save(station); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
