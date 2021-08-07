package com.example.testtask.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloWorldController {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getHelloWorld() {
        return Response.ok("Hello World!").build();
    }

}
