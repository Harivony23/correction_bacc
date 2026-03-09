package com.bacc.controller;

import com.bacc.entity.Parametre;
import com.bacc.repository.MatiereRepository;
import com.bacc.repository.OperateurRepository;
import com.bacc.repository.ParametreRepository;
import com.bacc.repository.ResolutionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/parametres")
@RequiredArgsConstructor
public class ParametreController {
    private final ParametreRepository repository;
    private final MatiereRepository matiereRepository;
    private final OperateurRepository operateurRepository;
    private final ResolutionRepository resolutionRepository;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("elements", repository.findAll());
        model.addAttribute("matieres", matiereRepository.findAll());
        model.addAttribute("operateurs", operateurRepository.findAll());
        model.addAttribute("resolutions", resolutionRepository.findAll());
        return "parametre/list";
    }

    @PostMapping
    public String save(Parametre entity) {
        repository.save(entity);
        return "redirect:/parametres";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/parametres";
    }
}
