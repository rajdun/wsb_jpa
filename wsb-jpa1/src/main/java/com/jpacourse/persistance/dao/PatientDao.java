package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;

import java.time.LocalDateTime;
import java.util.List;


public interface PatientDao extends Dao<PatientEntity, Long> {
    VisitEntity CreateVisit(long patientId, long doctorId, LocalDateTime dateTime, String description);
    List<PatientEntity> getPatientsWithVisitCountGreaterThan(int count);
    List<PatientEntity> getPatientsWithHeightGreaterThan(int height);
}
