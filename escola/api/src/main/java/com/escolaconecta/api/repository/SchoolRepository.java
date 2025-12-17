package com.escolaconecta.api.repository;

import com.escolaconecta.api.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Long> {
}
