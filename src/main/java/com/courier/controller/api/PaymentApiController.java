package com.courier.controller.api;

import com.courier.model.Payment;
import com.courier.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentApiController {
    @Autowired private PaymentService service;
    @GetMapping public List<Payment> getAll() { return service.findAll(); }
    @GetMapping("/{id}") public ResponseEntity<Payment> getById(@PathVariable Long id) {
        Payment payment = service.findById(id);
        return payment != null ? ResponseEntity.ok(payment) : ResponseEntity.notFound().build();
    }
    @PostMapping public Payment create(@RequestBody Payment payment) { return service.save(payment); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
