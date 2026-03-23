package com.courier.service;

import com.courier.model.Receiver;
import com.courier.repository.ReceiverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReceiverService {
    @Autowired private ReceiverRepository repository;
    public List<Receiver> findAll() { return repository.findAll(); }
    public Receiver findById(Long id) { return repository.findById(id).orElse(null); }
    public Receiver save(Receiver receiver) { return repository.save(receiver); }
    public void delete(Long id) { repository.deleteById(id); }
}
