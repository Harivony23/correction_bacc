package com.bacc.service;

import com.bacc.entity.*;
import com.bacc.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;
    private final ParametreRepository parametreRepository;
    private final NoteFinalRepository noteFinalRepository;

    public void calculerNoteFinal(Long candidatId, Long matiereId) {
        List<Note> notes = noteRepository.findByCandidatIdAndMatiereId(candidatId, matiereId);
        if (notes.isEmpty()) return;

        double sumNotes = 0;
        double maxNote = Double.MIN_VALUE;
        double minNote = Double.MAX_VALUE;

        for (Note n : notes) {
            sumNotes += n.getNote();
            if (n.getNote() > maxNote) maxNote = n.getNote();
            if (n.getNote() < minNote) minNote = n.getNote();
        }

        double moyenne = sumNotes / notes.size();

        double sommeDiff = 0;
        for (int i = 0; i < notes.size(); i++) {
            for (int j = i + 1; j < notes.size(); j++) {
                sommeDiff += Math.abs(notes.get(i).getNote() - notes.get(j).getNote());
            }
        }

        List<Parametre> parametres = parametreRepository.findByMatiereId(matiereId);

        double noteFinalValue = moyenne; // default

        for (Parametre p : parametres) {
            boolean matched = evaluerCondition(sommeDiff, p.getDiff(), p.getOperateur().getOperateur());
            if (matched) {
                String nomRes = p.getResolution().getNom().toLowerCase();
                if (nomRes.contains("moyenne")) {
                    noteFinalValue = moyenne;
                } else if (nomRes.contains("plus grand")) {
                    noteFinalValue = maxNote;
                } else if (nomRes.contains("plus petit")) {
                    noteFinalValue = minNote;
                }
                break;
            }
        }

        NoteFinal nf = noteFinalRepository.findByCandidatIdAndMatiereId(candidatId, matiereId);
        if (nf == null) {
            nf = new NoteFinal();
            Candidat c = new Candidat();
            c.setId(candidatId);
            nf.setCandidat(c);
            Matiere m = new Matiere();
            m.setId(matiereId);
            nf.setMatiere(m);
        }
        nf.setNotefinal(noteFinalValue);
        noteFinalRepository.save(nf);
    }

    private boolean evaluerCondition(double diffCalcule, double diffParam, String operateur) {
        // En fonction de la logique décrite: Seuil [operateur] Difference (ex: 3 > 4)
        if ("<".equals(operateur)) return diffParam < diffCalcule;
        if (">".equals(operateur)) return diffParam > diffCalcule;
        if ("<=".equals(operateur)) return diffParam <= diffCalcule;
        if (">=".equals(operateur)) return diffParam >= diffCalcule;
        if ("=".equals(operateur) || "==".equals(operateur)) return diffParam == diffCalcule;
        return false;
    }

    public Double getNoteFinal(Long candidatId, Long matiereId) {
        NoteFinal nf = noteFinalRepository.findByCandidatIdAndMatiereId(candidatId, matiereId);
        if (nf != null) return nf.getNotefinal();
        calculerNoteFinal(candidatId, matiereId);
        nf = noteFinalRepository.findByCandidatIdAndMatiereId(candidatId, matiereId);
        return nf != null ? nf.getNotefinal() : null;
    }
}
