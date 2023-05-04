package Persistance;

import Metier.POJO.Professeur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoProfesseur {
    Connection conn;
    public DaoProfesseur(){
        conn = Connexion.getConnection();
    }
    public ArrayList<Professeur> getListeProf() {
        ArrayList<Professeur> list = new ArrayList<Professeur>();
        ResultSet resultat = null;
        try {
            resultat = this.conn.createStatement().executeQuery("SELECT * FROM professeur  ");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while(resultat.next())
            {
                list.add(new Professeur( resultat.getString("idProf"), resultat.getString("nomProf"),
                        resultat.getString("prenomProf"), resultat.getString("emailProf")
                        , resultat.getString("gradeProf"), resultat.getString("idLabo"), resultat.getString("idDepart")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Professeur getProfById( String code) {
        Professeur prof=null ;
        ResultSet resultat = null;
        try {
            resultat = this.conn.createStatement().executeQuery("SELECT * FROM professeur where "
                    + "idProf = "+"'code'");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            prof =new Professeur( resultat.getString("idProf"), resultat.getString("nomProf"),
                    resultat.getString("prenomProf"), resultat.getString("emailProf"),
                    resultat.getString("gradeProf"), resultat.getString("idLabo"), resultat.getString("idDepart"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prof;
    }

    public void createProfesseur( Professeur prof1) {
        try {
            int nb=this.conn.createStatement().executeUpdate("INSERT INTO Professeur (idProf,nomProf,prenomProf,emailProf,gradeProf,idLabo, ipDepart) "
                    +"VALUES ("+prof1.getIdProf()+","+prof1.getNomProf()+","+prof1.getPrenomProf()+","+prof1.getEmailProf()+","+prof1.getGradeProf()+","+prof1.getIdLabo()+","+prof1.getIdDepart()+")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProfesseur(Professeur prof1) {
        String sql="update professeur set nomProf=?,prenomProf=?,emailProf=?,gradeProf=?,idLabo=?,idDepart=? where idProf=? ";
        try {
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1, prof1.getIdProf());
            pst.setString(2, prof1.getNomProf());
            pst.setString(3, prof1.getEmailProf());
            pst.setString(4, prof1.getGradeProf());
            pst.setString(5, prof1.getIdProf());
            pst.setString(6, prof1.getIdLabo());
            pst.setString(7, prof1.getIdDepart());
            pst.execute();

        }catch (Exception exp) {
            System.out.println(exp);
        }
    }

    public void deleteProfesseur( String code) {
        try {
            int nb=this.conn.createStatement().executeUpdate("delete FROM professeur where "
                    + "idProf = '"+code+"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
