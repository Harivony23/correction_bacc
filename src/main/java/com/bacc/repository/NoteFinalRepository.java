package com.bacc.repository;

import com.bacc.entity.NoteFinal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteFinalRepository extends JpaRepository<NoteFinal, Long> {
    NoteFinal findByCandidatIdAndMatiereId(Long candidatId, Long matiereId);
}
