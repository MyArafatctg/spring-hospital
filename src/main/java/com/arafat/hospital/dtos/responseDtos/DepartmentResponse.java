package com.arafat.hospital.dtos.responseDtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class DepartmentResponse {
    private Long id;
    private String name;
    private Set<AppointmentDoctor> doctors;
}
