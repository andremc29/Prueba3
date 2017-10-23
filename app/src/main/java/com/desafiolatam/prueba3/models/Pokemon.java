package com.desafiolatam.prueba3.models;

/**
 * Created by amuno on 20-10-2017.
 */

public class Pokemon {
    private String id;
    private String name;

    public Pokemon() {
    }

    public Pokemon(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
