package com.adviters.jpa.services;

import com.adviters.jpa.exceptions.PlayableCharacterAgeException;
import com.adviters.jpa.model.PlayableCharacter;
import com.adviters.jpa.repositories.IPlayableCharacterRepository;
import org.apache.logging.slf4j.SLF4JLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PlayableCharacterService {
    private static final Logger logger = LoggerFactory.getLogger(SLF4JLogger.class);
    private IPlayableCharacterRepository repository;

    @Autowired
    public PlayableCharacterService(IPlayableCharacterRepository repository)
    {
        this.repository = repository;
    }

    public PlayableCharacter getById(int id) throws Exception {
        var result = repository.findById(id);

        if(result.isPresent())
        {
            return result.get();
        }
        else
        {
            throw new Exception("Character not found on database");
        }

    }

    public void deleteCharacter(int id) {
        repository.deleteById(id);
    }

    public int createCharacter(PlayableCharacter playableCharacter) throws Exception {
        if(playableCharacter == null) {
            throw new Exception("La entidad no puede ser nula");
        }

        if(playableCharacter.getAge() > 100) {
            throw new PlayableCharacterAgeException();
        }

        if(playableCharacter.getName().length() == 0)
        {
            throw new Exception("El nombre no puede ser vacio");
        }

        repository.save(playableCharacter);
        return playableCharacter.getId();
    }

    public PlayableCharacter updateCharacter(PlayableCharacter playableCharacter) throws Exception {
        var characterDB = getById(playableCharacter.getId());

        return repository.save(characterDB);
    }

    public void howToUserTryCatch()
    {
        try {
            logger.info("Retrieving data from DB with CharacterId 90");
            var optionalPlayableCharacter = repository.findById(90);
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
