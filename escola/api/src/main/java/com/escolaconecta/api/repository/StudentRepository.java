package com.escolaconecta.api.repository;
import com.escolaconecta.api.model.Student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByParentId(Long parentId);
}
