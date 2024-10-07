import java.util.*;

public class Menu {
    private String titre;
    private String desc;
    private String[] options;

    // Getters and setters
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    // Constructeur

    // Constructeur avec options
    public Menu(String titre, String desc, String[] options) {
        this.titre = titre;
        this.desc = desc;
        this.options = options;
    }

    // Constructeur sans options
    public Menu(String titre, String desc) {
        this.titre = titre;
        this.desc = desc;
    }

    // Methode de classe
    public int afficherMenu() {
        // Créer la variable choix qui sera retourner à la fin
        int choix;
        do {
            // Toujours flush avant d'afficher un menu pour soigner l'affichage
            System.out.flush();
            // Affiche le menu
            System.out.println("---------------" + this.titre + "---------------");
            System.out.println(this.desc);
            System.out.println(getUnderTitle());
            System.out.println(getOptions());
            System.out.println("Entrer votre choix : ");

            // Gérer l'entrer de l'utilisateur
            // Créer un Scanner
            Scanner sc = new Scanner(System.in);
            try {
                choix = sc.nextInt();
            } catch (Exception e) {
                choix = -1;
            }
        } while (choix > this.options.length || choix < 0);
        return choix;
    }

    public String afficherMenu(boolean onlyOneInput) {
        // Créer un Scanner
        Scanner sc = new Scanner(System.in);
        // Toujours flush avant d'afficher un menu pour soigner l'affichage
        System.out.flush();
        // Affiche le menu
        System.out.println("---------------" + this.titre + "---------------");
        System.out.println(this.desc);
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
    private String getUnderTitle() {
        StringBuilder finalStr = new StringBuilder();
        for (int i = 0; i < (30 + this.titre.length()); i++) {
            finalStr.append("-");
        }
        return finalStr.toString();
    }

    private String getOptions() {
        StringBuilder finalStr = new StringBuilder();
        int cpt = 1; // Compteur pour numeroté les choix
        for (String option : this.options) {
            finalStr.append(cpt);
            finalStr.append("- ");
            finalStr.append(option);
            finalStr.append("\n");
            cpt++;
        }
        return finalStr.toString();
    }
}
