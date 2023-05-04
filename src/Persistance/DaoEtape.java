package Persistance;

import Metier.POJO.Etape;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoEtape {
    Connection conn;
    public DaoEtape(){
        conn = Connexion.getConnection();
    }
    public ArrayList<Etape> getListeEtape() {
        ArrayList<Etape> list = new ArrayList<Etape>();
        ResultSet resultat = null;
        try {
            resultat = this.conn.createStatement().executeQuery("SELECT * FROM etape  ");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while(resultat.next())
            {
                list.add(new Etape( resultat.getString("idEtape"), resultat.getString("dureeEtape"),
                        resultat.getString("dateDbEtape"), resultat.getString("livraison"),
                        resultat.getString("documentation")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Etape getEtapeById( String code) {
        Etape etape=null ;
        ResultSet resultat = null;
        try {
            resultat = this.conn.createStatement().executeQuery("SELECT * FROM etape where "
                    + "idEtape = "+"'code'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
//
        try {
            etape =new Etape( resultat.getString("idEtape"), resultat.getString("dureeEtape"),
                    resultat.getString("dateDbEtape"), resultat.getString("livraison"), resultat.getString("documentation"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return etape;
    }


    public void createEtape( Etape etape1) {
        try {
//			private String idEtape;
//			private String dureeEtape;
//			private String dateDbEtape;
//			private String livraison;
//			private String documentation;
            int nb=this.conn.createStatement().executeUpdate("INSERT INTO etape (idEtape,dureeEtape,dateDbEtape,livraison,documentation) "
                    +"VALUES ("+etape1.getIdEtape()+","+etape1.getDureeEtape()+","+etape1.getDateDbEtape()+","+etape1.getLivraison()+","+etape1.getDocumentation()+")");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateEtape(Etape etape1) {
        String sql="update etape set dureeEtape=?,dateDbEtape=?,livraison=?,documentation=? where idEtape=? ";
        try {
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1, etape1.getDureeEtape());
            pst.setString(2, etape1.getDateDbEtape());
            pst.setString(3, etape1.getLivraison());
            pst.setString(4, etape1.getDocumentation());
            pst.setString(5, etape1.getIdEtape());
            pst.execute();

        }catch (Exception exp) {
            System.out.println(exp);
        }
    }

    public void deleteEtape( String code) {
        try {
            int nb=this.conn.createStatement().executeUpdate("delete FROM etape where "
                    + "idEtape = '"+code+"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
