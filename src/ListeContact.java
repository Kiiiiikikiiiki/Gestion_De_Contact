import javax.management.MalformedObjectNameException;
import java.lang.reflect.Array;
import java.util.*;

public class ListeContact extends ArrayList<Contact>{
    // Constructeur
    public ListeContact(){
        super();
    }

    // Méthode
    public void ajouterContact() {
        Scanner sc = new Scanner(System.in);

        String nom = new Menu("Ajout d'un contact", "Entrer le nom ('quit pour quitter') : ")
                .afficherMenu(true);
        if (nom.equals("quit")) {return;}

        String prenom = new Menu("Ajout d'un contact", "Entrer le prenom ('quit pour quitter') : ")
                .afficherMenu(true);
        if (prenom.equals("quit")) {return;}

        String numeroTel = new Menu("Ajout d'un contact", "Entrer le numero de téléphone ('quit pour quitter') : ")
                .afficherMenu(true);
        if (numeroTel.equals("quit")) {return;}

        String email = new Menu("Ajout d'un contact", "Entrer le email ('quit pour quitter') : ")
                .afficherMenu(true);
        if (email.equals("quit")) {return;}

        // Créer le nouveau contact et l'ajouter à la liste
        this.add(new Contact(nom, prenom, numeroTel, email));
    }

    public void modifierContact(){
        String contacts = obtenirListeContact();
        // Vérifier que la liste n'est pas empty
        if (!contacts.isEmpty()){
            // Affichage du menu de modification
            int choix = new Menu("Modifier Contact", "Choisir un contact à modifier",
                    contacts.split("/")).afficherMenu();

            // Obtenir le contact à modifier
            Contact contactToModif = this.get(choix-1);

            // Afficher les options de modification possible
            int choix2 = new Menu("Modifier Contact", "Choisissez ce que vous souhaitez modifier du contact",
                    new String[]{"Nom", "Prenom", "Numero de téléphone", "Email"}).afficherMenu();

            // Afficher le menu selon le choix
            String response;
            switch (choix2){
                case 1:
                     response = new Menu("Modifier le nom du contact",
                            "Ancienne valeur : " + contactToModif.getNomCtct() + "\nEntrer le nom à modifier : ")
                            .afficherMenu(true);
                    contactToModif.setNomCtct(response);
                case 2:
                    response = new Menu("Modifier le prenom du contact",
                            "Ancienne valeur : " + contactToModif.getPrenomCtct() + "\nEntrer le prenom à modifier : ")
                            .afficherMenu(true);
                    contactToModif.setPrenomCtct(response);
                case 3:
                    response = new Menu("Modifier le numero de téléphone du contact",
                            "Ancienne valeur : " + contactToModif.getNumeroTelCtct() +
                                    "\nEntrer le numero de téléphone à modifier : ")
                            .afficherMenu(true);
                    contactToModif.setNumeroTelCtct(response);
                case 4:
                    response = new Menu("Modifier le email du contact",
                            "Ancienne valeur : " + contactToModif.getEmailCtct() + "\nEntrer le email à modifier : ")
                            .afficherMenu(true);
                    contactToModif.setEmailCtct(response);
            }

            // Modifier le contact dans la liste de contact
            this.set(choix-1, contactToModif);
        }
        new Menu("Erreur", "Vous n'avez pas de contact dans votre liste (Enter any to quit)")
                .afficherMenu(true);
    }

    public void supprimerContact(){
        String contacts = obtenirListeContact();
        if (!contacts.isEmpty()){
            // Affichage du menu de supression
            int choix = new Menu("Supprimer Contact", "Choisir un contact à supprimer",
                    contacts.split("/")).afficherMenu();

            // Supprimer le contact selectionner
            this.remove(choix-1);
        }
    }

    public void rechercherContact() {
        // Obtenir l'élément de recherche de l'utilisateur
        String response = new Menu("Recherche de contact", "Entrer votre élément de recherche : ")
                .afficherMenu(true);

        // Lui retourner les contacts possible selon sont élément de recherche
        String contacts = obtenirListeContact(response);
        if (!contacts.isEmpty()){
            // Afficher les choix de contact possible pour obtenir leur information
            int choix = new Menu("Contact selon recherche", "Choisissez un contact pour voir ses informations",
                    contacts.split("/")).afficherMenu();
            // Obtenir le contact à afficher
            Contact c = this.get(choix-1);
            // Afficher les informations de ce contact à l'utilisateur
            new Menu("Information du contact", "Nom: " + c.getNomCtct() + "\nPrenom: " + c.getPrenomCtct() +
                    "\nNumero de téléphone: " + c.getNumeroTelCtct() + "\nEmail: " + c.getEmailCtct() +
                    "\n(Enter any to exit)").afficherMenu(true);

        } else {
            new Menu("Erreur", "Désolé nous n'avons pas pu trouver de contact commençant par votre élément de " +
                    "recherche..\nEnter any to quit").afficherMenu(true);
        }
    }

    // Méthode private
    private String obtenirListeContact(){
        StringBuilder contacts = new StringBuilder();
        // Vérifier que la liste n'est pas empty
        if (this.size() != 0) {
            // obtenir un string contenant les contact disponible
            for (Contact c : this) {
                contacts.append(c.getPrenomCtct());
                contacts.append(" ");
                contacts.append(c.getNomCtct());
                contacts.append("/");
            }
        }
        return contacts.toString();
    }

    private String obtenirListeContact(String searchEntry){
        StringBuilder contacts = new StringBuilder();
        // Vérifier que la liste n'est pas empty
        if (this.size() != 0) {
            // obtenir un string contenant les contact disponible selon le searchEntry
            for (Contact c : this) {
                if (c.getNomCtct().startsWith(searchEntry) || c.getPrenomCtct().startsWith(searchEntry)) {
                    contacts.append(c.getPrenomCtct());
                    contacts.append(" ");
                    contacts.append(c.getNomCtct());
                    contacts.append("/");
                }
            }
        }
        return contacts.toString();
    }
}
