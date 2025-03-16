
package com.jpacourse.service;

import java.util.Optional;

import com.jpacourse.dto.PatientTO;


public interface PatientService {

	Optional<PatientTO> findById(long id);
}
