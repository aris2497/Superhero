package com.example.Superhero.dao;

import com.example.Superhero.dto.SuperCharacter;

import java.util.List;

public interface SuperCharacterDao {

    //CRUD
    SuperCharacter getSuperCharacterById(int id);
    SuperCharacter addSuperCharacter(SuperCharacter superChar);
    void updateSuperCharacter(SuperCharacter superChar);
    void deleteSuperCharacterById(int id);

    List<SuperCharacter> getAllSuperCharacters();
    List<SuperCharacter> getAllSuperCharactersByLocation(int id); //to report all of the superheroes sighted at a particular location.
}
