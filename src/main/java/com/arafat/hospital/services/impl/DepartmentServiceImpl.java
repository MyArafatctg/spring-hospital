package com.arafat.hospital.services.impl;

import com.arafat.hospital.dtos.requestDtos.DepartmentRequest;
import com.arafat.hospital.dtos.responseDtos.AppointmentDoctor;
import com.arafat.hospital.dtos.responseDtos.DepartmentResponse;
import com.arafat.hospital.mappers.DepartmentMapper;
import com.arafat.hospital.repositories.DepartmentRepository;
import com.arafat.hospital.services.DepartmentService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper mapper;

    @Override
    public List<DepartmentResponse> getAll() {
        return departmentRepository.findAll()
                .stream()
                .map(mapper::toDepartmentResponse)
                .toList();
    };

    @Override
    public DepartmentResponse findById(Long id) {
        return departmentRepository.findById(id)
                .map(mapper::toDepartmentResponse)
                .orElseThrow(
                        () -> new EntityNotFoundException("Department with id " + id + " not found")
                );
    }

    @Override
    public DepartmentResponse create(DepartmentRequest request) {
        return mapper.toDepartmentResponse(departmentRepository.save(mapper.toDepartment(request)));
    }

    @Override
    public DepartmentResponse update(DepartmentRequest request, Long id) {
        var department = departmentRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Department with id " + id + " not found")
        );

        department.setName(request.getName());

        return mapper.toDepartmentResponse(departmentRepository.save(mapper.toDepartment(request)));
    }

    @Override
    public void deleteById(Long id) {
        departmentRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Department with id " + id + " not found")
        );

        departmentRepository.deleteById(id);
    }

    @Override
    public DepartmentResponse addDoctors(AppointmentDoctor doctor, Long id) {
        return null;
    }
}
