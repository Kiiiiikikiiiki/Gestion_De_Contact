import java.util.*;

public class GestionContact {

    public static void main(String[] args) {
        // Initialisation de la liste de contact
        ListeContact lc = new ListeContact(
                new Contact("Cadieux", "Jean-Noel", "438-356-4724", "jeannoelcadieuxpro@gmail.com"),
                new Contact("Berrio", "Alejandro", "450-236-7667", "alejandroberriopro@gmail.com")
        );

        // Avec constructeur par default.
        ListeContact lc2 = new ListeContact(){
            {
                add(new Contact("Test", "Test", "test", "test@test"));
            }
        };

        // Program
        while (true){
            int choix = Menu2.afficherMenu("Menu Principal", "Carnet De Contact",
                    new String[]{
                            "Ajouter un contact",
                            "Modifier un contact",
                            "Supprimer un contact",
                            "Rechercher un contact",
                            "Afficher les contact",
                            "Quitter l'application"
                    });

            // Gestion du choix fait par le user
            switch (choix){
                case 1:
                    lc.ajouterContact(); break;
                case 2:
                    lc.modifierContact(); break;
                case 3:
                    lc.supprimerContact(); break;
                case 4:
                    lc.rechercherContact(); break;
                case 5:
                    lc.afficherContact(); break;
                default:
                    return;
            }
        }
    }
}
