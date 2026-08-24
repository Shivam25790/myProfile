package com.example.myprofile.controller;

import com.example.myprofile.model.Profile;
import com.example.myprofile.service.ProfileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/profiles")
public class ProfileController {
    private final ProfileService service;

    public ProfileController(ProfileService service) { this.service = service; }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("profiles", service.findAll());
        return "profiles/index";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("profile", new Profile());
        return "profiles/form";
    }

    @PostMapping
    public String create(@Valid @ModelAttribute("profile") Profile profile, BindingResult result) {
        if (result.hasErrors()) return "profiles/form";
        service.save(profile);
        return "redirect:/profiles";
    }

    @GetMapping("/{id}")
    public String view(@PathVariable Long id, Model model) {
        service.findById(id).ifPresent(p -> model.addAttribute("profile", p));
        return "profiles/view";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        service.findById(id).ifPresent(p -> model.addAttribute("profile", p));
        return "profiles/form";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @Valid @ModelAttribute("profile") Profile profile, BindingResult result) {
        if (result.hasErrors()) return "profiles/form";
        profile.setId(id);
        service.save(profile);
        return "redirect:/profiles";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/profiles";
    }
}
