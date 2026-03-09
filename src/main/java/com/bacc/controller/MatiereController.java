package com.bacc.controller;

import com.bacc.entity.Matiere;
import com.bacc.repository.MatiereRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/matieres")
@RequiredArgsConstructor
public class MatiereController {
    private final MatiereRepository repository;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("elements", repository.findAll());
        return "matiere/list";
    }

    @PostMapping
    public String save(Matiere entity) {
        repository.save(entity);
        return "redirect:/matieres";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/matieres";
    }
}
