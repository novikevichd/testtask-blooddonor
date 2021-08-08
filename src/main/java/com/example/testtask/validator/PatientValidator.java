package com.example.testtask.validator;

import com.example.testtask.dto.Patient;

public class PatientValidator {

    public static boolean validatePatientBloodData(Patient patient) {

        Character patientBloodGroup = patient.getBloodInfo().getBloodGroup();
        Character patientBloodRh = patient.getBloodInfo().getRh();

        if ((patientBloodGroup.equals('1') ||
            patientBloodGroup.equals('2') ||
            patientBloodGroup.equals('3') ||
            patientBloodGroup.equals('4'))
            && (patientBloodRh.equals('+') ||
                patientBloodRh.equals('-'))
        ) return true;

        else return false;

    }

}
