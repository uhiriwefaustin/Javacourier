package com.courier.controller.api;

import com.courier.model.PackageType;
import com.courier.service.PackageTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/package-types")
public class PackageTypeApiController {
    @Autowired private PackageTypeService service;
    @GetMapping public List<PackageType> getAll() { return service.findAll(); }
    @GetMapping("/{id}") public ResponseEntity<PackageType> getById(@PathVariable Long id) {
        PackageType type = service.findById(id);
        return type != null ? ResponseEntity.ok(type) : ResponseEntity.notFound().build();
    }
    @PostMapping public PackageType create(@RequestBody PackageType type) { return service.save(type); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
