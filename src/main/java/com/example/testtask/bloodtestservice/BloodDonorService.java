package com.example.testtask.bloodtestservice;

import com.example.testtask.dto.Patient;
import com.example.testtask.responsecreator.ServiceResponseCreator;
import com.example.testtask.serviceresponse.ServiceResponse;
import com.example.testtask.validator.PatientValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.testtask.responsecreator.BloodType.*;

@Service
public class BloodDonorService {

    private static final Logger LOG = LoggerFactory.getLogger(BloodDonorService.class);

    private ServiceResponseCreator responseCreator;


    @Autowired
    public BloodDonorService(ServiceResponseCreator responseCreator) {
        this.responseCreator = responseCreator;
    }


    public ServiceResponse getResult(Patient patient) {

        ServiceResponse serviceResponse;

        if(!PatientValidator.validatePatientBloodData(patient)) {

            LOG.warn("ДАННЫЕ В DTO НЕ ВАЛИДНЫ, ФОРМИРУЕМ ОТВЕТ FAIL");
            serviceResponse = responseCreator.createFailResponse(patient);

        } else {

            LOG.info("ДАННЫЕ В DTO ВАЛИДНЫ, ФОРМИРУЕМ ОТВЕТ SUCCESS. СОДЕРЖАНИЕ ОТВЕТА ЗАВИСИТ ОТ " +
                    "ИНФОРМАЦИИ О ПАЦИЕНТЕ");

            Character patientBloodType = patient.getBloodInfo().getBloodGroup();
            Character patientBloodRh = patient.getBloodInfo().getRh();

            if (patientBloodType.equals('1')) {

                if (patientBloodRh.equals('+')) serviceResponse
                        = responseCreator.createSuccessResponse(I_POSITIVE);
                else serviceResponse = responseCreator.createSuccessResponse(I_NEGATIVE);

            } else if (patientBloodType.equals('2')) {

                if (patientBloodRh.equals('+')) serviceResponse
                        = responseCreator.createSuccessResponse(II_POSITIVE);
                else serviceResponse = responseCreator.createSuccessResponse(II_NEGATIVE);
            } else if (patientBloodType.equals('3')) {

                if (patientBloodRh.equals('+')) serviceResponse
                        = responseCreator.createSuccessResponse(III_POSITIVE);
                else serviceResponse = responseCreator.createSuccessResponse(III_NEGATIVE);
            } else {

                if (patientBloodRh.equals('+')) serviceResponse
                        = responseCreator.createSuccessResponse(IV_POSITIVE);
                else serviceResponse = responseCreator.createSuccessResponse(IV_NEGATIVE);
            }

        }

        return serviceResponse;

    }

}
