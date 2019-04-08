package com.example.dutmella.Model;


/**
 * @author : Jelle Muijsers
 * Speltakklasse
 * Hier kunnen staan alle eigenschappen van dit object gedefineerd en kunnen de get & set
 * methodes aangeroepen worden.
 */
public class Speltak {

    private String naam;        //primary key

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam){
        this.naam = naam;
    }
}
