package com.jpacourse.service.impl;

import com.jpacourse.dto.DoctorTO;
import com.jpacourse.mapper.DoctorMapper;
import com.jpacourse.persistance.dao.DoctorDao;
import com.jpacourse.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorDao doctorDao;
    
    @Autowired
    public DoctorServiceImpl(DoctorDao doctorDao) {
        this.doctorDao = doctorDao;
    }


    @Override
    public List<DoctorTO> getDoctorsByLastName(String lastName) {
        return doctorDao.getDoctorByLastName(lastName)
                .stream()
                .map(DoctorMapper::toDoctorTO)
                .toList();
    }
}
