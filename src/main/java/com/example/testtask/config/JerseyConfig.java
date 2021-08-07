package com.example.testtask.config;

import com.example.testtask.controller.HelloWorldController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {

        register(HelloWorldController.class);

    }

}
