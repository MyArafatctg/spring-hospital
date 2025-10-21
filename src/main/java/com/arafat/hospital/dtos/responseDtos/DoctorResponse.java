package com.arafat.hospital.dtos.responseDtos;

import com.arafat.hospital.entities.Appointment;
import com.arafat.hospital.entities.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorResponse {
    private Long id;
    private String name;
    private String specialisation;
    private String email;
    private List<PatientAppointment> appointment;
    private Set<DepartmentResponse> departments;
}
