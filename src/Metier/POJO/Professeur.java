package Metier.POJO;

public class Professeur {
    private String idProf;
    private String nomProf;
    private String prenomProf;
    private String emailProf;
    private String gradeProf;
    private String idLabo;
    private String idDepart;

    public Professeur() {
        super();
    }

    public Professeur(String idProf, String nomProf, String prenomProf, String emailProf, String gradeProf, String idLabo, String idDepart) {
        this.idProf = idProf;
        this.nomProf = nomProf;
        this.prenomProf = prenomProf;
        this.emailProf = emailProf;
        this.gradeProf = gradeProf;
        this.idLabo = idLabo;
        this.idDepart = idDepart;
    }

    public String getIdLabo() {
        return idLabo;
    }

    public void setIdLabo(String idLabo) {
        this.idLabo = idLabo;
    }

    public String getIdDepart() {
        return idDepart;
    }

    public void setIdDepart(String idDepart) {
        this.idDepart = idDepart;
    }

    public String getIdProf() {
        return idProf;
    }
    public void setIdProf(String idProf) {
        this.idProf = idProf;
    }
    public String getNomProf() {
        return nomProf;
    }
    public void setNomProf(String nomProf) {
        this.nomProf = nomProf;
    }
    public String getPrenomProf() {
        return prenomProf;
    }
    public void setPrenomProf(String prenomProf) {
        this.prenomProf = prenomProf;
    }
    public String getEmailProf() {
        return emailProf;
    }
    public void setEmailProf(String emailProf) {
        this.emailProf = emailProf;
    }
    public String getGradeProf() {
        return gradeProf;
    }
    public void setGradeProf(String gradeProf) {
        this.gradeProf = gradeProf;
    }

}
