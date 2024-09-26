public class Contact {
    private String nomCtct;
    private String prenomCtct;
    private String numeroTelCtct;
    private String emailCtct;

    // Getters and Setters
    public String getNomCtct() {
        return nomCtct;
    }

    public void setNomCtct(String nomCtct) {
        this.nomCtct = nomCtct;
    }

    public String getPrenomCtct() {
        return prenomCtct;
    }

    public void setPrenomCtct(String prenomCtct) {
        this.prenomCtct = prenomCtct;
    }

    public String getNumeroTelCtct() {
        return numeroTelCtct;
    }

    public void setNumeroTelCtct(String numeroTelCtct) {
        this.numeroTelCtct = numeroTelCtct;
    }

    public String getEmailCtct() {
        return emailCtct;
    }

    public void setEmailCtct(String emailCtct) {
        this.emailCtct = emailCtct;
    }

    // Construteur
    public Contact(String nom, String prenom, String numeroTel, String email){
        this.nomCtct = nom;
        this.prenomCtct = prenom;
        this.numeroTelCtct = numeroTel;
        this.emailCtct = email;
    }


}
