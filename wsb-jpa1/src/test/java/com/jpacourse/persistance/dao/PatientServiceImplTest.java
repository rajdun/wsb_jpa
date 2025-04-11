package com.jpacourse.service;

import com.jpacourse.dto.VisitTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PatientServiceIntegrationTest {

    @Autowired
    private PatientService patientService;

    @Test
    void shouldFindVisitsByPatientId() {

        long patientId = 201;

        List<VisitTO> visits = patientService.getVisitsByPatientId(patientId);

        assertNotNull(visits);
        assertFalse(visits.isEmpty(), "Lista wizyt nie powinna być pusta");
        System.out.println("Znaleziono " + visits.size() + " wizyt dla pacjenta o ID " + patientId);
    }
}
