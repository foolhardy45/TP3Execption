import ExercicePersonnesMortesEnonce.*;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList persons = new ArrayList();
        EtatCivil etatCivil = new EtatCivil(persons);

        boolean exit = false;

        while (!exit) {

            System.out.println("---- Menu de Gestion de l'État Civil ----");
            System.out.println("1. Ajouter une personne");
            System.out.println("2. Supprimer une personne");
            System.out.println("3. Marquer une personne comme décédée");
            System.out.println("4. Lier deux personnes (mariage/pacs)");
            System.out.println("5. Définir un ascendant et un descendant");
            System.out.println("6. Afficher les personnes vivantes");
            System.out.println("7. Afficher les morts après 1960");
            System.out.println("8. Quitter");
            System.out.print("Choisissez une option: ");
            int choix = scanner.nextInt();
            scanner.nextLine();  // Consomme le saut de ligne


            try {
                switch (choix) {
                    case 1:
                        System.out.print("Nom: ");
                        String nom = scanner.nextLine();
                        System.out.print("Année de naissance: ");
                        int anneeNaissance = scanner.nextInt();
                        etatCivil.ajouterPersonnage(new Personne(nom, anneeNaissance));
                        break;
                    case 2:
                        System.out.print("Nom de la personne à supprimer: ");
                        String nomSupp = scanner.nextLine();
                        etatCivil.suppPersonne(nomSupp);
                        break;
                    case 3:
                        System.out.print("Nom de la personne à marquer décédée: ");
                        String nomDeces = scanner.nextLine();
                        System.out.print("Année de décès: ");
                        int anneeMort = scanner.nextInt();
                        etatCivil.enregistrerMort(nomDeces, anneeMort);
                        break;
                    case 4:
                        System.out.print("Nom de la première personne: ");
                        String nom1 = scanner.nextLine();
                        System.out.print("Nom de la deuxième personne: ");
                        String nom2 = scanner.nextLine();
                        System.out.print("Date du lien (mariage/pacs): ");
                        String dateLien = scanner.nextLine();
                        etatCivil.lierPersonnes(nom1, nom2, dateLien);
                        break;
                    case 5:
                        System.out.print("Nom de l'ascendant: ");
                        String nomAscendant = scanner.nextLine();
                        System.out.print("Nom du descendant: ");
                        String nomDescendant = scanner.nextLine();
                        etatCivil.definirAscendant(nomAscendant, nomDescendant);
                        break;
                    case 6:
                        System.out.println("Nombre de vivants: " + etatCivil.nombreDeVivant());
                        break;
                    case 7:
                        System.out.println("Nombre de morts après 1960: " + etatCivil.nombreDeMortApres1960());
                        break;
                    case 8:
                        exit = true;
                        System.out.println("Sortie du programme.");
                        break;
                    default:
                        System.out.println("Option invalide.");
                }
            } catch (EtatCivilException | FauxNomException | DeJaMortException e) {
                System.out.println("Erreur: " + e.getMessage());
            }
        }

        scanner.close();
    }
}

