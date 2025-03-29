package com.jpacourse.persistance.dao.impl;

import com.jpacourse.persistance.dao.DoctorDao;
import com.jpacourse.persistance.entity.DoctorEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DoctorDaoImpl extends AbstractDao<DoctorEntity, Long> implements DoctorDao {
    @Override
    public List<DoctorEntity> getDoctorByLastName(String lastName) {
        String hql = "FROM DoctorEntity d WHERE d.lastName = :lastName";
        return entityManager.createQuery(hql, DoctorEntity.class)
                .setParameter("lastName", lastName)
                .getResultList();
    }
}
