package com.app.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class VehicleGrudAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehicleGrudAppApplication.class, args);
	}
}
