package com.adviters.jpa.repositories;

import com.adviters.jpa.model.PlayableCharacter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IPlayableCharacterRepository extends CrudRepository<PlayableCharacter, Integer> {
    // using query methods
    List<PlayableCharacter> findByAge(int age);

    @Query("select x from PlayableCharacter x where x.name = ?1 and x.age= ?2")
    Optional<PlayableCharacter> findByNameAndAge(String name, int age);

    @Query("select x from PlayableCharacter x where x.sex = ?1")
    List<PlayableCharacter> buscarPorSexo(String sex);
}