package com.courier.service;

import com.courier.model.Driver;
import com.courier.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DriverService {
    @Autowired private DriverRepository repository;
    public List<Driver> findAll() { return repository.findAll(); }
    public Driver findById(Long id) { return repository.findById(id).orElse(null); }
    public Driver save(Driver driver) { return repository.save(driver); }
    public void delete(Long id) { repository.deleteById(id); }
}
