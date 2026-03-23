package com.courier.controller.api;

import com.courier.model.Receiver;
import com.courier.service.ReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/receivers")
public class ReceiverApiController {
    @Autowired private ReceiverService service;
    @GetMapping public List<Receiver> getAll() { return service.findAll(); }
    @GetMapping("/{id}") public ResponseEntity<Receiver> getById(@PathVariable Long id) {
        Receiver receiver = service.findById(id);
        return receiver != null ? ResponseEntity.ok(receiver) : ResponseEntity.notFound().build();
    }
    @PostMapping public Receiver create(@RequestBody Receiver receiver) { return service.save(receiver); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
