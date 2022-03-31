package com.adviters.jpa.controllers;

import com.adviters.jpa.model.PlayableCharacter;
import com.adviters.jpa.services.PlayableCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Es necesario agregar esta anotación para que la api interprete que esto es un controlador
@RestController
// Con esto podemos setear que la url sea: http://localhost:8080/character/
@RequestMapping("/character/")
public class PlayableCharacterController {
    // Inyectamos el servicio correspondiente
    @Autowired
    PlayableCharacterService service;

    @GetMapping
    public PlayableCharacter getCharacterById(int id) throws Exception {
        return service.getById(id);
    }

    @DeleteMapping
    public void deleteCharacter(int id) {
        service.deleteCharacter(id);
    }

    @PutMapping
    public PlayableCharacter updateCharacter(PlayableCharacter playableCharacter) throws Exception {
        return service.updateCharacter(playableCharacter);
    }

    @PostMapping("create")
    public int createCharacter(PlayableCharacter playableCharacter) throws Exception {
        return service.createCharacter(playableCharacter);
    }

}
