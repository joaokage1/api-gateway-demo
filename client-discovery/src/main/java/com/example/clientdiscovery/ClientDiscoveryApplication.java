package com.example.clientdiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ClientDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientDiscoveryApplication.class, args);
    }

}
