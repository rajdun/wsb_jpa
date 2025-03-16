
package com.jpacourse.persistance.dao.impl;

import org.springframework.stereotype.Repository;

import com.jpacourse.persistance.dao.PatientDao;
import com.jpacourse.persistance.entity.PatientEntity;


@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {

}
