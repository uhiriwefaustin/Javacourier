package com.courier.service;

import com.courier.model.PackageException;
import com.courier.repository.PackageExceptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PackageExceptionService {
    @Autowired private PackageExceptionRepository repository;
    public List<PackageException> findAll() { return repository.findAll(); }
    public PackageException findById(Long id) { return repository.findById(id).orElse(null); }
    public PackageException save(PackageException ex) { return repository.save(ex); }
    public void delete(Long id) { repository.deleteById(id); }
}
