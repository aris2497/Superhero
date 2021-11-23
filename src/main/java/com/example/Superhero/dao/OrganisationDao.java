package com.example.Superhero.dao;

import com.example.Superhero.dto.Organisation;
import com.example.Superhero.dto.SuperCharacter;

import java.util.List;

public interface OrganisationDao {
    List<Organisation> getAllSuperCharacterOrganisations(SuperCharacter superChar);

}
