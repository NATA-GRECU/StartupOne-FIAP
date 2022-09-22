package br.com.connectFood.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ConnectFoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConnectFoodApplication.class, args);

	}

	@GetMapping("/")
	public String index() {
		return "Hello World!";
	}
}
