package com.vision.nakala;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.vision.nakala.service"})
@SpringBootApplication
public class GestionUtilisateurApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionUtilisateurApplication.class, args);
	}

}
