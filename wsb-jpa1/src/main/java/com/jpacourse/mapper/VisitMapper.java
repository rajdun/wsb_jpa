package com.jpacourse.mapper;

import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistance.entity.VisitEntity;
import jakarta.annotation.Nullable;

public class VisitMapper {

    private VisitMapper() {
    }

    public static VisitTO toVisitTO(@Nullable VisitEntity visit) {
        return visit == null ? null : new VisitTO(
                visit.getId(),
                PatientMapper.mapToTO(visit.getPatient()),
                DoctorMapper.toDoctorTO(visit.getDoctor()),
                visit.getTime(),
                visit.getDescription()
        );
    }

    public static VisitTO toVisitTONoRelations(@Nullable VisitEntity visit) {
        return visit == null ? null : new VisitTO(
                visit.getId(),
                null,
                null,
                visit.getTime(),
                visit.getDescription()
        );
    }
}
