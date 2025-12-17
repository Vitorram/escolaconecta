 package com.escolaconecta.api.model;
 
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity


public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String RA;

    @ManyToOne
    @JoinColumn(name="school_id")
    private School school;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;
    
 }