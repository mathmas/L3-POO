import java.util.Scanner;

// Fait par GEMINI

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialisation avec nos constantes statiques
        Complexe sommeTotale = Complexe.ZERO;
        Complexe produitTotal = Complexe.UN;

        System.out.println("=== Calculatrice de Nombres Complexes ===");

        boolean continuer = true;
        int compteur = 0;

        while (continuer) {
            System.out.println("\nQue souhaitez-vous faire ?");
            System.out.println("1 - Saisir un complexe (parties réelle/imaginaire)");
            System.out.println("2 - Saisir un complexe (coordonnées polaires)");
            System.out.println("3 - Terminer la saisie et afficher les résultats");
            System.out.print("Votre choix : ");

            int choix = scanner.nextInt();
            Complexe nouveauComplexe = null;

            if (choix == 1) {
                System.out.print("Entrez la partie réelle : ");
                double reel = scanner.nextDouble();
                System.out.print("Entrez la partie imaginaire : ");
                double imag = scanner.nextDouble();
                nouveauComplexe = new Complexe(reel, imag);

            } else if (choix == 2) {
                System.out.print("Entrez le module (rho) : ");
                double rho = scanner.nextDouble();
                System.out.print("Entrez l'argument (theta en radians) : ");
                double theta = scanner.nextDouble();
                nouveauComplexe = Complexe.fromPolarCoordinates(rho, theta);

            } else if (choix == 3) {
                continuer = false;
                continue;
            } else {
                System.out.println("Choix invalide.");
                continue;
            }

            // Mise à jour des calculs
            compteur++;
            sommeTotale = sommeTotale.somme(nouveauComplexe);
            produitTotal = produitTotal.multiplication(nouveauComplexe);

            System.out.println("-> Complexe saisi : " + nouveauComplexe.toString());
        }

        // Affichage des résultats
        System.out.println("\n=== Résultats ===");
        if (compteur == 0) {
            System.out.println("Aucun nombre n'a été saisi.");
        } else {
            System.out.println("Nombre de complexes saisis : " + compteur);
            System.out.println("Somme totale : " + sommeTotale.toString());
            System.out.println("Produit total : " + produitTotal.toString());
        }

        scanner.close();
    }
}