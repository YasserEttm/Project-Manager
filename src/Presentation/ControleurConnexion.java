package Presentation;

import Metier.Gestionnaire.*;
import Metier.POJO.Etudiant;
import Metier.POJO.Professeur;
import Metier.POJO.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;

public class ControleurConnexion {

    public ControleurConnexion() {
        super();
    }

    public void start(){
        Login log = new Login(this);
    }

    // LOGIN ACCESS
    public boolean loginAccess(String username, String password) {
        LoginModel user = new LoginModel();

        int i = 0;
        for (i = 0 ; i < user.getGuestEtd().getListeEtd2().size() ; i++){
            if(Objects.equals(username, user.getGuestEtd().getListeEtd2().get(i).getEmailEtd())){
                break;
            }
        }
        if (user.getGuestEtd().getListeEtd2().size() != i){
            JOptionPane.showMessageDialog(null, "Welcome Back \n"+
                    user.getGuestEtd().getListeEtd2().get(i).getNomEtd() + " " +
                    user.getGuestEtd().getListeEtd2().get(i).getPrenomEtd());
            Etudiant etudiant = new Etudiant(user.getGuestEtd().getListeEtd2().get(i).getIdEtd(),
                    user.getGuestEtd().getListeEtd2().get(i).getNomEtd(), user.getGuestEtd().getListeEtd2().get(i).getPrenomEtd(),
                    user.getGuestEtd().getListeEtd2().get(i).getEmailEtd(), user.getGuestEtd().getListeEtd2().get(i).getNiveauEtd(),
                    user.getGuestEtd().getListeEtd2().get(i).getIdFiliere(), user.getGuestEtd().getListeEtd2().get(i).getIdProjet(),
                    user.getGuestEtd().getListeEtd2().get(i).getIdEntreprise());

            Home home = new Home(etudiant,this);
            return true;
        }

        for (i = 0 ; i < user.getGuestProf().getListeProf2().size() ; i++){
            if(Objects.equals(username, user.getGuestProf().getListeProf2().get(i).getEmailProf())){
                break;
            }
        }
        if (user.getGuestProf().getListeProf2().size() != i){
            JOptionPane.showMessageDialog(null, "Welcome Back Mr\n"+
                    user.getGuestProf().getListeProf2().get(i).getNomProf() + " " +
                    user.getGuestProf().getListeProf2().get(i).getPrenomProf());
            Professeur professeur = new Professeur(user.getGuestProf().getListeProf2().get(i).getIdProf(),
                    user.getGuestProf().getListeProf2().get(i).getNomProf(), user.getGuestProf().getListeProf2().get(i).getPrenomProf(),
                    user.getGuestProf().getListeProf2().get(i).getEmailProf(), user.getGuestProf().getListeProf2().get(i).getGradeProf(),
                    user.getGuestProf().getListeProf2().get(i).getIdLabo(), user.getGuestProf().getListeProf2().get(i).getIdDepart());

            Home home = new Home(professeur,this);
            return true;
        }

        JOptionPane.showMessageDialog(null, "User not found");
        return false;
    }

    public ArrayList<Etudiant> getListeEtd(){
        GestionnaireEtudiant getterEtd = new GestionnaireEtudiant();
        return getterEtd.getListeEtd2();
    }

    public void createEtd(Etudiant etd){
        GestionnaireEtudiant guestEtd = new GestionnaireEtudiant();
        guestEtd.createEtudiant2(etd);
    }

    public void deleteEtd(String code){
        GestionnaireEtudiant guestEtd = new GestionnaireEtudiant();
        guestEtd.deleteEtudiant2(code);
    }

    public void updateEtd(Etudiant etd){
        GestionnaireEtudiant guestEtd = new GestionnaireEtudiant();
        guestEtd.updateEtudiant2(etd);
    }

    public ArrayList<Projet> getListeProj(){
        GestionnaireProjet guestProj = new GestionnaireProjet();
        return guestProj.getListeProj2();
    }

    public Projet getProjById(String code){
        GestionnaireProjet guestProj = new GestionnaireProjet();
        return guestProj.getProjById2(code);
    }



}
