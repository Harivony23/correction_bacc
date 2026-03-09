package com.bacc.controller;

import com.bacc.entity.*;
import com.bacc.repository.*;
import com.bacc.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {

    private final CandidatRepository candidatRepository;
    private final MatiereRepository matiereRepository;
    private final NoteService noteService;

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/resultat")
    public String showResultForm(Model model) {
        model.addAttribute("candidats", candidatRepository.findAll());
        model.addAttribute("matieres", matiereRepository.findAll());
        return "resultat-form";
    }

    @PostMapping("/resultat")
    public String calculateResult(
            @RequestParam("candidatId") Long candidatId,
            @RequestParam("matiereId") Long matiereId,
            Model model) {
        
        noteService.calculerNoteFinal(candidatId, matiereId);
        Double finalNote = noteService.getNoteFinal(candidatId, matiereId);
        
        Candidat c = candidatRepository.findById(candidatId).orElse(null);
        Matiere m = matiereRepository.findById(matiereId).orElse(null);

        model.addAttribute("candidat", c);
        model.addAttribute("matiere", m);
        model.addAttribute("finalNote", finalNote);
        
        return "resultat-view";
    }

}
