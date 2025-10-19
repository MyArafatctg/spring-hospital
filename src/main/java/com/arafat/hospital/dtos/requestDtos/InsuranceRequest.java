package com.arafat.hospital.dtos.requestDtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class InsuranceRequest {
    private String name;
    private String insuranceProvider;
    private String insuranceNumber;
    private LocalDate validUntil;
}
