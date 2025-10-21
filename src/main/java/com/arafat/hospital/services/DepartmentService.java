package com.arafat.hospital.services;

import com.arafat.hospital.dtos.requestDtos.DepartmentRequest;
import com.arafat.hospital.dtos.requestDtos.DoctorRequest;
import com.arafat.hospital.dtos.responseDtos.DepartmentResponse;

import java.util.List;

public interface DepartmentService {
    List<DepartmentResponse> getAll();
    DepartmentResponse findById(Long id);
    DepartmentResponse create(DepartmentRequest request);
    DepartmentResponse update(DepartmentRequest request, Long id);
    void deleteById(Long id);

    DepartmentResponse addNewDoctor(DoctorRequest doctor, Long id);
    DepartmentResponse addDoctorToDepartment(Long deptId, Long doctorId);
}
