package com.adovj.franquicias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@RestController
public class FranquiciasApplication {

	public static void main(String[] args) {
		SpringApplication.run(FranquiciasApplication.class, args);
	}

	//@GetMapping
	public String hello ()
	{
		return "Hola desde endpoint";
	}
}
