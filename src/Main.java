import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static HashMap<Integer, Vehicule> vehicules = new HashMap<>();

    public static void main(String[] args) {
        DriverManager DatabaseConnection;
        Connection connection = DatabaseConnection.getConnection();

        if (connection != null) {
            Scanner scanner = new Scanner(System.in);
            boolean running = true;

            while (running) {
                System.out.println("Système de Gestion de Parc de Véhicules");
                System.out.println("1. Ajouter un véhicule");
                System.out.println("2. Supprimer un véhicule");
                System.out.println("3. Modifier un véhicule par son identifiant");
                System.out.println("4. Rechercher un véhicule par nom");
                System.out.println("5. Lister les véhicules en saisissant une lettre alphabétique");
                System.out.println("6. Afficher le nombre de véhicules en stock");
                System.out.println("7. Quitter");
                System.out.print("Choisissez une option : ");

                int choix = scanner.nextInt();
                scanner.nextLine(); // Consommer la nouvelle ligne

                switch (choix) {
                    case 1:
                        ajouterVehicule(scanner);
                        break;
                    case 2:
                        supprimerVehicule(scanner);
                        break;
                    case 3:
                        modifierVehicule(scanner);
                        break;
                    case 4:
                        rechercherVehicule(scanner);
                        break;
                    case 5:
                        listerVehicules(scanner);
                        break;
                    case 6:
                        afficherNombreVehicules();
                        break;
                    case 7:
                        running = false;
                        break;
                    default:
                        System.out.println("Option invalide. Veuillez réessayer.");
                        break;
                }
            }

            DatabaseConnection.closeConnection();
            scanner.close();
        }
    }

    private static void ajouterVehicule(Scanner scanner) {
        System.out.print("Entrez l'identifiant du véhicule : ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consommer la nouvelle ligne

        System.out.print("Entrez le nom du véhicule : ");
        String nom = scanner.nextLine();

        System.out.print("Entrez la marque du véhicule : ");
        String marque = scanner.nextLine();

        System.out.print("Entrez le modèle du véhicule : ");
        String modele = scanner.nextLine();

        System.out.print("Entrez l'année du véhicule : ");
        int annee = scanner.nextInt();

        System.out.print("Entrez le type du véhicule (Voiture, Camion, Moto) : ");
        String type = scanner.next();

        System.out.print("Entrez l'attribut spécifique du véhicule (capacité ou cylindrée) : ");
        int attributSpecifique = scanner.nextInt();

        Vehicule vehicule = new Vehicule(id, nom, marque, modele, annee, type, attributSpecifique);
        vehicules.put(id, vehicule);
        System.out.println("Véhicule ajouté avec succès !");
    }

    private static void supprimerVehicule(Scanner scanner) {
        System.out.print("Entrez l'identifiant du véhicule à supprimer : ");
        int id = scanner.nextInt();
        if (vehicules.remove(id) != null) {
            System.out.println("Véhicule supprimé avec succès !");
        } else {
            System.out.println("Aucun véhicule trouvé avec cet identifiant.");
        }
    }

    private static void modifierVehicule(Scanner scanner) {
        System.out.print("Entrez l'identifiant du véhicule à modifier : ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consommer la nouvelle ligne

        Vehicule vehicule = vehicules.get(id);
        if (vehicule != null) {
            System.out.print("Entrez le nouveau nom du véhicule : ");
            String nom = scanner.nextLine();
            vehicule.setNom(nom);

            System.out.print("Entrez la nouvelle marque du véhicule : ");
            String marque = scanner.nextLine();
            vehicule.setMarque(marque);

            System.out.print("Entrez le nouveau modèle du véhicule : ");
            String modele = scanner.nextLine();
            vehicule.setModele(modele);

            System.out.print("Entrez la nouvelle année du véhicule : ");
            int annee = scanner.nextInt();
            vehicule.setAnnee(annee);

            System.out.print("Entrez le nouveau type du véhicule : ");
            String type = scanner.next();
            vehicule.setType(type);

            System.out.print("Entrez le nouvel attribut spécifique du véhicule : ");
            int attributSpecifique = scanner.nextInt();
            vehicule.setAttributSpecifique(attributSpecifique);

            System.out.println("Véhicule modifié avec succès !");
        } else {
            System.out.println("Aucun véhicule trouvé avec cet identifiant.");
        }
    }

    private static void rechercherVehicule(Scanner scanner) {
        System.out.print("Entrez le nom du véhicule à rechercher : ");
        String nom = scanner.next();
        boolean found = false;
        for (Vehicule vehicule : vehicules.values()) {
            if (vehicule.getNom().equalsIgnoreCase(nom)) {
                System.out.println(vehicule);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Aucun véhicule trouvé avec ce nom.");
        }
    }

    private static void listerVehicules(Scanner scanner) {
        System.out.print("Entrez une lettre alphabétique pour lister les véhicules : ");
        String lettre = scanner.next();
        for (Vehicule vehicule : vehicules.values()) {
            if (vehicule.getNom().startsWith(lettre)) {
                System.out.println(vehicule);
            }
        }
    }

    private static void afficherNombreVehicules() {
        System.out.println("Nombre de véhicules en stock : " + vehicules.size());
    }
}
