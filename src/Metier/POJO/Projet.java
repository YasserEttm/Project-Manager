package Metier.POJO;

public class Projet {
    private String idProj;
    private String titreProj;
    private String dureeProj;
    private String dateDbProjet;
    public Projet() {
        super();
    }
    public Projet(String idProj, String titreProj, String dureeProj, String dateDbProjet) {
        super();
        this.idProj = idProj;
        this.titreProj = titreProj;
        this.dureeProj = dureeProj;
        this.dateDbProjet = dateDbProjet;
    }
    public String getIdProj() {
        return idProj;
    }
    public void setIdProj(String idProj) {
        this.idProj = idProj;
    }
    public String getTitreProj() {
        return titreProj;
    }
    public void setTitreProj(String titreProj) {
        this.titreProj = titreProj;
    }
    public String getDureeProj() {
        return dureeProj;
    }
    public void setDureeProj(String dureeProj) {
        this.dureeProj = dureeProj;
    }
    public String getDateDbProjet() {
        return dateDbProjet;
    }
    public void setDateDbProjet(String dateDbProjet) {
        this.dateDbProjet = dateDbProjet;
    }
}
