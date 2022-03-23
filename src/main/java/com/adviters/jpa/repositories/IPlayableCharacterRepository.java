package com.adviters.jpa.repositories;

import com.adviters.jpa.model.PlayableCharacter;
import org.springframework.data.repository.CrudRepository;

public interface IPlayableCharacterRepository extends CrudRepository<PlayableCharacter, Integer> {
}