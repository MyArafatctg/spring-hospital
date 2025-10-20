package com.arafat.hospital.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "patient")
@Getter
@Setter
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @OneToOne
    @JoinColumn(name = "insurance_id")
    private Insurance insurance;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
    private List<Appointment> appointments;
}
