package com.jpacourse.service;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


public interface PatientService {

    Optional<PatientTO> findById(long id);

    Optional<VisitTO> addVisit(int patientId, int doctorId, LocalDateTime time, String description);

    List<PatientTO> getPatientsWithVisitCountGreaterThan(int count);

    List<PatientTO> getPatientsWithHeightGreaterThan(int height);

    List<VisitTO> getVisitsByPatientId(long patientId);

    void deleteById(long id);
}
