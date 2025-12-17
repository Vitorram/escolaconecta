package com.escolaconecta.api.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
}