package com.adviters.jpa;

import com.adviters.jpa.exceptions.PlayableCharacterAgeException;
import com.adviters.jpa.model.PlayableCharacter;
import com.adviters.jpa.repositories.IPlayableCharacterRepository;
import org.apache.logging.slf4j.SLF4JLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.NoSuchElementException;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(SLF4JLogger.class);
	@Autowired
	IPlayableCharacterRepository playableCharacterRepository;

	public static int plusNumbers(int y, int x) {
		return y + x;
	}
	public static void main(String[] args) {

		SpringApplication.run(JpaApplication.class, args);
	}
	@Override
	public void run(String...args) {
		var playableCharacter = playableCharacterRepository.findByNameAndAge("Lautaro", 29);
		if(playableCharacter.isPresent())
			playableCharacter.get().showCharacterInfo();
		else
			logger.info("Character doesn't exist on database");
	}

	public void getCharactersWithTheSameAge(int age)
	{
		var character = playableCharacterRepository.findByAge(age);
		character.forEach(PlayableCharacter::showCharacterInfo);
	}

	public PlayableCharacter createCharacter(String name, int age, double height, int weight) throws Exception {
		if(age > 100) {
			throw new PlayableCharacterAgeException();
		}

		if(name.length() == 0)
		{
			throw new Exception("El nombre no puede ser vacio");
		}
		var character = new PlayableCharacter(name, age, height, weight, 0, 0, "H");

		playableCharacterRepository.save(character);
		return character;
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
