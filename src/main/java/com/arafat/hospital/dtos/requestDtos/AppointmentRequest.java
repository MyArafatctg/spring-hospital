package com.arafat.hospital.dtos.requestDtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AppointmentRequest {
    private LocalDateTime appointmentDate;
    private String reason;
}
