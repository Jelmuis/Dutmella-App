package com.example.dutmella.Model;

/**
 * @author : Jelle Muijsers
 * Hier kunnen staan alle eigenschappen van dit object gedefineerd en kunnen de get & set
 *   methodes aangeroepen worden.
 */

public class ProductReservering {

    private int idReservering_product;  //auto increment & primary key
    private int id_IdReservering;       //foreign key uit Reservering
    private int id_IdProduct;           //foreign key uit Product
}
