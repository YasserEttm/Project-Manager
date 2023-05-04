package Presentation;

import Metier.Gestionnaire.GestionnaireEtudiant;
import Metier.Gestionnaire.GestionnaireProfesseur;

public class LoginModel {
    private GestionnaireEtudiant guestEtd;
    private GestionnaireProfesseur guestProf;

    LoginModel(){
        guestEtd = new GestionnaireEtudiant();
        guestProf = new GestionnaireProfesseur();
    }

    public GestionnaireEtudiant getGuestEtd() {
        return guestEtd;
    }

    public void setGuestEtd(GestionnaireEtudiant guestEtd) {
        this.guestEtd = guestEtd;
    }

    public GestionnaireProfesseur getGuestProf() {
        return guestProf;
    }

    public void setGuestProf(GestionnaireProfesseur guestProf) {
        this.guestProf = guestProf;
    }
}
