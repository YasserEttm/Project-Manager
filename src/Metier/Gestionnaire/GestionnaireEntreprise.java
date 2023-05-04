package Metier.Gestionnaire;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import Metier.POJO.Entreprise;
import Persistance.DaoEntreprise;

public class GestionnaireEntreprise {
	private DaoEntreprise dao;
	private Entreprise entreprise;
	public GestionnaireEntreprise() {
		super();
		this.dao = new DaoEntreprise();
	}
	
	public ArrayList<Entreprise> getListeEnt2(){
		return dao.getListeEnt();
	}
	
	public Entreprise getEntById2( String code) {
		return dao.getEntById(code);
	}
	
	public void createEntreprise2( Entreprise ent1) {
		dao.createEntreprise(ent1);
	}
	
	public void updateEntreprise2(Entreprise ent1) {
		dao.updateEntreprise( ent1);
	}

	public void deleteEntreprise2( String code) {
		dao.deleteEntreprise(code);
	   
		}


}
