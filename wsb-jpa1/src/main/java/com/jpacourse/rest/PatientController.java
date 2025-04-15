package com.jpacourse.rest;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;
import com.jpacourse.rest.exception.EntityNotFoundException;
import com.jpacourse.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class PatientController {

    private final PatientService patientService;

    @Autowired
    PatientController(PatientService patientService) {

        Assert.notNull(patientService, "patientService must not be null");

        this.patientService = patientService;
    }

    @GetMapping("/patient/{id}")
    PatientTO findById(@PathVariable long id) {

        return patientService.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));
    }

    @GetMapping("/patient-by-visit-count")
    List<PatientTO> findByVisitCount(@RequestParam(required = true) int countGt) {
        return patientService.getPatientsWithVisitCountGreaterThan(countGt);
    }

    @GetMapping("/patient-by-height")
    List<PatientTO> findByHeight(@RequestParam(required = true) int heightGt) {
        return patientService.getPatientsWithHeightGreaterThan(heightGt);
    }

    @GetMapping("/patient/{id}/visits")
    List<VisitTO> getVisitsByPatientId(@PathVariable long id) {
        return patientService.getVisitsByPatientId(id);
    }
}