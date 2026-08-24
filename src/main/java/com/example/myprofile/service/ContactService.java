package com.example.myprofile.service;

import com.example.myprofile.model.Contact;
import com.example.myprofile.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    private final ContactRepository repo;

    public ContactService(ContactRepository repo) { this.repo = repo; }

    public Contact save(Contact c) { return repo.save(c); }
    public List<Contact> findAll() { return repo.findAll(); }
}
