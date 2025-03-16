
package com.jpacourse.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.rest.exception.EntityNotFoundException;
import com.jpacourse.service.PatientService;


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
}
