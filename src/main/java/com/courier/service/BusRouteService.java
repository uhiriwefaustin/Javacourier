package com.courier.service;

import com.courier.model.BusRoute;
import com.courier.repository.BusRouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BusRouteService {
    @Autowired private BusRouteRepository repository;
    public List<BusRoute> findAll() { return repository.findAll(); }
    public BusRoute findById(Long id) { return repository.findById(id).orElse(null); }
    public BusRoute save(BusRoute route) { return repository.save(route); }
    public void delete(Long id) { repository.deleteById(id); }
}
