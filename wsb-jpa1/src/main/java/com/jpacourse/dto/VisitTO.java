package com.jpacourse.dto;

import java.time.LocalDateTime;

public record VisitTO(long id, PatientTO patientId, DoctorTO doctorId, LocalDateTime dateTime, String description) {

}
