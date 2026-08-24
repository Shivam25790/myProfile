package com.example.myprofile;

import com.example.myprofile.model.Profile;
import com.example.myprofile.repository.ProfileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {
    @Bean
    CommandLineRunner init(ProfileRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                repo.save(new Profile("Shivam Dhard", "shivam@example.com", "Java developer.", "Java, Spring Boot, SQL", "https://linkedin.example/shivam", "https://github.example/shivam"));
            }
        };
    }
}
