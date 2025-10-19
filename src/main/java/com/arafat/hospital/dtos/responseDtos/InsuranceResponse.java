package com.arafat.hospital.dtos.responseDtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class InsuranceResponse {
    private Long id;
    private String name;
    private String insuranceProvider;
    private String insuranceNumber;
    private LocalDate validUntil;
    private LocalDate createdDate;
}
