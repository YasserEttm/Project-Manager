package Metier.Gestionnaire;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Metier.POJO.Professeur;
import Persistance.DaoProfesseur;

public class GestionnaireProfesseur {
		private DaoProfesseur dao;
		private Professeur professeur;
		public GestionnaireProfesseur() {
			super();
			this.dao = new DaoProfesseur();
		}
		
		public ArrayList<Professeur> getListeProf2() {
			return dao.getListeProf() ;
	    }
		
		public Professeur getProfById2( String code) {
			return dao.getProfById(  code);
		}

		public void createProfesseur2( Professeur prof1) {
			dao.createProfesseur( prof1);
		   
		}

		public void updateProfesseur2(Professeur prof1) {
			dao.updateProfesseur( prof1);
		}


		public void deleteProfesseur2( String code) {
			dao.deleteProfesseur(  code);
		   
		}
		
	

}
