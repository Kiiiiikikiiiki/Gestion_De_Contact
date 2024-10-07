import java.util.*;

public class ListeContact extends ArrayList<Contact>{
    // Constructeur
    public ListeContact(Contact... contacts){ // var args de Contact peut prendre 0 à plusieur Contact
        super(Arrays.asList(contacts));
    }

    // Default constructor
    public ListeContact(){
        super();
    }

    // Méthode
    public void ajouterContact() {
        Scanner sc = new Scanner(System.in);

        String nom = Menu2.afficherMenu("Ajout d'un contact", "Entrer le nom ('quit pour quitter') : ",
                true);
        if (nom.equals("quit")) {return;}

        String prenom = Menu2.afficherMenu("Ajout d'un contact", "Entrer le prenom ('quit pour quitter') : ",
                true);
        if (prenom.equals("quit")) {return;}

        String numeroTel = Menu2.afficherMenu("Ajout d'un contact", "Entrer le numero de téléphone ('quit pour quitter') : ",
                true);
        if (numeroTel.equals("quit")) {return;}

        String email = Menu2.afficherMenu("Ajout d'un contact", "Entrer le email ('quit pour quitter') : ",
                true);
        if (email.equals("quit")) {return;}

        // Créer le nouveau contact et l'ajouter à la liste
        this.add(new Contact(nom, prenom, numeroTel, email));
    }

    public void modifierContact(){
        String contacts = obtenirListeContact(this);
        // Vérifier que la liste n'est pas empty
        if (!contacts.isEmpty()){
            // Affichage du menu de modification
            int choix = Menu2.afficherMenu("Modifier Contact", "Choisir un contact à modifier",
                    contacts.split("/"));

            // Obtenir le contact à modifier
            Contact contactToModif = this.get(choix-1);

            // Afficher les options de modification possible
            int choix2 = Menu2.afficherMenu("Modifier Contact", "Choisissez ce que vous souhaitez modifier du contact",
                    new String[]{"Nom", "Prenom", "Numero de téléphone", "Email"});

            // Afficher le menu selon le choix
            String response;
            switch (choix2){
                case 1:
                     response = Menu2.afficherMenu("Modifier le nom du contact",
                            "Ancienne valeur : " + contactToModif.getNomCtct() + "\nEntrer le nom à modifier : ",
                             true);
                    contactToModif.setNomCtct(response);
                    break;
                case 2:
                    response = Menu2.afficherMenu("Modifier le prenom du contact",
                            "Ancienne valeur : " + contactToModif.getPrenomCtct() + "\nEntrer le prenom à modifier : ",
                            true);
                    contactToModif.setPrenomCtct(response);
                    break;
                case 3:
                    response = Menu2.afficherMenu("Modifier le numero de téléphone du contact",
                            "Ancienne valeur : " + contactToModif.getNumeroTelCtct() +
                                    "\nEntrer le numero de téléphone à modifier : ", true);
                    contactToModif.setNumeroTelCtct(response);
                    break;
                case 4:
                    response = Menu2.afficherMenu("Modifier le email du contact",
                            "Ancienne valeur : " + contactToModif.getEmailCtct() + "\nEntrer le email à modifier : ",
                                    true);
                    contactToModif.setEmailCtct(response);
                    break;
            }

            // Modifier le contact dans la liste de contact
            this.set(choix-1, contactToModif);
        } else {
            Menu2.afficherMenu("Erreur", "Vous n'avez pas de contact dans votre liste (Enter any to quit)",
                    true);
        }
    }

    public void supprimerContact(){
        String contacts = obtenirListeContact(this);
        if (!contacts.isEmpty()){
            // Affichage du menu de supression
            int choix = Menu2.afficherMenu("Supprimer Contact", "Choisir un contact à supprimer",
                    contacts.split("/"));

            // Supprimer le contact selectionner
            this.remove(choix-1);
        }
    }

    public void rechercherContact() {
        // Obtenir l'élément de recherche de l'utilisateur
        String response = Menu2.afficherMenu("Recherche de contact", "Entrer votre élément de recherche : ",
                true).toLowerCase();

        // Lui retourner les contacts possible selon sont élément de recherche
        ListeContact lc = obtenirListeContact(response);
        String contacts = obtenirListeContact(lc);
        if (!contacts.isEmpty()){
            // Afficher les choix de contact possible pour obtenir leur information
            int choix = Menu2.afficherMenu("Contact selon recherche", "Choisissez un contact pour voir ses informations",
                    contacts.split("/"));
            // Obtenir le contact à afficher
            Contact c = lc.get(choix-1);
            // Afficher les informations de ce contact à l'utilisateur
            Menu2.afficherMenu("Information du contact", "Nom: " + c.getNomCtct() + "\nPrenom: " + c.getPrenomCtct() +
                    "\nNumero de téléphone: " + c.getNumeroTelCtct() + "\nEmail: " + c.getEmailCtct() +
                    "\n(Enter any to exit)", true);

        } else {
            Menu2.afficherMenu("Erreur", "Désolé nous n'avons pas pu trouver de contact commençant par votre élément de " +
                    "recherche..\nEnter any to quit",true);
        }
    }

    public void afficherContact() {
        if (!isEmptyList()){
            Menu2.afficherMenu("Affichage des contacts", "Voici la liste de vos contacts dans votre répertoire : \n" +
                    getCompleteList() + "\n(Enter any to quit)", true);
        }

    }

    // Méthode private
    private String obtenirListeContact(ListeContact lc){
        StringBuilder contacts = new StringBuilder();
        // Vérifier que la liste n'est pas empty
        if (this.size() != 0) {
            // obtenir un string contenant les contact disponible
            for (Contact c : lc) {
                contacts.append(c.getPrenomCtct());
                contacts.append(" ");
                contacts.append(c.getNomCtct());
                contacts.append("/");
            }
        }
        return contacts.toString();
    }

    private ListeContact obtenirListeContact(String searchEntry){
        ListeContact lc = new ListeContact();
        // Vérifier que la liste n'est pas empty
        if (this.size() != 0) {
            // obtenir un string contenant les contact disponible selon le searchEntry
            for (Contact c : this) {
                if (c.getNomCtct().toLowerCase().startsWith(searchEntry) || c.getPrenomCtct().toLowerCase().startsWith(searchEntry)) {
                    lc.add(c);
                }
            }
        }
        return lc;
    }

    private String getCompleteList(){
        StringBuilder sb = new StringBuilder();
        if (this.size() != 0) {
            // obtenir un string contenant toutes les informations de tout les contacts
            for (Contact c : this) {
                sb.append("---------------------------\n");
                sb.append("Prenom: ").append(c.getPrenomCtct()).append("\n");
                sb.append("Nom: ").append(c.getNomCtct()).append("\n");
                sb.append("Numero de téléphone: ").append(c.getNumeroTelCtct()).append("\n");
                sb.append("Email: ").append(c.getEmailCtct()).append("\n");
            }
        }
        return sb.toString();
    }

    private boolean isEmptyList(){
        if (this.isEmpty()){
            Menu2.afficherMenu("Erreur", "Vous n'avez pas de contact dans votre liste (Enter any to quit)",
                    true);
            return true;
        }
        return false;
    }
}
