package com.utn.jpa1;

import com.utn.jpa1.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Jpa1Application {

	public static void main(String[] args) {
		SpringApplication.run(Jpa1Application.class, args);
	}

}
