package com.adviters.jpa;

import com.adviters.jpa.exceptions.PlayableCharacterAgeException;
import com.adviters.jpa.model.PlayableCharacter;
import com.adviters.jpa.repositories.IPlayableCharacterRepository;
import org.apache.logging.slf4j.SLF4JLogger;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.NoSuchElementException;
import java.util.Scanner;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

	private static Logger logger = LoggerFactory.getLogger(SLF4JLogger.class);
	@Autowired
	IPlayableCharacterRepository playableCharacterRepository;

	public static void main(String[] args) {

		SpringApplication.run(JpaApplication.class, args);
	}
	@Override
	public void run(String...args) {
		var maleCharacters = playableCharacterRepository.buscarPorSexo("H");
		var playableCharactersWith30 = playableCharacterRepository.findByAge(30);
		var playableCharacter = playableCharacterRepository.findByNameAndAge("Lautaro", 29);
		if(playableCharacter.isPresent())
			playableCharacter.get().showCharacterInfo();
		else
			logger.info("Character doesn't exist on database");
	}

	public void howToUserTryCatch()
	{
		try {
			logger.info("Retrieving data from DB with CharacterId 90");
			var optionalPlayableCharacter = playableCharacterRepository.findById(90);
			if(optionalPlayableCharacter.isPresent())
			{
				var playableCharacter = optionalPlayableCharacter.get();
			}
			else {
				logger.warn("Character doesn't exist on Database");
			}
		}
		catch (NoSuchElementException e) {
			logger.error("NoSuchElementException: " + e.getMessage());
			//throw e;
		}
		catch (Exception e) {
			System.out.println("Excepción no controlada, mensaje: " + e.getMessage());
		}

	}

}
