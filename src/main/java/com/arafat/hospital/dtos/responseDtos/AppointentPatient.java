package com.arafat.hospital.dtos.responseDtos;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppointentPatient {
    private Long id;
    private String name;
    private String gender;
    private String email;
    private String mobileNumber;
}
