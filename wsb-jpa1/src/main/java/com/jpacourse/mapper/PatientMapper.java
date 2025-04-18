package com.jpacourse.mapper;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.persistance.entity.PatientEntity;
import jakarta.annotation.Nullable;

import java.util.Optional;


public class PatientMapper {

    private PatientMapper() {
    }

    public static PatientTO mapToTO(@Nullable PatientEntity patientEntity) {

        return Optional.ofNullable(patientEntity)
                .map(entity ->
                        new PatientTO(
                                entity.getId(),
                                entity.getFirstName(),
                                entity.getLastName(),
                                AddressMapper.mapToTO(entity.getAddress()),
                                entity.getTelephoneNumber(),
                                entity.getEmail(),
                                entity.getPatientNumber(),
                                entity.getDateOfBirth().toString(),
                                entity.getHeight(),
                                entity.getVisits()
                                        .stream()
                                        .map(VisitMapper::toVisitTONoRelations)
                                        .toList()
                        ))
                .orElse(null);
    }
}