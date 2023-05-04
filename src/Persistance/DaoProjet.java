package Persistance;

import Metier.POJO.Professeur;
import Metier.POJO.Projet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoProjet {
    Connection conn;
    public DaoProjet(){
        conn = Connexion.getConnection();
    }
    public ArrayList<Projet> getListeProj() {
        ArrayList<Projet> list = new ArrayList<Projet>();
        ResultSet resultat = null;
        try {
            resultat = this.conn.createStatement().executeQuery("SELECT * FROM projet  ");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while(resultat.next())
            {
                list.add(new Projet( resultat.getString("idProjet"), resultat.getString("titreProj"),
                        resultat.getString("dureeProj"), resultat.getString("dateDbProjet")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Projet getProjById( String code) {
        Projet proj=null ;
        ResultSet resultat = null;
        try {
            resultat = this.conn.createStatement().executeQuery("SELECT * FROM projet where "
                    + "idProjet = "+"'code'");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            proj =new Projet( resultat.getString("idProjet"), resultat.getString("titreProj"),
                    resultat.getString("dureeProj"), resultat.getString("dateDbProjet"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proj;
    }



    public void createProjet( Projet proj1) {
        try {
            int nb=this.conn.createStatement().executeUpdate("INSERT INTO projet (idProjet,titreProj,dureeProj,dateDbProjet) "
                    +"VALUES ("+proj1.getIdProj()+","+proj1.getTitreProj()+","+proj1.getDureeProj()+","+proj1.getDateDbProjet()+")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProjet(Projet proj1) {
        String sql="update projet set titreProj=?,dureeProj=?,dateDbProjet=? where idProj=? ";
        try {
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1, proj1.getTitreProj());
            pst.setString(2, proj1.getDureeProj());
            pst.setString(3, proj1.getDateDbProjet());
            pst.setString(4, proj1.getIdProj());
            pst.execute();

        }catch (Exception exp) {
            System.out.println(exp);
        }
    }

    public void deleteProjet( String code) {
        try {
            int nb=this.conn.createStatement().executeUpdate("delete FROM projet where "
                    + "idProj = '"+code+"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
