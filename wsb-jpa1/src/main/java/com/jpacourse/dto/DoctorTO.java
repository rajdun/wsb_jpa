package com.jpacourse.dto;

public record DoctorTO(long id, String firstName, String lastName, String specialization, String telephoneNumber,
                       String email, String doctorNumber, AddressTO address) {
}
