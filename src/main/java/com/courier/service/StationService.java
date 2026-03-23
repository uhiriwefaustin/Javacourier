package com.courier.service;

import com.courier.model.Station;
import com.courier.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StationService {
    @Autowired private StationRepository repository;
    public List<Station> findAll() { return repository.findAll(); }
    public Station findById(Long id) { return repository.findById(id).orElse(null); }
    public Station save(Station station) { return repository.save(station); }
    public void delete(Long id) { repository.deleteById(id); }
}
