package com.example.dutmella.Model;


/**
 * @author : Jelle Muijsers
 * Hier kunnen staan alle eigenschappen van dit object gedefineerd en kunnen de get & set
 *   methodes aangeroepen worden.
 */
public class Product {

    private int idProduct;              //auto increment & primary key
    private String naam;
    private String aantal;
    private String beschrijving;

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getAantal() {
        return aantal;
    }

    public void setAantal(String aantal) {
        this.aantal = aantal;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }


}
