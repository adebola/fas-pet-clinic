package io.factorialsystems.faspetclinic.web;

//package io.factorialsystems.faspetclinic.data.services.map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "io.factorialsystems.faspetclinic")
@EnableJpaRepositories("io.factorialsystems.faspetclinic.data.repositories")
@EntityScan("io.factorialsystems.faspetclinic.data.model")

public class FasPetClinicApplication  {

	public static void main(String[] args) {
		SpringApplication.run(FasPetClinicApplication.class, args);
	}

}
