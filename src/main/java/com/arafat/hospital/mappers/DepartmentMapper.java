package com.arafat.hospital.mappers;

import com.arafat.hospital.dtos.requestDtos.DepartmentRequest;
import com.arafat.hospital.dtos.responseDtos.AppointmentDoctor;
import com.arafat.hospital.dtos.responseDtos.DepartmentResponse;
import com.arafat.hospital.dtos.responseDtos.DoctorResponse;
import com.arafat.hospital.entities.Department;
import com.arafat.hospital.entities.Doctor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class DepartmentMapper {
    public DepartmentResponse toDepartmentResponse(Department department) {
        DepartmentResponse departmentResponse = new DepartmentResponse();

        departmentResponse.setId(department.getId());
        departmentResponse.setName(department.getName());
        departmentResponse.setDoctors(department.getDoctors()
                .stream()
                .map(this::toDoctorResponse)
                .collect(Collectors.toSet()));
        return departmentResponse;
    }

    public Department toDepartment(DepartmentRequest departmentRequest) {
        Department department = new Department();

        department.setName(departmentRequest.getName());

        return department;
    }

    private AppointmentDoctor  toDoctorResponse(Doctor doctor) {
        AppointmentDoctor appointmentDoctor = new AppointmentDoctor();

        appointmentDoctor.setId(doctor.getId());
        appointmentDoctor.setName(doctor.getName());
        appointmentDoctor.setEmail(doctor.getEmail());
        appointmentDoctor.setSpecialisation(doctor.getSpecialisation());

        return appointmentDoctor;
    }


}
