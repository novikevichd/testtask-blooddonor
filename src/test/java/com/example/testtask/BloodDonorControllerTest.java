package com.example.testtask;

import com.example.testtask.serviceresponse.ServiceResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.json.JSONObject;

import static com.example.testtask.responsecreator.BloodType.*;
import static com.example.testtask.responsecreator.ResponseDescriptionVariables.INVALID_DATA;
import static com.example.testtask.responsecreator.ResponseStatusVariables.*;
import static org.assertj.core.api.Assertions.assertThat;

// Сквозные тесты (контроллер->сервис)

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BloodDonorControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	private static String postPersonUrl = "/blood-test";
	private static HttpHeaders headers = new HttpHeaders();;
	private static JSONObject patientJsonObject;
	private static JSONObject bloodInfoJsonObject;

	@BeforeAll
	public static void befroeAllTests()  {
		headers.setContentType(MediaType.APPLICATION_JSON);
		bloodInfoJsonObject = new JSONObject();
		patientJsonObject = new JSONObject();
	}


	@Test
	void shouldReturnSuccess_And_InfoFor_I_PositiveBloodGroup() throws JSONException{

		bloodInfoJsonObject.put("bloodGroup", "1");
		bloodInfoJsonObject.put("rh", "+");
		patientJsonObject.put("bloodInfo", bloodInfoJsonObject);
		patientJsonObject.put("firstName", "Ivan");
		patientJsonObject.put("lastName", "Ivanov");

		HttpEntity<String> request = new HttpEntity<>(patientJsonObject.toString(), headers);

		ResponseEntity<ServiceResponse> entity = restTemplate.postForEntity(postPersonUrl, request, ServiceResponse.class);

		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(entity.getBody().getStatus()).isEqualTo(STATUS_SUCCESS);
		assertThat(entity.getBody().getResultDescription()).isEqualTo(I_POSITIVE.getTypeDescription());

	}

	@Test
	void shouldReturnSuccess_And_InfoFor_I_NegativeBloodGroup() throws JSONException{

		bloodInfoJsonObject.put("bloodGroup", "1");
		bloodInfoJsonObject.put("rh", "-");
		patientJsonObject.put("bloodInfo", bloodInfoJsonObject);
		patientJsonObject.put("firstName", "Petr");
		patientJsonObject.put("lastName", "Petrov");

		HttpEntity<String> request = new HttpEntity<>(patientJsonObject.toString(), headers);

		ResponseEntity<ServiceResponse> entity = restTemplate.postForEntity(postPersonUrl, request, ServiceResponse.class);

		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(entity.getBody().getStatus()).isEqualTo(STATUS_SUCCESS);
		assertThat(entity.getBody().getResultDescription()).isEqualTo(I_NEGATIVE.getTypeDescription());

	}

	@Test
	void shouldReturnSuccess_And_InfoFor_II_PositiveBloodGroup() throws JSONException{

		bloodInfoJsonObject.put("bloodGroup", "2");
		bloodInfoJsonObject.put("rh", "+");
		patientJsonObject.put("bloodInfo", bloodInfoJsonObject);
		patientJsonObject.put("firstName", "Sidor");
		patientJsonObject.put("lastName", "Sidorov");

		HttpEntity<String> request = new HttpEntity<>(patientJsonObject.toString(), headers);

		ResponseEntity<ServiceResponse> entity = restTemplate.postForEntity(postPersonUrl, request, ServiceResponse.class);

		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(entity.getBody().getStatus()).isEqualTo(STATUS_SUCCESS);
		assertThat(entity.getBody().getResultDescription()).isEqualTo(II_POSITIVE.getTypeDescription());

	}

	@Test
	void shouldReturnSuccess_And_InfoFor_II_NegativeBloodGroup() throws JSONException{

		bloodInfoJsonObject.put("bloodGroup", "2");
		bloodInfoJsonObject.put("rh", "-");
		patientJsonObject.put("bloodInfo", bloodInfoJsonObject);
		patientJsonObject.put("firstName", "Sidr");
		patientJsonObject.put("lastName", "Petrov");

		HttpEntity<String> request = new HttpEntity<>(patientJsonObject.toString(), headers);

		ResponseEntity<ServiceResponse> entity = restTemplate.postForEntity(postPersonUrl, request, ServiceResponse.class);

		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(entity.getBody().getStatus()).isEqualTo(STATUS_SUCCESS);
		assertThat(entity.getBody().getResultDescription()).isEqualTo(II_NEGATIVE.getTypeDescription());

	}

	@Test
	void shouldReturnSuccess_And_InfoFor_III_PositiveBloodGroup() throws JSONException{

		bloodInfoJsonObject.put("bloodGroup", "3");
		bloodInfoJsonObject.put("rh", "+");
		patientJsonObject.put("bloodInfo", bloodInfoJsonObject);
		patientJsonObject.put("firstName", "Ivan");
		patientJsonObject.put("lastName", "Sidorov");

		HttpEntity<String> request = new HttpEntity<>(patientJsonObject.toString(), headers);

		ResponseEntity<ServiceResponse> entity = restTemplate.postForEntity(postPersonUrl, request, ServiceResponse.class);

		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(entity.getBody().getStatus()).isEqualTo(STATUS_SUCCESS);
		assertThat(entity.getBody().getResultDescription()).isEqualTo(III_POSITIVE.getTypeDescription());

	}

	@Test
	void shouldReturnSuccess_And_InfoFor_III_NegativeBloodGroup() throws JSONException{

		bloodInfoJsonObject.put("bloodGroup", "3");
		bloodInfoJsonObject.put("rh", "-");
		patientJsonObject.put("bloodInfo", bloodInfoJsonObject);
		patientJsonObject.put("firstName", "Per");
		patientJsonObject.put("lastName", "Sidorov");

		HttpEntity<String> request = new HttpEntity<>(patientJsonObject.toString(), headers);

		ResponseEntity<ServiceResponse> entity = restTemplate.postForEntity(postPersonUrl, request, ServiceResponse.class);

		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(entity.getBody().getStatus()).isEqualTo(STATUS_SUCCESS);
		assertThat(entity.getBody().getResultDescription()).isEqualTo(III_NEGATIVE.getTypeDescription());

	}

	@Test
	void shouldReturnSuccess_And_InfoFor_IV_PositiveBloodGroup() throws JSONException{

		bloodInfoJsonObject.put("bloodGroup", "4");
		bloodInfoJsonObject.put("rh", "+");
		patientJsonObject.put("bloodInfo", bloodInfoJsonObject);
		patientJsonObject.put("firstName", "Sidor");
		patientJsonObject.put("lastName", "Ivanov");

		HttpEntity<String> request = new HttpEntity<>(patientJsonObject.toString(), headers);

		ResponseEntity<ServiceResponse> entity = restTemplate.postForEntity(postPersonUrl, request, ServiceResponse.class);

		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(entity.getBody().getStatus()).isEqualTo(STATUS_SUCCESS);
		assertThat(entity.getBody().getResultDescription()).isEqualTo(IV_POSITIVE.getTypeDescription());

	}

	@Test
	void shouldReturnSuccess_And_InfoFor_IV_NegativeBloodGroup() throws JSONException{

		bloodInfoJsonObject.put("bloodGroup", "4");
		bloodInfoJsonObject.put("rh", "-");
		patientJsonObject.put("bloodInfo", bloodInfoJsonObject);
		patientJsonObject.put("firstName", "Petr");
		patientJsonObject.put("lastName", "Petrov");

		HttpEntity<String> request = new HttpEntity<>(patientJsonObject.toString(), headers);

		ResponseEntity<ServiceResponse> entity = restTemplate.postForEntity(postPersonUrl, request, ServiceResponse.class);

		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(entity.getBody().getStatus()).isEqualTo(STATUS_SUCCESS);
		assertThat(entity.getBody().getResultDescription()).isEqualTo(IV_NEGATIVE.getTypeDescription());

	}

	@Test
	void shouldReturnFailStatus_BecauseWrongBloodGroup() throws JSONException{

		bloodInfoJsonObject.put("bloodGroup", "8");
		bloodInfoJsonObject.put("rh", "-");
		patientJsonObject.put("bloodInfo", bloodInfoJsonObject);
		patientJsonObject.put("firstName", "Petr");
		patientJsonObject.put("lastName", "Petrov");

		HttpEntity<String> request = new HttpEntity<>(patientJsonObject.toString(), headers);

		ResponseEntity<ServiceResponse> entity = restTemplate.postForEntity(postPersonUrl, request, ServiceResponse.class);

		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(entity.getBody().getStatus()).isEqualTo(STATUS_FAIL);
		assertThat(entity.getBody().getResultDescription()).contains(INVALID_DATA);

	}

	@Test
	void shouldReturnFailStatus_BecauseWrongBloodRh() throws JSONException{

		bloodInfoJsonObject.put("bloodGroup", "1");
		bloodInfoJsonObject.put("rh", "5");
		patientJsonObject.put("bloodInfo", bloodInfoJsonObject);
		patientJsonObject.put("firstName", "Petr");
		patientJsonObject.put("lastName", "Petrov");

		HttpEntity<String> request = new HttpEntity<>(patientJsonObject.toString(), headers);

		ResponseEntity<ServiceResponse> entity = restTemplate.postForEntity(postPersonUrl, request, ServiceResponse.class);

		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(entity.getBody().getStatus()).isEqualTo(STATUS_FAIL);
		assertThat(entity.getBody().getResultDescription()).contains(INVALID_DATA);

	}

	@Test
	void shouldReturnFailStatus_BecauseWrongBloodInfoFields() throws JSONException{

		bloodInfoJsonObject.put("bloodGroup", "7");
		bloodInfoJsonObject.put("rh", "5");
		patientJsonObject.put("bloodInfo", bloodInfoJsonObject);
		patientJsonObject.put("firstName", "Petr");
		patientJsonObject.put("lastName", "Petrov");

		HttpEntity<String> request = new HttpEntity<>(patientJsonObject.toString(), headers);

		ResponseEntity<ServiceResponse> entity = restTemplate.postForEntity(postPersonUrl, request, ServiceResponse.class);

		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(entity.getBody().getStatus()).isEqualTo(STATUS_FAIL);
		assertThat(entity.getBody().getResultDescription()).contains(INVALID_DATA);

	}

	@Test
	void shouldReturnFBadRequest_BeacuseOfFromDataFormat_1() throws JSONException{

		bloodInfoJsonObject.put("bloodGroup", "1");
		bloodInfoJsonObject.put("rh", "51");
		patientJsonObject.put("bloodInfo", bloodInfoJsonObject);
		patientJsonObject.put("firstName", "Petr");
		patientJsonObject.put("lastName", "Petrov");

		HttpEntity<String> request = new HttpEntity<>(patientJsonObject.toString(), headers);

		ResponseEntity<String> entity = restTemplate.postForEntity(postPersonUrl, request, String.class);

		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);

	}

	@Test
	void shouldReturnFBadRequest_BeacuseOfFromDataFormat_2() throws JSONException{

		bloodInfoJsonObject.put("bloodGroup", "13");
		bloodInfoJsonObject.put("rh", "+");
		patientJsonObject.put("bloodInfo", bloodInfoJsonObject);
		patientJsonObject.put("firstName", "Petr");
		patientJsonObject.put("lastName", "Petrov");

		HttpEntity<String> request = new HttpEntity<>(patientJsonObject.toString(), headers);

		ResponseEntity<String> entity = restTemplate.postForEntity(postPersonUrl, request, String.class);

		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);

	}

}
