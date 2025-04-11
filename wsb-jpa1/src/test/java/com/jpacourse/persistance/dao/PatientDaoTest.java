package com.jpacourse.persistance.dao;


import com.jpacourse.persistance.dao.impl.PatientDaoImpl;
import com.jpacourse.persistance.entity.PatientEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(PatientDaoImpl.class)


public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;

    @Test
    void shouldFindPatientByLastName() {

        // Given
        String lastName = "Zieliński";

        // When
        List<PatientEntity> patients = patientDao.findByLastName(lastName);

        // Then
        assertThat(patients).isNotEmpty();
        assertThat(patients.get(0).getLastName()).isEqualTo(lastName);
    }

    @Test

    void shouldFindPatientWithMoreThanOneVisit() {

        // Given
        int visitCount = 1;

        // When
        List<PatientEntity> patients = patientDao.getPatientsWithVisitCountGreaterThan(visitCount);

        // Then
        assertThat(patients).isNotEmpty();
        assertThat(patients.size()).isGreaterThan(visitCount);

    }

    @Test

    void shouldFindPatientWithHeightDefined() {

        // Given
        int height = 180;

        // When
        List<PatientEntity> patients = patientDao.findByHeight(height);

        // Then
        assertThat(patients).isNotEmpty();
        assertThat(patients.get(0).getHeight()).isGreaterThanOrEqualTo(height);

    }
}
