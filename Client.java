package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    Scanner lectureClavier = new Scanner(System.in);

    /*Attributs*/
    private String nom;
    private String prenom;
    private String dateNaissance;
    private String adresse;
    private String telephone;
    private ArrayList<Meeting> listeMeetingClient = new ArrayList<>();

    /*Constructeurs */

    public Client(){
        nom = "";
        prenom ="";
        dateNaissance = "";
        adresse = "";
        telephone = "";
        ArrayList<Meeting> listeMeetingClient = new ArrayList<>();
    }


    public Client (String nPrenom, String nNom, String nDateNaissance, String nAdresse, String nTelephone){
        nom = nNom;
        prenom = nPrenom;
        dateNaissance = nDateNaissance;
        adresse = nAdresse;
        telephone = nTelephone;
    }

    // Accesseur de modification : setters

    public void setNom(String nNom) {nom=nNom;}

    public void setPrenom(String nPrenom) { prenom = nPrenom; }

    public void setDateNaissance(String nDateNaissance) { dateNaissance = nDateNaissance; }

    public void setAdresse(String nAdresse) { adresse = nAdresse; }

    public void setTelephone(String nTelephone) { telephone = nTelephone; }


    //  Accesseur en lecture :getters

    public String getNom() { return nom; }

    public String getPrenom() { return prenom; }

    public String getDateNaissance() { return dateNaissance; }

    public String getAdresse() { return adresse; }

    public String getTelephone() { return telephone; }

    public Client creerFiche(){
        Scanner c = new Scanner(System.in);
        System.out.println("Veuillez entrer le prenom du Client: ");
        this.prenom = c.nextLine();
        System.out.println("Veuillez entrer le nom du Client: ");
        this.nom = c.nextLine();
        System.out.println("Veuillez entrer l'adresse du Client: ");
        this.adresse = c.nextLine();
        System.out.println("Veuillez entrer la date de naissance du Client: ");
        this.dateNaissance = c.nextLine();
        System.out.println("Veuillez entrer le numero de telephone du Client: ");
        this.telephone = c.nextLine();
        System.out.println("Vous avez cree une fiche pour le Client "+prenom+" "+nom+".");
        this.listeMeetingClient = new ArrayList<>();
        return this;
    }

    public void afficherFiche(){
        System.out.println("Info Client:");
        System.out.println("––––––––-----------––––––");
        System.out.println ("Prenom : " + this.getPrenom() + " Nom : " + getNom());
        System.out.println ("Adresse : " + this.getAdresse());
        System.out.println ("Date de naissance (JJ-MM-AA): " + this.getDateNaissance());
        System.out.println ("Numero de telephone : " + this.getTelephone());
        if (listeMeetingClient.isEmpty()) {
            System.out.println("Aucun rendez-vous d'enregistre dans le systeme");
        }else{
            afficherListeMeetingClient();
        }
    }

    public void modifierFiche(){
        Scanner lectureClavierTexte = new Scanner(System.in);
        int choix = 0;
        while (choix!=99) {
            System.out.println("Client :"+ this.getPrenom()+" "+this.getNom());
            System.out.println("Choisissez l'information du Client a modifier:");
            System.out.println("1. Modifier le prenom");
            System.out.println("2. Modifier le nom");
            System.out.println("3. Modifier l'adresse");
            System.out.println("4. Modifier la date de naissance");
            System.out.println("5. Modifier le numero de telephone");
            System.out.println("99. Quitter le menu");
            System.out.print("?");
            choix = lectureClavier.nextInt();
            switch (choix) {
                case 1:
                    System.out.println("Saisissez le prenom :");
                    prenom = lectureClavierTexte.nextLine();
                    this.setPrenom(prenom);
                    break;
                case 2:
                    System.out.println("Saisissez le nom");
                    this.setNom(lectureClavierTexte.nextLine());
                    break;
                case 3:
                    System.out.println("Saisissez l'adresse");
                    this.setAdresse(lectureClavierTexte.nextLine());
                    break;
                case 4:
                    System.out.println("Saisissez la date de naissance (JJ-MM-AA)");
                    this.setDateNaissance(lectureClavierTexte.nextLine());
                    break;
                case 5:
                    System.out.println("Saisissez le numero de telephone (###-###-####)");
                    this.setTelephone(lectureClavierTexte.nextLine());
                    break;

                case 99:
                    System.out.println("Retour au menu principale");

                    break;
                default:
                    System.out.println("Merci d'avoir utiliser notre systeme");
                    System.exit(0);
            }
        }
    }
    public void ajouterMeetingClient(Meeting nouveauMeeting){
        listeMeetingClient.add(nouveauMeeting);
    }
    public void afficherListeMeetingClient(){
        for (int i= 0; i < listeMeetingClient.size();++i){
            System.out.println(i+1+": "+listeMeetingClient.get(i).getDate()+ " a "+listeMeetingClient.get(i).getHeure());
        }
    }
    public void modifierMeetingClient(){
        afficherListeMeetingClient();
        int positionListe = lectureClavier.nextInt();
        listeMeetingClient.get(positionListe-1).modifierMeeting();
    }
    public void supprimerMeetingClient(){
        afficherListeMeetingClient();
        int positionListe = lectureClavier.nextInt();
        listeMeetingClient.remove(positionListe-1);
    }
    public ArrayList getListMeeting(){
        return listeMeetingClient;
    }
}
