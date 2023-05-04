package Metier.POJO;

public class Etudiant {
    private String idEtd;
    private String nomEtd;
    private String prenomEtd;
    private String emailEtd;
    private String niveauEtd;
    private String idFiliere;
    private String idProjet;
    private String idEntreprise;

    public Etudiant(){
        super();
    }

    public Etudiant(String idEtd, String nomEtd, String prenomEtd, String emailEtd, String niveauEtd, String idFiliere, String idProjet, String idEntreprise) {
        this.idEtd = idEtd;
        this.nomEtd = nomEtd;
        this.prenomEtd = prenomEtd;
        this.emailEtd = emailEtd;
        this.niveauEtd = niveauEtd;
        this.idFiliere = idFiliere;
        this.idProjet = idProjet;
        this.idEntreprise = idEntreprise;
    }

    public String getIdEtd() {
        return idEtd;
    }

    public String getNomEtd() {
        return nomEtd;
    }

    public String getPrenomEtd() {
        return prenomEtd;
    }

    public String getEmailEtd() {
        return emailEtd;
    }

    public String getNiveauEtd() {
        return niveauEtd;
    }

    public String getIdFiliere() {
        return idFiliere;
    }

    public String getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(String idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public String getIdProjet() {
        return idProjet;
    }

    public void setIdFiliere(String idFiliere) {
        this.idFiliere = idFiliere;
    }

    public void setIdProjet(String idProjet) {
        this.idProjet = idProjet;
    }

    public void setIdEtd(String idEtd) {
        this.idEtd = idEtd;
    }

    public void setNomEtd(String nomEtd) {
        this.nomEtd = nomEtd;
    }

    public void setPrenomEtd(String prenomEtd) {
        this.prenomEtd = prenomEtd;
    }

    public void setEmailEtd(String emailEtd) {
        this.emailEtd = emailEtd;
    }

    public void setNiveauEtd(String niveauEtd) {
        this.niveauEtd = niveauEtd;
    }
}
