package com.arafat.hospital.services.impl;

import com.arafat.hospital.dtos.requestDtos.InsuranceRequest;
import com.arafat.hospital.dtos.responseDtos.InsuranceResponse;
import com.arafat.hospital.mappers.InsuranceMapper;
import com.arafat.hospital.repositories.InsuranceRepository;
import com.arafat.hospital.services.InsuranceService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InsuranceServiceImpl implements InsuranceService {
    private final InsuranceRepository insuranceRepository;
    private final InsuranceMapper mapper;

    @Override
    public List<InsuranceResponse> getInsurances() {
        return insuranceRepository.findAll()
                .stream()
                .map(mapper::toInsuranceResponse)
                .toList();
    }

    @Override
    public InsuranceResponse findById(Long id) {
        return insuranceRepository.findById(id).map(mapper::toInsuranceResponse).orElseThrow(
                () -> new EntityNotFoundException("Insurance with id: " + id + " not found")
        );
    }

    @Override
    public InsuranceResponse createInsurance(InsuranceRequest request) {
        var insurance = mapper.toInsurance(request);
        return mapper.toInsuranceResponse(insuranceRepository.save(insurance));
    }

    @Override
    public InsuranceResponse updateInsurance(InsuranceRequest request, Long id) {
        var insurance = insuranceRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Insurance with id: " + id + " not found")
        );

        insurance.setName( request.getName() );
        insurance.setInsuranceNumber(request.getInsuranceNumber());
        insurance.setInsuranceProvider(request.getInsuranceProvider());
        insurance.setValidUntil(request.getValidUntil());

        return mapper.toInsuranceResponse(insuranceRepository.save(insurance));
    }

    @Override
    public void deleteById(Long id) {
        insuranceRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Insurance with id: " + id + " not found")
        );
        insuranceRepository.deleteById(id);
    }
}
