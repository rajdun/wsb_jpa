
package com.jpacourse.service.impl;

import static com.jpacourse.mapper.PatientMapper.mapToTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.jpacourse.dto.VisitTO;
import com.jpacourse.mapper.PatientMapper;
import com.jpacourse.mapper.VisitMapper;
import com.jpacourse.persistance.dao.VisitDao;
import com.jpacourse.persistance.entity.VisitEntity;
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
	private final VisitDao visitDao;

	@Autowired
	public PatientServiceImpl(PatientDao patientDao, VisitDao visitDao) {

		Assert.notNull(patientDao, "patientDao must not be null");
		Assert.notNull(visitDao, "visitDao must not be null");

		this.patientDao = patientDao;
		this.visitDao = visitDao;
	}

	@Override
	public Optional<PatientTO> findById(long id) {

		PatientEntity patient = patientDao.findOne(id);

		return Optional.ofNullable(mapToTO(patient));
	}

	@Override
	public Optional<VisitTO> AddVisit(int patientId, int doctorId, LocalDateTime time, String description) {
		VisitEntity visit = patientDao.CreateVisit(patientId, doctorId, time, description);

		return Optional.ofNullable(VisitMapper.toVisitTO(visit));
	}

	@Override
	public List<PatientTO> getPatientsWithVisitCountGreaterThan(int count) {
		return patientDao.getPatientsWithVisitCountGreaterThan(count)
				.stream()
				.map(PatientMapper::mapToTO)
				.toList();
	}

	@Override
	public List<PatientTO> getPatientsWithHeightGreaterThan(int height) {
		return patientDao.getPatientsWithHeightGreaterThan(height)
				.stream()
				.map(PatientMapper::mapToTO)
				.toList();
	}

	@Override
	public List<VisitTO> getVisitsByPatientId(long patientId) {
		return visitDao.getVisitsByPatientId(patientId)
				.stream()
				.map(VisitMapper::toVisitTO)
				.toList();
	}
}
