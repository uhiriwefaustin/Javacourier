package com.courier.service;

import com.courier.model.Package;
import com.courier.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PackageService {

    @Autowired
    private PackageRepository packageRepository;

    public List<Package> findAllPackages() {
        return packageRepository.findAll();
    }

    public Package savePackage(Package pkg) {
        if (pkg.getDateSent() == null) {
            pkg.setDateSent(LocalDateTime.now());
        }
        return packageRepository.save(pkg);
    }

    public Package findById(Long id) {
        return packageRepository.findById(id).orElse(null);
    }

    public void deletePackage(Long id) {
        packageRepository.deleteById(id);
    }
}
