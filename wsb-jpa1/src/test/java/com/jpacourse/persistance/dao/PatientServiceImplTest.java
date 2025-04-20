package com.jpacourse.persistance.dao;

import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistance.dao.DoctorDao;
import com.jpacourse.persistance.dao.PatientDao;
import com.jpacourse.persistance.dao.VisitDao;
import com.jpacourse.persistance.entity.VisitEntity;
import com.jpacourse.service.PatientService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
class PatientServiceIntegrationTest {

	@Autowired
	private PatientService patientService;

	@Autowired
	private PatientDao patientDao;

	@Autowired
	private VisitDao visitDao;

	@Autowired
	private DoctorDao doctorDao;

	@Test
	void shouldFindVisitsByPatientId() {

		long patientId = 201;

		List<VisitTO> visits = patientService.getVisitsByPatientId(patientId);

		assertNotNull(visits);
		assertFalse(visits.isEmpty(), "Lista wizyt nie powinna być pusta");
		System.out.println("Znaleziono " + visits.size() + " wizyt dla pacjenta o ID " + patientId);
	}

	@Test
	void shouldDeletePatientAndCascadeVisits() {

		// Given
		long patientId = 201;
		int doctorCount = doctorDao.findAll().size();

		List<Long> visitIds = visitDao.getVisitsByPatientId(patientId).stream()
			.map(VisitEntity::getId)
			.toList();

		// When
		patientService.deleteById(patientId);

		// Then
		assertThat(patientService.findById(patientId)).isEmpty();

		assertThat(visitIds).noneMatch(visitId -> visitDao.exists(visitId));

		assertThat(doctorDao.findAll()).hasSize(doctorCount);
	}

}
