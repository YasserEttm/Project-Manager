package Persistance;

import Metier.POJO.Laboratoire;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoLaboratoire {
    Connection conn;
    public DaoLaboratoire(){
        conn = Connexion.getConnection();
    }
    public ArrayList<Laboratoire> getListeLabo() {
        ArrayList<Laboratoire> list = new ArrayList<Laboratoire>();
        ResultSet resultat = null;
        try {
            resultat = this.conn.createStatement().executeQuery("SELECT * FROM laboratoire  ");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while(resultat.next())
            {
                list.add(new Laboratoire( resultat.getString("idLabo"), resultat.getString("nomLabo"),
                        resultat.getString("emailLabo")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Laboratoire getlaboById( String code) {
        Laboratoire labo=null ;
        ResultSet resultat = null;
        try {
            resultat = this.conn.createStatement().executeQuery("SELECT * FROM laboratoire where "
                    + "idLabo = "+"'code'");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            labo =new Laboratoire( resultat.getString("idLabo"), resultat.getString("nomLabo"),
                    resultat.getString("emailLabo"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return labo;
    }


    public void createLaboratoire( Laboratoire labo1) {
        try {

            int nb=this.conn.createStatement().executeUpdate("INSERT INTO laboratoire (idLabo,nomLabo,emailLabo) "
                    +"VALUES ("+labo1.getIdLabo()+","+labo1.getNomLabo()+","+labo1.getEmailLabo()+")");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateLaboratoire(Laboratoire labo1) {
        String sql="update laboratoire set nomLabo=?,emailLabo=? where idLabo=? ";
        try {
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1, labo1.getNomLabo());
            pst.setString(2, labo1.getEmailLabo());
            pst.setString(3, labo1.getIdLabo());
            pst.execute();

        }catch (Exception exp) {
            System.out.println(exp);
        }
    }

    public void deleteLaboratoire( String code) {
        try {
            int nb=this.conn.createStatement().executeUpdate("delete FROM laboratoire where "
                    + "idLabo = '"+code+"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
