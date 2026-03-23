package com.courier.controller.api;

import com.courier.model.Tracking;
import com.courier.service.TrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tracking")
public class TrackingApiController {
    @Autowired private TrackingService service;
    @GetMapping public List<Tracking> getAll() { return service.findAllTracking(); }
    @GetMapping("/{id}") public ResponseEntity<Tracking> getById(@PathVariable Long id) {
        Tracking tracking = service.findById(id);
        return tracking != null ? ResponseEntity.ok(tracking) : ResponseEntity.notFound().build();
    }
    @PostMapping public Tracking create(@RequestBody Tracking tracking) { return service.saveTracking(tracking); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteTracking(id);
        return ResponseEntity.noContent().build();
    }
}
