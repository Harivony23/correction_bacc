package com.bacc.repository;

import com.bacc.entity.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatRepository extends JpaRepository<Candidat, Long> {
}
