package com.escolaconecta.api.repository;
import com.escolaconecta.api.model.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ParentRepository extends JpaRepository<Parent, Long> {
    
}
