package com.escolaconecta.api.repository;

import com.escolaconecta.api.model.Warning;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WarningRepository extends JpaRepository<Warning, Long> {
    
    // Busca todas as advertências de um aluno específico
    List<Warning> findByStudentId(Long studentId);
}