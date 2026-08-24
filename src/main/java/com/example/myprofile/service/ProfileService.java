package com.example.myprofile.service;

import com.example.myprofile.model.Profile;
import com.example.myprofile.repository.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {
    private final ProfileRepository repo;

    public ProfileService(ProfileRepository repo) {
        this.repo = repo;
    }

    public List<Profile> findAll() { return repo.findAll(); }
    public Optional<Profile> findById(Long id) { return repo.findById(id); }
    public Profile save(Profile p) { return repo.save(p); }
    public void deleteById(Long id) { repo.deleteById(id); }
}
