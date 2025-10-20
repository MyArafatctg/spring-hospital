package com.arafat.hospital.dtos.requestDtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientRequest {
    private String name;
    private String gender;
    private String email;
    private String mobileNumber;
}
