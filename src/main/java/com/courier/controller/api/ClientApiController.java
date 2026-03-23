package com.courier.controller.api;

import com.courier.model.Client;
import com.courier.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientApiController {
    @Autowired private ClientService service;
    @GetMapping public List<Client> getAll() { return service.findAll(); }
    @GetMapping("/{id}") public ResponseEntity<Client> getById(@PathVariable Long id) {
        Client client = service.findById(id);
        return client != null ? ResponseEntity.ok(client) : ResponseEntity.notFound().build();
    }
    @PostMapping public Client create(@RequestBody Client client) { return service.save(client); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
