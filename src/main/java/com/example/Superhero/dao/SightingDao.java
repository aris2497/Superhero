package com.example.Superhero.dao;

import com.example.Superhero.dto.Location;
import com.example.Superhero.dto.Sighting;

import java.util.Date;
import java.util.List;

public interface SightingDao {
    List<Sighting> getAllSightingByDate(Date sightingDate);
    Sighting getSightingByLocationAndTime(Location location, String time);

}
