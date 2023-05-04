package Persistance;

import Metier.POJO.Etudiant;
import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) {
        DaoEtudiant ins = new DaoEtudiant();
//        Etudiant etd = new Etudiant("5", "BOUANANE", "Doha", "bouananedoha@gmail.com", "GI1");
//        ins.createEtudiant(etd);
//        ins.deleteEtudiant("4");
        ArrayList<Etudiant> list = ins.getListeEtd();

          for(int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).getNomEtd());
          }

    }
}
