package com.adviters.jpa;

import com.adviters.jpa.exceptions.PlayableCharacterAgeException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.adviters.jpa.JpaApplication.plusNumbers;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class JpaApplicationTests {
    @Autowired
    JpaApplication jpaApplication;

    @Test
    void contextLoads() {
    }

    @Test
    void plusNumberTest() {
        var x = 5;
        var y = 6;
        var result = plusNumbers(y, x);
		assertEquals(11, result);
    }

    @Test
    void createCharacterTestOk() {
        String name = "Pablo";
        int age = 25;
        double height = 1.45;
        int weight = 50;
        assertDoesNotThrow(() -> jpaApplication.createCharacter(name, age, height, weight));
    }

    @Test
    void createCharacterShouldFailWithAgeExceptionTest() {
        String name = "Pablo";
        int age = 125;
        double height = 1.45;
        int weight = 50;
        assertThrows(PlayableCharacterAgeException.class, () -> jpaApplication.createCharacter(name, age, height, weight));
    }

    @Test
    void createCharacterShouldFailWithEmptyNameTest() {
        String name = "";
        int age = 125;
        double height = 1.45;
        int weight = 50;
        assertThrows(Exception.class, () -> jpaApplication.createCharacter(name, age, height, weight));
    }
}
