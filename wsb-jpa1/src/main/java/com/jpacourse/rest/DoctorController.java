package com.jpacourse.rest;

import com.jpacourse.dto.DoctorTO;
import com.jpacourse.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DoctorController {
    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/doctor-by-lastname")
    public List<DoctorTO> getDoctorsByLastName(@RequestParam(required = true) String lastName) {
        return doctorService.getDoctorsByLastName(lastName);
    }
}
