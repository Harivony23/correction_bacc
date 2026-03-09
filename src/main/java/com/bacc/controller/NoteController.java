package com.bacc.controller;

import com.bacc.entity.Note;
import com.bacc.repository.CandidatRepository;
import com.bacc.repository.CorrecteurRepository;
import com.bacc.repository.MatiereRepository;
import com.bacc.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {
    private final NoteRepository repository;
    private final CandidatRepository candidatRepository;
    private final MatiereRepository matiereRepository;
    private final CorrecteurRepository correcteurRepository;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("elements", repository.findAll());
        model.addAttribute("candidats", candidatRepository.findAll());
        model.addAttribute("matieres", matiereRepository.findAll());
        model.addAttribute("correcteurs", correcteurRepository.findAll());
        return "note/list";
    }

    @PostMapping
    public String save(Note entity) {
        repository.save(entity);
        return "redirect:/notes";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/notes";
    }
}
