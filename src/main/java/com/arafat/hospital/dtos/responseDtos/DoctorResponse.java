package com.arafat.hospital.dtos.responseDtos;

import com.arafat.hospital.entities.Appointment;
import com.arafat.hospital.entities.Department;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class DoctorResponse {
    private Long id;
    private String name;
    private String specialisation;
    private String email;
    private List<Appointment> appointment;
    private Set<Department> departments;
}
