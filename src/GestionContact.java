import java.util.*;

public class GestionContact {
    static ArrayList<Contact> listeContact = new ArrayList<>();

    public static void main(String[] args) {
        // menu doit permettre de ajoutés, modifier, supprimés, recherchés, afficher
        Menu testMenu = new Menu("Test d'un titre", "Ceci est une description", new String[]{
                "Voici une option",
                "Voici une autre option",
                "Ceci estune option test"});
        int choix = testMenu.afficherMenu();
        System.out.println(choix);
    }

    public static int afficherMenu(){
        System.out.println("-----------Menu de contact---------------\n");
        /*System.out.println("""
                1- Ajouter un contact
                2- Modifier un contact
                3- Supprimer un contact
                4- rechercher un contact
                5- Afficher liste des contacts
                6- Quitter le menu
                Votre choix :\s""");
        return new Scanner(System.in).nextInt();*/
        return 1;
    }

    public static void ajouterContact(){
        Scanner sc = new Scanner(System.in);
        System.out.println("-----Ajout d'un contact------\n" +
                "Entrer 'quit' pour annuler");

        System.out.println("Nom du contact : ");
        String nom = sc.next();
        if (nom.equals("quit")) {
            afficherMenu();
        }

        System.out.println("Prenom du contact : ");
        String prenom = sc.next();
        if (prenom.equals("quit")) {
            afficherMenu();
        }

        System.out.println("Numero de téléphone du contact : ");
        String tel = sc.next();
        if (tel.equals("quit")) {
            afficherMenu();
        }

        System.out.println("Email du contact : ");
        String email = sc.next();
        if (email.equals("quit")) {
            afficherMenu();
        }

        // Création du contact
        listeContact.add(new Contact(nom, prenom, tel, email));

    }

    public static void modifierContact(){
        System.out.println("-----------Modifier Contact---------------\n");
        System.out.println("\n" +
                "2- Modifier un contact\n" +
                "3- Supprimer un contact\n" +
                "4- rechercher un contact\n" +
                "5- Afficher liste des contacts\n" +
                "6- Quitter le menu");
    }

    public static void afficherContacts(){
        int cpt = 1;
        for (Contact c : listeContact){
            System.out.println(cpt + "- "+ c.getPrenomCtct() + c.getNomCtct());
        }
    }
}
