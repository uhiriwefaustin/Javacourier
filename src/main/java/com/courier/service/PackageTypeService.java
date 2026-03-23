package com.courier.service;

import com.courier.model.PackageType;
import com.courier.repository.PackageTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PackageTypeService {
    @Autowired private PackageTypeRepository repository;
    public List<PackageType> findAll() { return repository.findAll(); }
    public PackageType findById(Long id) { return repository.findById(id).orElse(null); }
    public PackageType save(PackageType type) { return repository.save(type); }
    public void delete(Long id) { repository.deleteById(id); }
}
