package com.example.testtask;


import com.example.testtask.bloodtestservice.BloodDonorService;
import com.example.testtask.dto.BloodInfo;
import com.example.testtask.dto.Patient;
import com.example.testtask.serviceresponse.ServiceResponse;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.example.testtask.responsecreator.BloodType.*;
import static com.example.testtask.responsecreator.ResponseDescriptionVariables.INVALID_DATA;
import static com.example.testtask.responsecreator.ResponseStatusVariables.STATUS_FAIL;
import static com.example.testtask.responsecreator.ResponseStatusVariables.STATUS_SUCCESS;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class BloodDonorServiceTest {

    @Autowired
    BloodDonorService bloodDonorService;

    @Test
    void shouldReturnInfoFor_I_PositiveBloodGroup() {
        BloodInfo bloodInfo = new BloodInfo('1','+');
        Patient patient = new Patient("Ivan", "Ivanov", bloodInfo);

        ServiceResponse serviceResponse = bloodDonorService.getResult(patient);

        assertThat(serviceResponse.getStatus()).isEqualTo(STATUS_SUCCESS);
        assertThat(serviceResponse.getResultDescription()).isEqualTo(I_POSITIVE.getTypeDescription());
    }

    @Test
    void shouldReturnInfoFor_I_NegativeBloodGroup() {
        BloodInfo bloodInfo = new BloodInfo('1','-');
        Patient patient = new Patient("Petr", "Petrov", bloodInfo);

        ServiceResponse serviceResponse = bloodDonorService.getResult(patient);

        assertThat(serviceResponse.getStatus()).isEqualTo(STATUS_SUCCESS);
        assertThat(serviceResponse.getResultDescription()).isEqualTo(I_NEGATIVE.getTypeDescription());
    }

    @Test
    void shouldReturnInfoFor_II_PositiveBloodGroup() {
        BloodInfo bloodInfo = new BloodInfo('2','+');
        Patient patient = new Patient("Sidor", "Sidorov", bloodInfo);

        ServiceResponse serviceResponse = bloodDonorService.getResult(patient);

        assertThat(serviceResponse.getStatus()).isEqualTo(STATUS_SUCCESS);
        assertThat(serviceResponse.getResultDescription()).isEqualTo(II_POSITIVE.getTypeDescription());
    }

    @Test
    void shouldReturnInfoFor_II_NegativeBloodGroup() {
        BloodInfo bloodInfo = new BloodInfo('2','-');
        Patient patient = new Patient("Ivan", "Petrov", bloodInfo);

        ServiceResponse serviceResponse = bloodDonorService.getResult(patient);

        assertThat(serviceResponse.getStatus()).isEqualTo(STATUS_SUCCESS);
        assertThat(serviceResponse.getResultDescription()).isEqualTo(II_NEGATIVE.getTypeDescription());
    }

    @Test
    void shouldReturnInfoFor_III_PositiveBloodGroup() {
        BloodInfo bloodInfo = new BloodInfo('3','+');
        Patient patient = new Patient("Petr", "Ivanov", bloodInfo);

        ServiceResponse serviceResponse = bloodDonorService.getResult(patient);

        assertThat(serviceResponse.getStatus()).isEqualTo(STATUS_SUCCESS);
        assertThat(serviceResponse.getResultDescription()).isEqualTo(III_POSITIVE.getTypeDescription());
    }

    @Test
    void shouldReturnInfoFor_III_NegativeBloodGroup() {
        BloodInfo bloodInfo = new BloodInfo('3','-');
        Patient patient = new Patient("Ivan", "Sidorov", bloodInfo);

        ServiceResponse serviceResponse = bloodDonorService.getResult(patient);

        assertThat(serviceResponse.getStatus()).isEqualTo(STATUS_SUCCESS);
        assertThat(serviceResponse.getResultDescription()).isEqualTo(III_NEGATIVE.getTypeDescription());
    }

    @Test
    void shouldReturnInfoFor_IV_PositiveBloodGroup() {
        BloodInfo bloodInfo = new BloodInfo('4','+');
        Patient patient = new Patient("Sidor", "Ivanov", bloodInfo);

        ServiceResponse serviceResponse = bloodDonorService.getResult(patient);

        assertThat(serviceResponse.getStatus()).isEqualTo(STATUS_SUCCESS);
        assertThat(serviceResponse.getResultDescription()).isEqualTo(IV_POSITIVE.getTypeDescription());
    }

    @Test
    void shouldReturnInfoFor_IV_NegativeBloodGroup() {
        BloodInfo bloodInfo = new BloodInfo('4','-');
        Patient patient = new Patient("Petr", "Sidorov", bloodInfo);

        ServiceResponse serviceResponse = bloodDonorService.getResult(patient);

        assertThat(serviceResponse.getStatus()).isEqualTo(STATUS_SUCCESS);
        assertThat(serviceResponse.getResultDescription()).isEqualTo(IV_NEGATIVE.getTypeDescription());
    }

    @Test
    void shouldReturnFailStatus_BecauseWrongBloodGroup() {
        BloodInfo bloodInfo = new BloodInfo('7','-');
        Patient patient = new Patient("Sidor", "Petrov", bloodInfo);

        ServiceResponse serviceResponse = bloodDonorService.getResult(patient);

        assertThat(serviceResponse.getStatus()).isEqualTo(STATUS_FAIL);
        assertThat(serviceResponse.getResultDescription()).contains(INVALID_DATA);
    }

    @Test
    void shouldReturnFailStatus_BecauseWrongBloodRh() {
        BloodInfo bloodInfo = new BloodInfo('1','0');
        Patient patient = new Patient("Petr", "Ivanov", bloodInfo);

        ServiceResponse serviceResponse = bloodDonorService.getResult(patient);

        assertThat(serviceResponse.getStatus()).isEqualTo(STATUS_FAIL);
        assertThat(serviceResponse.getResultDescription()).contains(INVALID_DATA);
    }

    @Test
    void shouldReturnFailStatus_BecauseWrongBloodInfoFields() {
        BloodInfo bloodInfo = new BloodInfo('0','0');
        Patient patient = new Patient("Sidor", "Petrov", bloodInfo);

        ServiceResponse serviceResponse = bloodDonorService.getResult(patient);

        assertThat(serviceResponse.getStatus()).isEqualTo(STATUS_FAIL);
        assertThat(serviceResponse.getResultDescription()).contains(INVALID_DATA);
    }


}
