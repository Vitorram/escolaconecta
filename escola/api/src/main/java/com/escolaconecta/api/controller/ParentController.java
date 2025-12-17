package com.escolaconecta.api.controller;

import com.escolaconecta.api.model.Student;
import com.escolaconecta.api.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Diz ao Spring que isso é uma API REST
@RequestMapping("/parents") // Todas as URLs aqui começam com /parents
public class ParentController {

    private final StudentRepository studentRepository;

    // Injeção de dependência via construtor (Melhor prática que @Autowired)
    public ParentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Rota: GET /parents/{parentId}/students
    // Exemplo: /parents/1/students (Pega os filhos do pai com ID 1)
    @GetMapping("/{parentId}/students")
    public List<Student> getChildren(@PathVariable Long parentId) {
        return studentRepository.findByParentId(parentId);
    }
}