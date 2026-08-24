package com.example.myprofile.controller;

import com.example.myprofile.model.Contact;
import com.example.myprofile.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping({"/", "/index", "/home"})
    public String index(Model model) {
        model.addAttribute("contact", new Contact());
        return "index";
    }

    @PostMapping("/contact")
    public String submitContact(@Valid @ModelAttribute("contact") Contact contact, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // stay on index and show validation errors
            return "index";
        }
        contactService.save(contact);
        return "contact/thanks";
    }

    @GetMapping("/contact/thanks")
    public String thanks() {
        return "contact/thanks";
    }
}
