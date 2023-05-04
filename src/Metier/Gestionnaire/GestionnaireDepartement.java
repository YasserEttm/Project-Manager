package Metier.Gestionnaire;

import java.util.ArrayList;
import Metier.POJO.Departement;
import Persistance.DaoDepartement;

public class GestionnaireDepartement {
	private DaoDepartement dao;
	private Departement departement;
	public GestionnaireDepartement() {
		super();
		this.dao = new DaoDepartement();
	}
	
	public ArrayList<Departement> getListeDep2(){
		return dao.getListeDep();
	}
	
	public Departement getDepById2(String code){
		return dao.getDepById(code);
	}
	
	public void creatDepartement2( Departement dep1) {
		dao.createDepartement(dep1);
	}
	
	public void updateDepartement2(Departement dep1) {
		dao.updateDepartement( dep1);
	}
	public void deleteDepartement2( String code) {
		dao.deleteDepartement(  code);
	}

}
