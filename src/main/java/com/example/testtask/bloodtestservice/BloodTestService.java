package com.example.testtask.bloodtestservice;

import com.example.testtask.dto.Patient;
import com.example.testtask.responsecreator.ServiceResponseCreator;
import com.example.testtask.serviceresponse.ServiceResponse;
import com.example.testtask.validator.PatientValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.testtask.responsecreator.ResponseStatusVariables.STATUS_SUCCESS;

@Service
public class BloodTestService {

    @Autowired
    ServiceResponseCreator responseCreator;

    public ServiceResponse getResult(Patient patient) {

        ServiceResponse serviceResponse;

        if(!PatientValidator.validatePatientBloodData(patient)) {
            serviceResponse = responseCreator.createFailResponse(patient);
        }
        else serviceResponse = new ServiceResponse(STATUS_SUCCESS, "ПОКА ВСЕ ЧЕТКО");

        return serviceResponse;

    }

}
