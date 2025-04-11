
package com.jpacourse.persistance.dao.impl;

import com.jpacourse.persistance.entity.DoctorEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import org.springframework.stereotype.Repository;

import com.jpacourse.persistance.dao.PatientDao;
import com.jpacourse.persistance.entity.PatientEntity;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {
    @Override
    public VisitEntity CreateVisit(long patientId, long doctorId, LocalDateTime dateTime, String description) {
        VisitEntity visit = new VisitEntity();
        visit.setDescription(description);
        visit.setTime(dateTime);
        visit.setPatient(entityManager.getReference(PatientEntity.class, patientId));
        visit.setDoctor(entityManager.getReference(DoctorEntity.class, doctorId));
        entityManager.persist(visit);
        return visit;
    }

    @Override
    public List<PatientEntity> getPatientsWithHeightGreaterThan(int height) {
        String hql = "FROM PatientEntity p WHERE p.height > :height";
        return entityManager.createQuery(hql, PatientEntity.class)
                .setParameter("height", height)
                .getResultList();
    }

    @Override
    public List<PatientEntity> getPatientsWithVisitCountGreaterThan(int count) {
        String hql = "FROM PatientEntity p JOIN VisitEntity PV ON p.id = PV.patient.id GROUP BY p.id HAVING COUNT(PV) > :visitCount";
        return entityManager.createQuery(hql, PatientEntity.class)
                .setParameter("visitCount", count)
                .getResultList();
    }

    @Override
    public List<PatientEntity> findByLastName(String lastName) {
        String hql = "FROM PatientEntity p WHERE p.lastName = :lastName";
        return entityManager.createQuery(hql, PatientEntity.class)
                .setParameter("lastName", lastName)
                .getResultList();
    }

    @Override
    public List<PatientEntity> findByHeight(int height) {
        String hql = "FROM PatientEntity p WHERE p.height >= :height";
        return entityManager.createQuery(hql, PatientEntity.class)
                .setParameter("height", height)
                .getResultList();
    }

}
