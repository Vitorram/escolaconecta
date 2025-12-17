package com.escolaconecta.api.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
public class Warning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;       // Ex: "Conversa paralela"
    private String description; // Ex: "Aluno atrapalhou a aula..."
    private LocalDate date;     // Data do ocorrido

    // Relacionamento: Muitas advertências pertencem a UM aluno
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}