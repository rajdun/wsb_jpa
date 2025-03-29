package com.jpacourse.mapper;

import com.jpacourse.dto.DoctorTO;
import com.jpacourse.persistance.entity.DoctorEntity;
import jakarta.annotation.Nullable;

public class DoctorMapper {
    public static DoctorTO toDoctorTO(@Nullable DoctorEntity doctor) {
        return doctor == null ? null : new DoctorTO(
                doctor.getId(),
                doctor.getFirstName(),
                doctor.getLastName(),
                doctor.getSpecialization().name(),
                doctor.getTelephoneNumber(),
                doctor.getEmail(),
                doctor.getDoctorNumber(),
                AddressMapper.mapToTO(doctor.getAddress())
        );
    }
}
