package com.prestabanco.PrestaBanco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PrestaBancoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrestaBancoApplication.class, args);
	}

	@GetMapping("/")
	public String home() {
		return "PrestaBanco back corriendo";
	}

	@GetMapping("/health")
	public String health() {
		return "OK";
	}

}
