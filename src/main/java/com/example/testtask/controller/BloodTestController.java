package com.example.testtask.controller;

import com.example.testtask.bloodtestservice.BloodTestService;
import com.example.testtask.dto.Patient;
import com.example.testtask.serviceresponse.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/blood-test")
public class BloodTestController {

    @Autowired
    BloodTestService bloodTestService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTestResult(Patient patient) {

        ServiceResponse serviceResponse = bloodTestService.getResult(patient);

        return Response.ok(serviceResponse).build();

    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getHelloWorld() {
        return Response.ok("Hello from blood test").build();
    }


}
