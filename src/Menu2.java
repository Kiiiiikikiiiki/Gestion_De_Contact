import java.util.Scanner;

abstract class Menu2 {
    public static int afficherMenu(String titre, String desc, String[] options) {
        // Créer la variable choix qui sera retourner à la fin
        int choix;
        do {
            // Affiche le menu
            System.out.println("---------------" + titre + "---------------");
            System.out.println(desc);
            System.out.println(getUnderTitle(titre));
            System.out.println(getOptions(options));
            System.out.println("Entrer votre choix : ");

            // Gérer l'entrer de l'utilisateur
            // Créer un Scanner
            Scanner sc = new Scanner(System.in);
            try {
                choix = sc.nextInt();
            } catch (Exception e) {
                choix = -1;
            }
        } while (choix > options.length || choix < 0);
        return choix;
    }

    public static String afficherMenu(String titre, String desc, boolean onlyOneInput) {
        // Créer un Scanner
        Scanner sc = new Scanner(System.in);
        // Affiche le menu
        System.out.println("---------------" + titre + "---------------");
        System.out.println(desc);
        // Gérer l'entrer de l'utilisateur
        String choix;
        if (onlyOneInput) {
            choix = sc.next();
        } else {
            choix = sc.nextLine();
        }
        return choix;
    }

    // Methode private
    private static String getUnderTitle(String titre) {
        StringBuilder finalStr = new StringBuilder();
        for (int i = 0; i < (30 + titre.length()); i++) {
            finalStr.append("-");
        }
        return finalStr.toString();
    }

    private static String getOptions(String[] options) {
        StringBuilder finalStr = new StringBuilder();
        int cpt = 1; // Compteur pour numeroté les choix
        for (String option : options) {
            finalStr.append(cpt);
            finalStr.append("- ");
            finalStr.append(option);
            finalStr.append("\n");
            cpt++;
        }
        return finalStr.toString();
    }
}
