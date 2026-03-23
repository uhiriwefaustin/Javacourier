package com.courier.service;

import com.courier.model.Tracking;
import com.courier.repository.TrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackingService {

    @Autowired
    private TrackingRepository trackingRepository;

    public List<Tracking> getTrackingHistory(Long packageId) {
        return trackingRepository.findByPkg_PackageIdOrderByTimestampDesc(packageId);
    }

    public Tracking saveTracking(Tracking tracking) {
        return trackingRepository.save(tracking);
    }
}
