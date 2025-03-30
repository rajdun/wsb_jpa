package com.jpacourse.dto;

import java.util.List;

public record PatientTO(Long id, String firstName, String lastName, AddressTO address, String telephoneNumber, String email, String patientNumber, String dateOfBirth, Integer height, List<VisitTO> visits) {

}
