package Metier.POJO;

public class Entreprise {
    private String idEnt;
    private String adresseEnt;
    private String teleEnt;
    private String emailEnt;
    private String raisonSocial;
    public Entreprise() {
        super();
    }
    public Entreprise(String idEnt, String adresseEnt, String teleEnt, String emailEnt, String raisonSocial) {
        super();
        this.idEnt = idEnt;
        this.adresseEnt = adresseEnt;
        this.teleEnt = teleEnt;
        this.emailEnt = emailEnt;
        this.raisonSocial = raisonSocial;
    }
    public String getIdEnt() {
        return idEnt;
    }
    public void setIdEnt(String idEnt) {
        this.idEnt = idEnt;
    }
    public String getAdresseEnt() {
        return adresseEnt;
    }
    public void setAdresseEnt(String adresseEnt) {
        this.adresseEnt = adresseEnt;
    }
    public String getTeleEnt() {
        return teleEnt;
    }
    public void setTeleEnt(String teleEnt) {
        this.teleEnt = teleEnt;
    }
    public String getEmailEnt() {
        return emailEnt;
    }
    public void setEmailEnt(String emailEnt) {
        this.emailEnt = emailEnt;
    }
    public String getRaisonSocial() {
        return raisonSocial;
    }
    public void setRaisonSocial(String raisonSocial) {
        this.raisonSocial = raisonSocial;
    }
}
