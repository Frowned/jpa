package com.adviters.jpa;

import com.adviters.jpa.exceptions.PlayableCharacterAgeException;
import com.adviters.jpa.model.PlayableCharacter;
import com.adviters.jpa.repositories.IPlayableCharacterRepository;
import com.adviters.jpa.services.PlayableCharacterService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PlayableCharacterServiceTests {
    PlayableCharacterService service;

    @Mock
    IPlayableCharacterRepository repository;

    @BeforeAll
    void setUp() {
        // Usamos esto para inicializar los mocks
        MockitoAnnotations.openMocks(this);
        service = new PlayableCharacterService(repository);
    }

    @Test
    void plusNumberTest() {
        var x = 5;
        var y = 6;
		assertEquals(11, x+y);
    }

    @Test
    void getCharacterTest() throws Exception {
        String name = "Juan";
        int age = 35;
        double height = 1.55;
        int weight = 150;
        var character = new PlayableCharacter(name, age, height, weight, 0, 0, "H");
        Mockito.when(repository.findById(2)).thenReturn(Optional.of(character));
        var result = service.getById(2);
        assertNotNull(result);
    }

    @Test
    void createCharacterTestOk() {
        String name = "Pablo";
        int age = 25;
        double height = 1.45;
        int weight = 50;
        var character = new PlayableCharacter(name, age, height, weight, 0, 0, "H");
        assertDoesNotThrow(() -> service.createCharacter(character));
    }

    @Test
    void createCharacterShouldFailWithAgeExceptionTest() {
        String name = "Pablo";
        int age = 125;
        double height = 1.45;
        int weight = 50;
        var character = new PlayableCharacter(name, age, height, weight, 0, 0, "H");
        assertThrows(PlayableCharacterAgeException.class, () -> service.createCharacter(character));
    }

    @Test
    void createCharacterShouldFailWithEmptyNameTest() {
        String name = "";
        int age = 125;
        double height = 1.45;
        int weight = 50;
        var character = new PlayableCharacter(name, age, height, weight, 0, 0, "H");
        assertThrows(Exception.class, () -> service.createCharacter(character));
    }
}
