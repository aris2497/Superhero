package com.example.Superhero.dto;

public class Sighting {
    private int id;
    private String location;
    private String superCharacter;
    private String dateOf;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSuperCharacter() {
        return superCharacter;
    }

    public void setSuperCharacter(String superCharacter) {
        this.superCharacter = superCharacter;
    }

    public String getDateOf() {
        return dateOf;
    }

    public void setDateOf(String dateOf) {
        this.dateOf = dateOf;
    }
}
