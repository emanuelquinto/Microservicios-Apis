package com.CarroServices2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CarroServices2Application {

	public static void main(String[] args) {
		SpringApplication.run(CarroServices2Application.class, args);
	}

}
