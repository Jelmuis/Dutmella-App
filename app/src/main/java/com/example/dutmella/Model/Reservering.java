package com.example.dutmella.Model;


/**
 * @author : Jelle Muijsers
 * Hier kunnen staan alle eigenschappen van dit object gedefineerd en kunnen de get & set
 * methodes aangeroepen worden.
 */
public class Reservering {

    private String idReservering;      //Auto increment & primaryKey
    private String id_Accountemail;     //foreign key uit Account
    private String id_IdKampvuur;       //foreign key uit Kampvuur
    private String id_IdOvernachting;   //foreign key uit Overnachting



    public Reservering(){

    }


    public String getId_Accountemail() {
        return id_Accountemail;
    }

    public void setId_Accountemail(String id_Accountemail) {
        this.id_Accountemail = id_Accountemail;
    }

    public String getId_IdKampvuur() {
        return id_IdKampvuur;
    }

    public void setId_IdKampvuur(String id_IdKampvuur) {
        this.id_IdKampvuur = id_IdKampvuur;
    }

    public String getId_IdOvernachting() {
        return id_IdOvernachting;
    }

    public void setId_IdOvernachting(String id_IdOvernachting) {
        this.id_IdOvernachting = id_IdOvernachting;
    }
}
