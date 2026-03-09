package com.bacc.controller;

import com.bacc.entity.Candidat;
import com.bacc.repository.CandidatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/candidats")
@RequiredArgsConstructor
public class CandidatController {
    private final CandidatRepository repository;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("elements", repository.findAll());
        return "candidat/list";
    }

    @PostMapping
    public String save(Candidat entity) {
        repository.save(entity);
        return "redirect:/candidats";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/candidats";
    }
}
