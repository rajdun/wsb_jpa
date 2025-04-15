package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.DoctorEntity;

import java.util.List;

public interface DoctorDao extends Dao<DoctorEntity, Long> {
    List<DoctorEntity> getDoctorByLastName(String lastName);
}
