package Metier.Gestionnaire;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Metier.POJO.Filiere;
import Persistance.DaoFiliere;

public class GestionnaireFiliere {
	private DaoFiliere dao;
	private Filiere filiere;
	public GestionnaireFiliere() {
		super();
		this.dao = new DaoFiliere();
	}
	public ArrayList<Filiere> getListeFil2() {
		return dao.getListeFil();
	}
	
	public Filiere getFilById2( String code) {
		return dao.getFilById(code);
		}

	public void createFiliere2( Filiere fil1) {
		dao.createFiliere(  fil1);
	   
	}
	
	public void updateFiliere2(Filiere fil1) {
		dao.updateFiliere( fil1);
	}

	public void deleteFiliere2( String code) {
		dao.deleteFiliere(  code);
	   
		}
	
	
}
