package Metier.Gestionnaire;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Metier.POJO.Projet;
import Persistance.DaoProjet;

public class GestionnaireProjet {
	private DaoProjet dao;
	private Projet projet;
	public GestionnaireProjet() {
		super();
		this.dao = new DaoProjet();
	}
	
	public ArrayList<Projet> getListeProj2() {
	return dao.getListeProj();
	}

	public Projet getProjById2( String code) {
		return dao.getProjById(  code);
		}
	
	public void createProjet2( Projet proj1) {
		dao.createProjet(  proj1);
	   
	}

	public void updateProjet2(Projet proj1) {
		dao.updateProjet( proj1);
	}

	public void deleteProjet2( String code) {
		dao.deleteProjet( code);
	   
		}
	

}
