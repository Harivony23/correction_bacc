package com.bacc.repository;

import com.bacc.entity.Parametre;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ParametreRepository extends JpaRepository<Parametre, Long> {
    List<Parametre> findByMatiereId(Long matiereId);
}
