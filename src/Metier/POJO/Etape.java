package Metier.POJO;

public class Etape {
    private String idEtape;
    private String dureeEtape;
    private String dateDbEtape;
    private String livraison;
    private String documentation;
    public Etape() {
        super();
    }
    public Etape(String idEtape, String dureeEtape, String dateDbEtape, String livraison, String documentation) {
        super();
        this.idEtape = idEtape;
        this.dureeEtape = dureeEtape;
        this.dateDbEtape = dateDbEtape;
        this.livraison = livraison;
        this.documentation = documentation;
    }
    public String getIdEtape() {
        return idEtape;
    }
    public void setIdEtape(String idEtape) {
        this.idEtape = idEtape;
    }
    public String getDureeEtape() {
        return dureeEtape;
    }
    public void setDureeEtape(String dureeEtape) {
        this.dureeEtape = dureeEtape;
    }
    public String getDateDbEtape() {
        return dateDbEtape;
    }
    public void setDateDbEtape(String dateDbEtape) {
        this.dateDbEtape = dateDbEtape;
    }
    public String getLivraison() {
        return livraison;
    }
    public void setLivraison(String livraison) {
        this.livraison = livraison;
    }
    public String getDocumentation() {
        return documentation;
    }
    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }
}
