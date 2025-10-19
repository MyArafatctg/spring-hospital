package com.arafat.hospital.services;

import com.arafat.hospital.dtos.requestDtos.InsuranceRequest;
import com.arafat.hospital.dtos.responseDtos.InsuranceResponse;
import com.arafat.hospital.entities.Insurance;

import java.util.List;

public interface InsuranceService {
    List<InsuranceResponse> getInsurances();
    InsuranceResponse findById(Long id);
    InsuranceResponse createInsurance(InsuranceRequest insurance);
    InsuranceResponse updateInsurance(InsuranceRequest insurance, Long id);
    void deleteById(Long id);
}
