package Persistance;

import Metier.POJO.Etudiant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoEtudiant {
    Connection conn;
    public DaoEtudiant(){
        conn = Connexion.getConnection();
    }
    public ArrayList<Etudiant> getListeEtd() {
        ArrayList<Etudiant> list = new ArrayList<Etudiant>();
        ResultSet resultat = null;
        try {
            resultat = this.conn.createStatement().executeQuery("SELECT * FROM etudiant  ");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while(resultat.next())
            {
                list.add(new Etudiant( resultat.getString("idEtd"), resultat.getString("nomEtd"),
                        resultat.getString("prenomEtd"), resultat.getString("emailEtd"),
                        resultat.getString("niveauEtd"), resultat.getString("idFiliere"),
                        resultat.getString("idProjet"), resultat.getString("idEntreprise")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    public Etudiant getEtdById1( String code) {
        String sql="select * from etudiant where idEtd=?";

        try {

            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1, code);
            ResultSet rs=pst.executeQuery();
            if(rs.next()) {
                Etudiant etd=new Etudiant(rs.getString("idEtd"),rs.getString("nomEtd"),
                        rs.getString("prenomEtd"),rs.getString("emailEtd"),
                        rs.getString("niveauEtd"), rs.getString("idFiliere"), rs.getString("idProjet"),
                        rs.getString("idEntreprise"));
                return etd;
            }

        } catch (Exception exp) {
            System.out.println(exp);
        }
        return null;
    }

    public void createEtudiant( Etudiant etd1) {

        try {
            int nb=this.conn.createStatement().executeUpdate("INSERT INTO etudiant (idEtd,nomEtd,prenomEtd,emailEtd,niveauEtd,idFiliere,idProjet,idEntreprise) "
                    +"VALUES ('"+etd1.getIdEtd()+"','"+etd1.getNomEtd()+"','"+etd1.getPrenomEtd()+"','"+etd1.getEmailEtd()+"','"+etd1.getNiveauEtd()+"','"+etd1.getIdFiliere()+"','"+etd1.getIdProjet()+"','"+etd1.getIdEntreprise()+"')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEtudiant(Etudiant etd) {
        String sql="update etudiant set nomEtd=?,prenomEtd=?,emailEtd=?,niveauEtd=?,idFiliere=?,idProjet=?,idEntreprise=? where IdEtd=? ";
        try {
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1, etd.getNomEtd());
            pst.setString(2, etd.getPrenomEtd());
            pst.setString(3, etd.getEmailEtd());
            pst.setString(4, etd.getNiveauEtd());
            pst.setString(5, etd.getIdEtd());
            pst.setString(6, etd.getIdFiliere());
            pst.setString(7, etd.getIdProjet());
            pst.setString(8, etd.getIdEntreprise());
            pst.execute();

        }catch (Exception exp) {
            System.out.println(exp);
        }
    }


    public void deleteEtudiant( String code) {
        try {
            int nb=this.conn.createStatement().executeUpdate("delete FROM etudiant where "
                    + "idEtd = '"+code+"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
