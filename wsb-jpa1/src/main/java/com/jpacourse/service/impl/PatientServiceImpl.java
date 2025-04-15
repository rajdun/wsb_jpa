package com.jpacourse.service.impl;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;
import com.jpacourse.mapper.PatientMapper;
import com.jpacourse.mapper.VisitMapper;
import com.jpacourse.persistance.dao.PatientDao;
import com.jpacourse.persistance.dao.VisitDao;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import com.jpacourse.service.PatientService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.jpacourse.mapper.PatientMapper.mapToTO;


@Service
@Transactional
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
        Optional<PatientEntity> patient = patientDao.findByIdWithPastVisits(id);

        return patient.map(PatientMapper::mapToTO);

    }

    @Override
    public Optional<VisitTO> addVisit(int patientId, int doctorId, LocalDateTime time, String description) {
        VisitEntity visit = patientDao.createVisit(patientId, doctorId, time, description);

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

    @Override
    public void deleteById(long id) {

        patientDao.deleteById(id);
    }
}
