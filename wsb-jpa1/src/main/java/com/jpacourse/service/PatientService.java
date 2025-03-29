
package com.jpacourse.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;


public interface PatientService {

	Optional<PatientTO> findById(long id);
	Optional<VisitTO> AddVisit(int patientId, int doctorId, LocalDateTime time, String description);

	List<PatientTO> getPatientsWithVisitCountGreaterThan(int count);
	List<PatientTO> getPatientsWithHeightGreaterThan(int height);
	List<VisitTO> getVisitsByPatientId(long patientId);
}
