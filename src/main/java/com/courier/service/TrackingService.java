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

    public List<Tracking> findAllTracking() {
        return trackingRepository.findAll();
    }

    public Tracking findById(Long id) {
        return trackingRepository.findById(id).orElse(null);
    }

    public Tracking saveTracking(Tracking tracking) {
        return trackingRepository.save(tracking);
    }

    public void deleteTracking(Long id) {
        trackingRepository.deleteById(id);
    }
}
