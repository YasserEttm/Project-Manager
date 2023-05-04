package Metier.Gestionnaire;

import java.util.ArrayList;
import Metier.POJO.Etudiant;
import Persistance.DaoEtudiant;

public class GestionnaireEtudiant {
	private DaoEtudiant dao;
	private Etudiant etudiant;
	public GestionnaireEtudiant() {
		super();
		this.dao = new DaoEtudiant();
	}
	public ArrayList<Etudiant> getListeEtd2() {
		return dao.getListeEtd();
	}
		
	public Etudiant getEtdById2(String code){

		return dao.getEtdById1(code);
	}
	public void createEtudiant2( Etudiant etd1) {
		dao.createEtudiant(etd1);
	}
	public void updateEtudiant2(Etudiant etd) {
		dao.updateEtudiant(etd);
	}
	public void deleteEtudiant2( String code) {
		dao.deleteEtudiant(code);
	}
		

}
