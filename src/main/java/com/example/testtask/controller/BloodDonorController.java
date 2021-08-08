package com.example.testtask.controller;

import com.example.testtask.bloodtestservice.BloodDonorService;
import com.example.testtask.dto.Patient;
import com.example.testtask.serviceresponse.ServiceResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/blood-test")
public class BloodDonorController {

    private static final Logger LOG = LoggerFactory.getLogger(BloodDonorController.class);

    @Autowired
    BloodDonorService bloodDonorService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTestResult(Patient patient) {

        LOG.info("DTO В ЗАПРОСЕ: " + patient);

        ServiceResponse serviceResponse = bloodDonorService.getResult(patient);

        LOG.info("Результат " + serviceResponse);

        return Response.ok(serviceResponse).header("STATUS", serviceResponse.getStatus()).build();

    }

}
