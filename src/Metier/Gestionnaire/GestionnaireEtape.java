package Metier.Gestionnaire;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Metier.POJO.Etape;
import Persistance.DaoEtape;

public class GestionnaireEtape {
	private DaoEtape dao;
	private Etape etape;
	public GestionnaireEtape() {
		super();
		this.dao = new DaoEtape();
	}
	public ArrayList<Etape> getListeEtape2() {
		return dao.getListeEtape() ;
	
	}

	public Etape getEtapeById2( String code) {
		return dao.getEtapeById(  code);
		}

	public void createEtape2( Etape etape1) {
		dao.createEtape(  etape1);
	   
	}

	public void updateEtape2(Etape etape1) {
		dao.updateEtape( etape1) ;
	}
	
	public void deleteEtape2( String code) {
		dao.deleteEtape( code);
		}
	
}
