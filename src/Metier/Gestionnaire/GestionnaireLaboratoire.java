package Metier.Gestionnaire;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Metier.POJO.Laboratoire;
import Persistance.DaoLaboratoire;

public class GestionnaireLaboratoire {
	private DaoLaboratoire dao;
	private Laboratoire laboratoire;
	public GestionnaireLaboratoire() {
		super();
		this.dao = new DaoLaboratoire();
	}
	public ArrayList<Laboratoire> getListeLabo2() {
		return dao.getListeLabo();
	}

	public Laboratoire getlaboById2( String code) {
		return dao.getlaboById( code);
		}

	public void createLaboratoire2( Laboratoire labo1) {
		dao.createLaboratoire(labo1);
	}

	public void updateLaboratoire2(Laboratoire labo1) {
		dao.updateLaboratoire( labo1);
	}

	public void deleteLaboratoire2( String code) {
		dao.deleteLaboratoire( code);
	   
	}


}
