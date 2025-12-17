package com.escolaconecta.api.repository;

import com.escolaconecta.api.model.SchoolEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SchoolEventRepository extends JpaRepository<SchoolEvent, Long> {
    
    // Busca todos os eventos de uma escola, ordenados por data (mais recentes primeiro?)
    // Aqui vamos pegar pela data
    List<SchoolEvent> findBySchoolIdOrderByDateDesc(Long schoolId);
}