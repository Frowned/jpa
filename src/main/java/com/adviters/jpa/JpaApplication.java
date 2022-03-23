package com.adviters.jpa;

import com.adviters.jpa.model.PlayableCharacter;
import com.adviters.jpa.repositories.IPlayableCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

	@Autowired
	IPlayableCharacterRepository playableCharacterRepository;

	public static void main(String[] args) {

		SpringApplication.run(JpaApplication.class, args);
	}
	@Override
	public void run(String...args) {
		var findById1 = playableCharacterRepository.findAll();
		findById1.forEach(x -> x.showCharacterInfo());
	}


}
