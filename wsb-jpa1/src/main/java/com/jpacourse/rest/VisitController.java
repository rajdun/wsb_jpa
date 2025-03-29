package com.jpacourse.rest;

import com.jpacourse.dto.VisitTO;
import com.jpacourse.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
public class VisitController {


    private final PatientService patientService;

    @Autowired
    VisitController(PatientService patientService) {

        Assert.notNull(patientService, "patientService must not be null");

        this.patientService = patientService;
    }

    @PutMapping("/visit")
    public VisitTO PutVisit(){
        // TO JEST TESTOWA METODA - W ZADANIU NIE BYLO NIC O KONTROLERZE A CHCIALEM TYLKO ZOABCZYC CZY BEDZIE DZIALAC
        Optional<VisitTO> result = patientService.AddVisit(201, 101, LocalDateTime.MIN, "test");

        if(result.isPresent())
        {
            return result.get();
        }
        else
        {
            throw new RuntimeException("Error creating visit");
        }
    }
}
