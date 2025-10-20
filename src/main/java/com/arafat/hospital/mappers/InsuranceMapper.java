package com.arafat.hospital.mappers;

import com.arafat.hospital.dtos.requestDtos.InsuranceRequest;
import com.arafat.hospital.dtos.responseDtos.InsuranceResponse;
import com.arafat.hospital.entities.Insurance;
import org.springframework.stereotype.Component;

@Component
public class InsuranceMapper {
    public InsuranceResponse toInsuranceResponse(Insurance insurance) {
        InsuranceResponse response = new InsuranceResponse();
        response.setId(insurance.getId());
        response.setName(insurance.getName());
        response.setInsuranceProvider(insurance.getInsuranceProvider());
        response.setValidUntil(insurance.getValidUntil());
        response.setInsuranceNumber(insurance.getInsuranceNumber());
        response.setCreatedDate(insurance.getCreatedDate());
        return response;
    };

    public Insurance toInsurance(InsuranceRequest request) {
        Insurance insurance = new Insurance();
        insurance.setName(request.getName());
        insurance.setInsuranceProvider(request.getInsuranceProvider());
        insurance.setValidUntil(request.getValidUntil());
        insurance.setInsuranceNumber(request.getInsuranceNumber());

        return insurance;
    }
}
