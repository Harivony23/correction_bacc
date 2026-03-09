package com.bacc.controller;

import com.bacc.entity.Correcteur;
import com.bacc.repository.CorrecteurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/correcteurs")
@RequiredArgsConstructor
public class CorrecteurController {
    private final CorrecteurRepository repository;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("elements", repository.findAll());
        return "correcteur/list";
    }

    @PostMapping
    public String save(Correcteur entity) {
        repository.save(entity);
        return "redirect:/correcteurs";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/correcteurs";
    }
}
