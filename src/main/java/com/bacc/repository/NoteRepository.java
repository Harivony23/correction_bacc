package com.bacc.repository;

import com.bacc.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findByCandidatIdAndMatiereId(Long candidatId, Long matiereId);
}
