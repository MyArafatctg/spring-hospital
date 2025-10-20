package com.arafat.hospital.dtos.requestDtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientAppointmentRequest {
    private Long patientId;
    private Long doctorId;
}
