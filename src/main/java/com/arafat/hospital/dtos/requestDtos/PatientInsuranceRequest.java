package com.arafat.hospital.dtos.requestDtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientInsuranceRequest {
    private Long patientId;
    private Long insuranceId;
}
