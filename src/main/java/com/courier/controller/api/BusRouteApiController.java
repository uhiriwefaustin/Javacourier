package com.courier.controller.api;

import com.courier.model.BusRoute;
import com.courier.service.BusRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/bus-routes")
public class BusRouteApiController {
    @Autowired private BusRouteService service;
    @GetMapping public List<BusRoute> getAll() { return service.findAll(); }
    @GetMapping("/{id}") public ResponseEntity<BusRoute> getById(@PathVariable Long id) {
        BusRoute route = service.findById(id);
        return route != null ? ResponseEntity.ok(route) : ResponseEntity.notFound().build();
    }
    @PostMapping public BusRoute create(@RequestBody BusRoute route) { return service.save(route); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
