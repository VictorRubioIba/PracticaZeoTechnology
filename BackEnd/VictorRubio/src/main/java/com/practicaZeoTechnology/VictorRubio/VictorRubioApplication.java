package com.practicaZeoTechnology.VictorRubio;

import com.practicaZeoTechnology.VictorRubio.Users.domain.User;
import com.practicaZeoTechnology.VictorRubio.Users.infraestructure.repository.UsersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class VictorRubioApplication {

	public static void main(String[] args) {
		SpringApplication.run(VictorRubioApplication.class, args);
	}

}
