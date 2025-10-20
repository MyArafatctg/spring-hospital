package com.arafat.hospital.mappers;

import com.arafat.hospital.dtos.requestDtos.DepartmentRequest;
import com.arafat.hospital.dtos.responseDtos.DepartmentResponse;
import com.arafat.hospital.entities.Department;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMapper {
    public DepartmentResponse toDepartmentResponse(Department department) {
        DepartmentResponse departmentResponse = new DepartmentResponse();

        departmentResponse.setId(department.getId());
        departmentResponse.setName(department.getName());
        departmentResponse.setDoctors(department.getDoctors());

        return departmentResponse;
    }

    public Department toDepartment(DepartmentRequest departmentRequest) {
        Department department = new Department();

        department.setName(departmentRequest.getName());

        return department;
    }
}
