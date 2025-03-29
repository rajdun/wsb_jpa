package com.jpacourse.persistance.dao.impl;

import com.jpacourse.persistance.dao.VisitDao;
import com.jpacourse.persistance.entity.VisitEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VisitDaoImpl extends AbstractDao<VisitEntity, Long> implements VisitDao {
    @Override
    public List<VisitEntity> getVisitsByPatientId(Long patientId) {
        String hql = "FROM VisitEntity v WHERE v.patient.id = :patientId";
        return entityManager.createQuery(hql, VisitEntity.class)
                .setParameter("patientId", patientId)
                .getResultList();
    }
}
