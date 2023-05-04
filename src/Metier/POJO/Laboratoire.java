package Metier.POJO;

public class Laboratoire {
    private String idLabo;
    private String nomLabo;
    private String emailLabo;
    public Laboratoire() {
        super();
    }
    public Laboratoire(String idLabo, String nomLabo, String emailLabo) {
        super();
        this.idLabo = idLabo;
        this.nomLabo = nomLabo;
        this.emailLabo = emailLabo;
    }
    public String getIdLabo() {
        return idLabo;
    }
    public void setIdLabo(String idLabo) {
        this.idLabo = idLabo;
    }
    public String getNomLabo() {
        return nomLabo;
    }
    public void setNomLabo(String nomLabo) {
        this.nomLabo = nomLabo;
    }
    public String getEmailLabo() {
        return emailLabo;
    }
    public void setEmailLabo(String emailLabo) {
        this.emailLabo = emailLabo;
    }
}
