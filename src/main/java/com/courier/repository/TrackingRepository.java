package com.courier.repository;

import com.courier.model.Tracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackingRepository extends JpaRepository<Tracking, Long> {
    List<Tracking> findByPkg_PackageIdOrderByTimestampDesc(Long packageId);
}
