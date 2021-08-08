package com.example.testtask.responsecreator;

import com.example.testtask.dto.Patient;
import com.example.testtask.serviceresponse.ServiceResponse;
import org.springframework.stereotype.Component;

import static com.example.testtask.responsecreator.ResponseDescriptionVariables.INVALID_DATA;
import static com.example.testtask.responsecreator.ResponseStatusVariables.STATUS_FAIL;
import static com.example.testtask.responsecreator.ResponseStatusVariables.STATUS_SUCCESS;

@Component
public class ServiceResponseCreator {

    public ServiceResponse createFailResponse(Patient patient) {

        String responseResultDescription = INVALID_DATA + " ВХОДЯЩИЕ ДАННЫЕ: " + patient;
        return new ServiceResponse(STATUS_FAIL, responseResultDescription);

    }

    public ServiceResponse createSuccessResponse(BloodType bloodType) {

        return new ServiceResponse(STATUS_SUCCESS, bloodType.getTypeDescription());

    }

}
