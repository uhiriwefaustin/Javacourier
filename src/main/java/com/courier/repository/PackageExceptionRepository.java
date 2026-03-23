package com.courier.repository;

import com.courier.model.PackageException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackageExceptionRepository extends JpaRepository<PackageException, Long> {
    List<PackageException> findByPkg_PackageId(Long packageId);
}
