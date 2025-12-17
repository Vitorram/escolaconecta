package com.escolaconecta.api.model;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@Entity
public class SchoolEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDate date;

    private String type;

    @ManyToOne
    @JoinColumn(name="school_id")
    private School school;
}