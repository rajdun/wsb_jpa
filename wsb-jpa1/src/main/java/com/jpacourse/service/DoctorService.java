package com.jpacourse.service;

import com.jpacourse.dto.DoctorTO;

import java.util.List;

public interface DoctorService {
    List<DoctorTO> getDoctorsByLastName(String lastName);
}
