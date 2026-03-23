package com.courier.controller.api;

import com.courier.model.PackageException;
import com.courier.service.PackageExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/exceptions")
public class PackageExceptionApiController {
    @Autowired private PackageExceptionService service;
    @GetMapping public List<PackageException> getAll() { return service.findAll(); }
    @GetMapping("/{id}") public ResponseEntity<PackageException> getById(@PathVariable Long id) {
        PackageException ex = service.findById(id);
        return ex != null ? ResponseEntity.ok(ex) : ResponseEntity.notFound().build();
    }
    @PostMapping public PackageException create(@RequestBody PackageException ex) { return service.save(ex); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
