package com.arafat.hospital.dtos.requestDtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorRequest {
    private String name;
    private String specialisation;
    private String email;
}
