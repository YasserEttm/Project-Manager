package Metier.POJO;

public class Filiere {
    private String idFil;
    private String nomFil;
    private String idDepartement;

    public Filiere() {
        super();
    }

    public Filiere(String idFil, String nomFil, String idDepartement) {
        this.idFil = idFil;
        this.nomFil = nomFil;
        this.idDepartement = idDepartement;
    }

    public String getIdDepartement() {
        return idDepartement;
    }

    public void setIdDepartement(String idDepartement) {
        this.idDepartement = idDepartement;
    }

    public String getIdFil() {
        return idFil;
    }
    public void setIdFil(String idFil) {
        this.idFil = idFil;
    }
    public String getNomFil() {
        return nomFil;
    }
    public void setNomFil(String nomFil) {
        this.nomFil = nomFil;
    }
}
