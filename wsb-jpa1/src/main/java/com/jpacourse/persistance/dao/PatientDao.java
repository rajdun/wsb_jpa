package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


public interface PatientDao extends Dao<PatientEntity, Long> {
    VisitEntity createVisit(long patientId, long doctorId, LocalDateTime dateTime, String description);

    List<PatientEntity> getPatientsWithVisitCountGreaterThan(int count);

    List<PatientEntity> getPatientsWithHeightGreaterThan(int height);

    List<PatientEntity> findByLastName(String lastName);

    List<PatientEntity> findByHeight(int height);

    void deleteById(long id);

    @Query("SELECT p FROM PatientEntity p LEFT JOIN FETCH p.visits v WHERE p.id = :id AND (v.time < CURRENT_TIMESTAMP OR v IS NULL)")
    Optional<PatientEntity> findByIdWithPastVisits(@Param("id") long id);
}
