package com.example.dutmella.Model;

public class Overnachting {

    private String idOvernachtingVergunning;      //auto increment & primary key.

    private String speltak_naam;
    private String aant_begeleiders;
    private String min_leeftijd_beg;
    private String max_leeftijd_beg;

    private String aant_leden;
    private String min_leeftijd_lid;
    private String max_leeftijd_lid;

    private String sDatum;
    private String sTijd;
    private String eDatum;
    private String eTijd;


    public Overnachting(){

    }

    public String getIdOvernachting() {
        return idOvernachtingVergunning;
    }

    public void setIdOvernachting(String idOvernachtingVergunning) {
        this.idOvernachtingVergunning = idOvernachtingVergunning;
    }

    public String getSpeltak_naam() {
        return speltak_naam;
    }

    public void setSpeltak_naam(String speltak_naam) {
        this.speltak_naam = speltak_naam;
    }

    public String getAant_begeleiders() {
        return aant_begeleiders;
    }

    public void setAant_begeleiders(String aant_begeleiders) {
        this.aant_begeleiders = aant_begeleiders;
    }

    public String getMin_leeftijd_beg() {
        return min_leeftijd_beg;
    }

    public void setMin_leeftijd_beg(String min_leeftijd_beg) {
        this.min_leeftijd_beg = min_leeftijd_beg;
    }

    public String getMax_leeftijd_beg() {
        return max_leeftijd_beg;
    }

    public void setMax_leeftijd_beg(String max_leeftijd_beg) {
        this.max_leeftijd_beg = max_leeftijd_beg;
    }

    public String getAant_leden() {
        return aant_leden;
    }

    public void setAant_leden(String aant_leden) {
        this.aant_leden = aant_leden;
    }

    public String getMin_leeftijd_lid() {
        return min_leeftijd_lid;
    }

    public void setMin_leeftijd_lid(String min_leeftijd_lid) {
        this.min_leeftijd_lid = min_leeftijd_lid;
    }

    public String getMax_leeftijd_lid() {
        return max_leeftijd_lid;
    }

    public void setMax_leeftijd_lid(String max_leeftijd_lid) {
        this.max_leeftijd_lid = max_leeftijd_lid;
    }

    public String getsDatum() {
        return sDatum;
    }

    public void setsDatum(String sDatum) {
        this.sDatum = sDatum;
    }

    public String getsTijd() {
        return sTijd;
    }

    public void setsTijd(String sTijd) {
        this.sTijd = sTijd;
    }

    public String geteDatum() {
        return eDatum;
    }

    public void seteDatum(String eDatum) {
        this.eDatum = eDatum;
    }

    public String geteTijd() {
        return eTijd;
    }

    public void seteTijd(String eTijd) {
        this.eTijd = eTijd;
    }
}
