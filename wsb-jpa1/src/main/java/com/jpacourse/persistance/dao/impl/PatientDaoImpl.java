package com.jpacourse.persistance.dao.impl;

import com.jpacourse.persistance.dao.DoctorDao;
import com.jpacourse.persistance.dao.PatientDao;
import com.jpacourse.persistance.entity.DoctorEntity;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {

    @Autowired
    private DoctorDao doctorDao;

    @Override
    public VisitEntity CreateVisit(long patientId, long doctorId, LocalDateTime dateTime, String description) {

        PatientEntity patientEntity = findOne(patientId);
        DoctorEntity doctorEntity = doctorDao.findOne(doctorId);

        VisitEntity visit = new VisitEntity();
        visit.setDescription(description);
        visit.setTime(dateTime);
        visit.setPatient(patientEntity);
        visit.setDoctor(doctorEntity);
        //  entityManager.persist(visit);

        patientEntity.getVisits().add(visit);

        update(patientEntity);

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

    @Override
    public void deleteById(long id) {
        PatientEntity patient = entityManager.find(PatientEntity.class, id);
        if (patient != null) {
            entityManager.remove(patient);
        }
    }
}
