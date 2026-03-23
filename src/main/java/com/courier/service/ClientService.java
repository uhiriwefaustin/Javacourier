package com.courier.service;

import com.courier.model.Client;
import com.courier.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientService {
    @Autowired private ClientRepository repository;
    public List<Client> findAll() { return repository.findAll(); }
    public Client findById(Long id) { return repository.findById(id).orElse(null); }
    public Client save(Client client) { return repository.save(client); }
    public void delete(Long id) { repository.deleteById(id); }
}
