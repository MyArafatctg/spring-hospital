package com.arafat.hospital.services.impl;

import com.arafat.hospital.dtos.requestDtos.DoctorRequest;
import com.arafat.hospital.dtos.responseDtos.DoctorResponse;
import com.arafat.hospital.mappers.DoctorMapper;
import com.arafat.hospital.repositories.DoctorRepository;
import com.arafat.hospital.services.DoctorServices;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DoctorSericeImpl implements DoctorServices {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper mapper;

    @Override
    public List<DoctorResponse> getAll() {
        return doctorRepository.findAll()
                .stream()
                .map(mapper::toDoctorResponse)
                .toList();
    };

    @Override
    public DoctorResponse findById(Long id) {
        return doctorRepository.findById(id).map(mapper::toDoctorResponse).orElseThrow(
                () -> new EntityNotFoundException("Doctor with id " + id + " not found")
        );
    }

    @Override
    public DoctorResponse create(DoctorRequest request) {
        return mapper.toDoctorResponse(doctorRepository.save(mapper.toDoctor(request)));
    }

    @Override
    public DoctorResponse update(DoctorRequest request, Long id) {
        var doctor = doctorRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Doctor with id " + id + " not found")
        );

        doctor.setName( request.getName() );
        doctor.setEmail( request.getEmail() );
        doctor.setSpecialisation(request.getSpecialisation());

        return mapper.toDoctorResponse(doctorRepository.save(doctor));
    }

    @Override
    public void deleteById(Long id) {
        doctorRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Doctor with id " + id + " not found")
        );

        doctorRepository.deleteById(id);
    }
}
