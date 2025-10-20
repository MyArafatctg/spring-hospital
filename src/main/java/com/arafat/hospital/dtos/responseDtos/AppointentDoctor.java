package com.arafat.hospital.dtos.responseDtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointentDoctor {
    private Long id;
    private String name;
    private String specialisation;
    private String email;
}
