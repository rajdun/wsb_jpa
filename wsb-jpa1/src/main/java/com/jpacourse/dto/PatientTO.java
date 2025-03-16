package com.jpacourse.dto;

public record PatientTO(Long id, String firstName, String lastName, AddressTO address, String telephoneNumber, String email, String patientNumber, String dateOfBirth) {

}
