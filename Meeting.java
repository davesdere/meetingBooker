package com.company;
import java.util.Scanner;

public class Meeting {
    Scanner lectureClavier = new Scanner(System.in);
    // attributs

    private String date;
    private String heure;

    // contructeur

    public Meeting(){
        date= "";
        heure="";
    }

    public Meeting(String nDates, String nHeures) {
        date = nDates;
        heure = nHeures;
    }

    // Accesseur de modification : setters

    public void setDate(String nDates) {  date = nDates; }

    public void setHeure(String nHeures) { heure = nHeures; }

//  Accesseur en lecture :getters

    public String getDate() { return date; }

    public String getHeure() { return heure; }
    public Meeting creerNouveauMeeting(){
        System.out.println("Saisissez la date du rendez-vous (JJ-MM-AA)");
        this.setDate(lectureClavier.nextLine());
        System.out.println("Saisissez l'heure du rendez-vous (HH:MM)");
        this.setHeure(lectureClavier.nextLine());
        System.out.println("Vous avez cree un nouveau rendez-vous pour");
        return this;
    }

    public void modifierMeeting(){
        System.out.println("Saisissez la nouvelle date du rendez-vous (JJ-MM-AA)");
        this.setDate(lectureClavier.nextLine());
        System.out.println("Saisissez la nouvelle heure du rendez-vous (HH:MM)");
        this.setHeure(lectureClavier.nextLine());
    }
    public void afficher (){
        System.out.println("Le " + date + " a "+ heure);
    }
}

