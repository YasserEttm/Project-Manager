package Persistance;

import Metier.POJO.Entreprise;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoEntreprise {
    Connection conn;
    public DaoEntreprise(){
        conn = Connexion.getConnection();
    }
    public ArrayList<Entreprise> getListeEnt() {
        ArrayList<Entreprise> list = new ArrayList<Entreprise>();
        ResultSet resultat = null;
        try {
            resultat = this.conn.createStatement().executeQuery("SELECT * FROM entreprise  ");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while(resultat.next())
            {
                list.add(new Entreprise( resultat.getString("idEnt"), resultat.getString("adresseEnt"),
                        resultat.getString("teleEnt"), resultat.getString("emailEnt"), resultat.getString("raisonSocial")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Entreprise getEntById( String code) {
        Entreprise ent=null ;
        ResultSet resultat = null;
        try {
            resultat = this.conn.createStatement().executeQuery("SELECT * FROM entreprise where "
                    + "idEnt = "+"'code'");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            ent =new Entreprise( resultat.getString("idEnt"), resultat.getString("adresseEnt"),
                    resultat.getString("teleEnt"), resultat.getString("emailEnt"), resultat.getString("raisonSocial"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ent;
    }

    public void createEntreprise( Entreprise ent1) {
        try {

            int nb=this.conn.createStatement().executeUpdate("INSERT INTO Entreprise (idEnt,adresseEnt,teleEnt,emailEnt,raisonSocial) "
                    +"VALUES ("+ent1.getIdEnt()+","+ent1.getAdresseEnt()+","+ent1.getTeleEnt()+","+ent1.getEmailEnt()+","+ent1.getRaisonSocial()+")");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEntreprise(Entreprise ent1) {
        String sql="update entreprise set adresseEnt=?,teleEnt=?,emailEnt=?,raisonSocial=? where idEnt=? ";
        try {
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1, ent1.getAdresseEnt());
            pst.setString(2, ent1.getTeleEnt());
            pst.setString(3, ent1.getEmailEnt());
            pst.setString(4, ent1.getRaisonSocial());
            pst.setString(5, ent1.getIdEnt());
            pst.execute();

        }catch (Exception exp) {
            System.out.println(exp);
        }
    }

    public void deleteEntreprise( String code) {
        try {
            int nb=this.conn.createStatement().executeUpdate("delete FROM entreprise where "
                    + "idEnt = '"+code+"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
