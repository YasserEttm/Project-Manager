package Persistance;

import Metier.POJO.Filiere;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoFiliere {
    Connection conn;
    public DaoFiliere(){
        conn = Connexion.getConnection();
    }
    public ArrayList<Filiere> getListeFil() {
        ArrayList<Filiere> list = new ArrayList<Filiere>();
        ResultSet resultat = null;
        try {
            resultat = this.conn.createStatement().executeQuery("SELECT * FROM filiere  ");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while(resultat.next())
            {
                list.add(new Filiere( resultat.getString("idFil"), resultat.getString("nomFil"), resultat.getString("idDepartement")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Filiere getFilById( String code) {
        Filiere fil=null ;
        ResultSet resultat = null;
        try {
            resultat = this.conn.createStatement().executeQuery("SELECT * FROM filiere where "
                    + "idFil = "+"'code'");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            fil =new Filiere( resultat.getString("idFil"), resultat.getString("nomFil"), resultat.getString("idDepartement"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fil;
    }


    public void createFiliere( Filiere fil1) {
        try {

            int nb=this.conn.createStatement().executeUpdate("INSERT INTO filiere (idFil,nomFil) "
                    +"VALUES ("+fil1.getIdFil()+","+fil1.getNomFil()+","+fil1.getIdDepartement()+")");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateFiliere(Filiere fil1) {
        String sql="update filiere set nomFil=?,idDepartement=? where idFil=? ";
        try {
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1, fil1.getNomFil());
            pst.setString(2, fil1.getIdDepartement());
            pst.setString(3, fil1.getIdFil());
            pst.execute();

        }catch (Exception exp) {
            System.out.println(exp);
        }
    }

    public void deleteFiliere( String code) {
        try {
            int nb=this.conn.createStatement().executeUpdate("delete FROM filiere where "
                    + "idFil = '"+code+"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
