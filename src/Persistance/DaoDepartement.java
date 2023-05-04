package Persistance;

import Metier.POJO.Departement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoDepartement {
    Connection conn;
    public DaoDepartement(){
        conn = Connexion.getConnection();
    }
    public ArrayList<Departement> getListeDep() {
        ArrayList<Departement> list = new ArrayList<Departement>();
        ResultSet resultat = null;
        try {
            resultat = this.conn.createStatement().executeQuery("SELECT * FROM departement  ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while(resultat.next())
            {
                list.add(new Departement( resultat.getString("idDep"), resultat.getString("nomDep"),
                        resultat.getString("emailDep")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;


    }

    public Departement getDepById( String code) {
        String sql="select * from Departement where idDep=?";

        try {

            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1, code);
            ResultSet rs=pst.executeQuery();
            if(rs.next()) {
                Departement etd=new Departement(rs.getString("idDep"),rs.getString("nomDep"),
                        rs.getString("emailDep"));
                return etd;
            }

        } catch (Exception exp) {
            System.out.println(exp);
        }

        return null;
    }


    public void createDepartement( Departement dep1) {
        try {
            int nb=this.conn.createStatement().executeUpdate("INSERT INTO departement (idDep,nomDep,emailDep) "
                    +"VALUES ('"+dep1.getIdDep()+"','"+dep1.getNomDep()+"','"+dep1.getEmailDep()+"')");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void updateDepartement(Departement dep1) {
        String sql="update departement set nomDep=?,emailDep=? where idDep=? ";
        try {
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1, dep1.getNomDep());
            pst.setString(2, dep1.getEmailDep());
            pst.setString(3, dep1.getIdDep());
            pst.execute();

        }catch (Exception exp) {
            System.out.println(exp);
        }
    }

    public void deleteDepartement( String code) {
        try {
            int nb=this.conn.createStatement().executeUpdate("delete FROM departement where "
                    + "idDep = '"+code+"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
