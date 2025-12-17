package com.escolaconecta.api.model;
import java.security.Identity;

import javax.annotation.processing.Generated;

import jakarta.persistence.*; 
import lombok.Data;

@Data
@Entity
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @Column(unique = true)//sem repetição de email here
    private String email;

    private String password;

    
}