package io.factorialsystems.faspetclinic.web;

//package io.factorialsystems.faspetclinic.data.services.map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "io.factorialsystems.faspetclinic")
public class FasPetClinicApplication {

	public static void main(String[] args) {
		SpringApplication.run(FasPetClinicApplication.class, args);
	}

}
