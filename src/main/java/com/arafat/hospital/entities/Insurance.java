package com.arafat.hospital.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "INSURANCE")
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    private String insuranceProvider;

    private String insuranceNumber;

    private LocalDate validUntil;

    private LocalDate createdDate;
}
