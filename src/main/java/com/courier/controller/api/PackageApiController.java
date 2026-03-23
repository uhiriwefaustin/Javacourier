package com.courier.controller.api;

import com.courier.model.Package;
import com.courier.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/packages")
public class PackageApiController {

    @Autowired
    private PackageService packageService;

    @GetMapping
    public List<Package> getAllPackages() {
        return packageService.findAllPackages();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Package> getPackageById(@PathVariable Long id) {
        Package pkg = packageService.findById(id);
        return pkg != null ? ResponseEntity.ok(pkg) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Package createPackage(@RequestBody Package pkg) {
        return packageService.savePackage(pkg);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Package> updatePackage(@PathVariable Long id, @RequestBody Package pkgDetails) {
        Package pkg = packageService.findById(id);
        if (pkg == null) return ResponseEntity.notFound().build();
        
        pkg.setStatus(pkgDetails.getStatus());
        pkg.setWeight(pkgDetails.getWeight());
        pkg.setDeliveryFee(pkgDetails.getDeliveryFee());
        
        return ResponseEntity.ok(packageService.savePackage(pkg));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePackage(@PathVariable Long id) {
        packageService.deletePackage(id);
        return ResponseEntity.noContent().build();
    }
}
