import java.util.Scanner;

abstract class Menu2 {
    /**
     * @param titre Élément du dessus du Menu qui va représenté ce dont le Menu va traiter.
     * @param desc Petite descriptions supplémentaire qui sera afficher juste en dessous du <code>titre</code>
     *             pour aider l'utilisateur à avoir un meilleur contexte dans le Menu
     * @param options Les options possible qui seront présenté à l'utilisateur dans lesqulles il devra faire un choix
     *                parmis uniquement ceux-ci.
     * @return Le numero du choix que l'utilisateur à sélectionné.
     * */
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

    /**
     * @param titre Élément du dessus du Menu qui va représenté ce dont le Menu va traiter.
     * @param desc Petite descriptions supplémentaire qui sera afficher juste en dessous du <code>titre</code>
     *             pour aider l'utilisateur à avoir un meilleur contexte dans le Menu
     * @param onlyOneInput Si on ne va que traiter la première chaine entré ou les autres qui suivent aussi.
     * @return Le choix que l'utilisateur à entré.
     * */
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
    /**
     * Obtient la meme longueur de '-' que la ligne qui contient le titre pour un menu plus soigné.
     * @return Un String contenant la bonne longueur de '_'
     * */
    private static String getUnderTitle(String titre) {
        StringBuilder finalStr = new StringBuilder();
        for (int i = 0; i < (30 + titre.length()); i++) {
            finalStr.append("-");
        }
        return finalStr.toString();
    }

    /**
     * Contruit un String pour soigné l'affichage des options possible.
     * @return Le String utilisé pour afficher les options possible pour l'utilisateur
     * */
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
