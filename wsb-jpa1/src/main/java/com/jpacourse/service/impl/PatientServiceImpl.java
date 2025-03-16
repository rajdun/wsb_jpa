
package com.jpacourse.service.impl;

import static com.jpacourse.mapper.PatientMapper.mapToTO;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.persistance.dao.PatientDao;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.service.PatientService;


@Service
public class PatientServiceImpl implements PatientService {

	private final PatientDao patientDao;

	@Autowired
	public PatientServiceImpl(PatientDao patientDao) {

		Assert.notNull(patientDao, "patientDao must not be null");

		this.patientDao = patientDao;
	}

	@Override
	public Optional<PatientTO> findById(long id) {

		PatientEntity patient = patientDao.findOne(id);

		return Optional.ofNullable(mapToTO(patient));
	}

}
