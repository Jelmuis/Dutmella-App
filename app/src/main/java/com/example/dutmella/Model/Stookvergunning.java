package com.example.dutmella.Model;

import java.sql.Date;
import java.sql.Time;

public class Stookvergunning {

    private int idKampvuurVergunning;       //auto increment & primary key

    private String speltak_naam;
    private Date sDatum;
    private Time sTijd;
    private Date eDatum;
    private Time eTijd;

    public int getIdKampvuurVergunning() {
        return idKampvuurVergunning;
    }

    public void setIdKampvuurVergunning(int idKampvuurVergunning) {
        this.idKampvuurVergunning = idKampvuurVergunning;
    }

    public String getSpeltak_naam() {
        return speltak_naam;
    }

    public void setSpeltak_naam(String speltak_naam) {
        this.speltak_naam = speltak_naam;
    }

    public Date getsDatum() {
        return sDatum;
    }

    public void setsDatum(Date sDatum) {
        this.sDatum = sDatum;
    }

    public Time getsTijd() {
        return sTijd;
    }

    public void setsTijd(Time sTijd) {
        this.sTijd = sTijd;
    }

    public Date geteDatum() {
        return eDatum;
    }

    public void seteDatum(Date eDatum) {
        this.eDatum = eDatum;
    }

    public Time geteTijd() {
        return eTijd;
    }

    public void seteTijd(Time eTijd) {
        this.eTijd = eTijd;
    }
}
