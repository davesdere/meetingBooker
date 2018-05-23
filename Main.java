package com.company;
import java.util.ArrayList;
import java.util.Scanner;

/*******************************************
 *          meetingBooker                   *
 *          David Cote GNU GPL3.0  2018     *
 *          Un simple outil de booking      *
 *          de rdv pour aider un ami.       *
 *          Non persistent.                 *
 ********************************************/

public class Main {

    //public static int nbClients = 0;
    //public static int nbMeeting = 0;
    private static ArrayList<Client> listeClient = new ArrayList<>();
    private static ArrayList<Meeting> listeMeeting = new ArrayList<>();

    /*
    Script de test
    */
    public static void scriptDeTest() {
        listeClient.add(new Client("John", "Smith", "01-12-1990", "1 rue de l'espion", "514-777-8888"));
        listeClient.add(new Client("Jane", "Doh", "29-09-83", "102 rue du succes", "450-666-8888"));
        listeMeeting.add(new Meeting("12-01-18)", "14:00"));
    }


    //MENU PRINCIPAL ET SES FONCTIONNALITES
    public static void main(String args[]) {
        scriptDeTest();
        while (true) {
            Scanner lectureClavier = new Scanner(System.in);
            System.out.println(" ");
            System.out.println("### MENU PRINCIPAL ###");
            System.out.println("1. Creer une fiche client");
            System.out.println("2. Modifier la fiche d'un client");
            System.out.println("3. Afficher la fiche d'un client");
            System.out.println("4. Ajouter un rendez-vous");
            System.out.println("5. Modifier un rendez-vous");
            System.out.println("6. Supprimer un rendez-vous");
            System.out.println("7. Afficher des statistiques>");
            System.out.println("99. Quitter l’application");
            System.out.print("?");

            int option1;
            option1 = lectureClavier.nextInt();
            menu1:
            switch (option1) {
                case 1:
                    Client p = new Client().creerFiche();
                    listeClient.add(p);
                    System.out.println(" ");
                    break;
                case 2:
                    afficherListeClients();
                    System.out.println("--------------------------");
                    System.out.println("Saisissez le numéro du client à modifier: ");
                    int positionListe = lectureClavier.nextInt();
                    listeClient.get(positionListe-1).modifierFiche();
                    break;
                case 3:
                    afficherListeClients();
                    System.out.println("--------------------------");
                    System.out.println("Saisissez le numéro du client à afficher: ");
                    positionListe = lectureClavier.nextInt();
                    listeClient.get(positionListe-1).afficherFiche();
                    break;
                case 4://ajouter un Meeting
                    afficherListeClients();
                    System.out.println("--------------------------");
                    System.out.println("Saisissez le numéro du client à afficher: ");
                    positionListe = lectureClavier.nextInt();
                    //Creation d'un Meeting
                    Meeting nouveauMeeting = new Meeting().creerNouveauMeeting();
                    //Ajout a la liste de Meeting du main
                    listeMeeting.add(nouveauMeeting);
                    //Ajout a la liste de Meeting par Client
                    listeClient.get(positionListe-1).ajouterMeetingClient(nouveauMeeting);
                    nouveauMeeting.afficher();
                    break;
                case 5:
                    afficherListeClients();
                    System.out.println("--------------------------");
                    System.out.println("Saisissez le numéro du client à afficher: ");
                    positionListe = lectureClavier.nextInt();
                    listeClient.get(positionListe-1).modifierMeetingClient();
                    break;
                case 6:
                    afficherListeClients();
                    System.out.println("--------------------------");
                    System.out.println("Saisissez le numéro du client à afficher: ");
                    positionListe = lectureClavier.nextInt();
                    listeClient.get(positionListe-1).supprimerMeetingClient();
                    break;
                case 7:
                    while (true) {
                        System.out.println(" ");
                        System.out.println("### MENU STATISTIQUE ###");
                        System.out.println("1. Afficher le nombre total des Clients");
                        System.out.println("2. Afficher le nombre des rendez-vous par année de chaque Client");
                        System.out.println("3. Afficher les Clients qui n'ont pas consulté depuis une année");
                        System.out.println("99. Revenir au menu principal");
                        System.out.println("?");

                        Scanner scanner2 = new Scanner(System.in);
                        int option2;
                        option2 = scanner2.nextInt();

                        switch (option2) {
                            case 1:
                                System.out.println("Le nombre total de clients est" + listeClient.size());
                                break;
                            case 2:
                                for(int i =0;i< listeClient.size();i++){
                                    if(listeClient.get(i).getListMeeting().size()!=0)
                                        System.out.println("Client: "+listeClient.get(i).getPrenom()+" "+listeClient.get(i).getNom()+" "+listeClient.get(i).getListMeeting().size());
                                }
                                break;
                            case 3:
                                for(int i =0;i< listeClient.size();i++){
                                    if(listeClient.get(i).getListMeeting().size()==0)
                                        System.out.println("Client: "+listeClient.get(i).getPrenom()+" "+listeClient.get(i).getNom()+" n'a pas ete rencontre cette annee");
                                }
                                break;
                            case 99:
                                break menu1;
                            default:
                                System.out.println("Choix invalide !");
                                break;
                        }
                    }
                case 99:
                    return;
                default:
                    System.out.println("Choix invalide !");
                    break;
            }
        }
    }

    // #1 rentrer l'information d'un nouveau client dans le system



    //affichage Clients noms  (pour seulement afficer les prenoms et noms comme demander au début de certaines options)
    public static void afficherListeClients() {
        String chaine = "Liste des Clients"+"\n";
        for (int i = 0; i < listeClient.size(); i++)
            chaine += ((i + 1) + ": " + listeClient.get(i).getPrenom() + " " + listeClient.get(i).getNom()+"\n");
        System.out.println(chaine);
    }
}