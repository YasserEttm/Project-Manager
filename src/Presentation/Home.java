package Presentation;

import Metier.POJO.Etudiant;
import Metier.POJO.Professeur;
import Metier.POJO.Projet;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Home extends JFrame implements ActionListener {
    private JFrame window;
    private JLabel userName;
    private JLabel userGrade;
    private JLabel labelTable;
    private JLabel labelTable2;
    private JLabel encaLabel;
    private JLabel projLabel;
    //input new etd
    private JTextField etdId;
    private JTextField etdNom;
    private JTextField etdPrenom;
    private JTextField etdEmail;
    private JTextField etdGrade;
    private JTextField etdFiliere;
    private JTextField etdProjet;
    private JTextField etdEntreprise;


    // labels input new etd
    private JLabel cneEtd;
    private JLabel nomEtd;
    private JLabel prenomEtd;
    private JLabel emailEtd;
    private JLabel gradeEtd;
    private JLabel idFiliere;
    private JLabel idProjet;
    private JLabel idEntreprise;




    private JButton addEtd;
    private JButton delEtd;
    private JButton updEtd;
    private JButton refreshEtd;


    private ControleurConnexion controleur;
    private Container container;


    public Home(ControleurConnexion controleur) {
        this.controleur = controleur;
        this.initialize();
        this.locationAndSize();
        this.addToContainer();
        this.addAction();
    }

    public Home(Professeur prof, ControleurConnexion controleur) {
        this.initialize();
        this.profComponents();
        this.locationProf();
        this.locationAndSize();
        this.addToContainer();
        this.addAction();
        this.controleur = controleur;
        createUIProfesseur(prof);

    }

    public Home(Etudiant etd, ControleurConnexion controleur) {
        this.initialize();
        this.etudComponents();
        this.locationEtud();
        this.locationAndSize();
        this.addToContainer();
        //this.addAction();
        this.controleur = controleur;
        createUIEtudiant(etd);


    }


    private void initialize() {
        window = new JFrame("HOME");
        userName = new JLabel();
        userGrade = new JLabel();
        window.setSize(1440, 1024);
        container = getContentPane();
        container.setLayout(null);
        window.add(container);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    private void etudComponents(){
        encaLabel = new JLabel();
        container.add(encaLabel);
        projLabel = new JLabel();
        container.add(projLabel);
    }

    private void locationEtud(){
        encaLabel.setBounds(20, 120, 400, 30);
        encaLabel.setFont(new Font("Montserrat", Font.ITALIC, 15));
        projLabel.setBounds(20, 220, 400, 30);
        projLabel.setFont(new Font("Montserrat", Font.ITALIC, 15));
    }


    private void profComponents(){
        labelTable = new JLabel("Liste Des Etudiants:");
        labelTable2 = new JLabel("Liste Des Projets:");
        etdEmail =new JTextField();
        etdEmail.hide();
        etdId =new JTextField();
        etdId.hide();
        etdNom =new JTextField();
        etdNom.hide();
        etdPrenom =new JTextField();
        etdPrenom.hide();
        etdGrade = new JTextField();
        etdGrade.hide();
        etdFiliere = new JTextField();
        etdFiliere.hide();
        etdProjet = new JTextField();
        etdProjet.hide();
        etdEntreprise = new JTextField();
        etdEntreprise.hide();
        cneEtd = new JLabel("CNE");
        cneEtd.hide();
        nomEtd = new JLabel("NOM");
        nomEtd.hide();
        prenomEtd = new JLabel("PRENOM");
        prenomEtd.hide();
        emailEtd = new JLabel("EMAIL");
        emailEtd.hide();
        gradeEtd = new JLabel("NIVEAU");
        gradeEtd.hide();
        idEntreprise = new JLabel("ENTREPRISE");
        idEntreprise.hide();
        idProjet = new JLabel("PROJET");
        idProjet.hide();
        idFiliere = new JLabel("FILIERE");
        idFiliere.hide();

        addEtd = new JButton("Ajouter");
        updEtd = new JButton("Modifier");
        delEtd = new JButton("Supprimer");
        refreshEtd = new JButton("Actualiser");
        container.add(labelTable);
        container.add(labelTable2);
        container.add(addEtd);
        container.add(delEtd);
        container.add(updEtd);
        container.add(refreshEtd);
        container.add(etdEmail);
        container.add(etdGrade);
        container.add(etdPrenom);
        container.add(etdNom);
        container.add(etdId);
        container.add(cneEtd);
        container.add(nomEtd);
        container.add(prenomEtd);
        container.add(emailEtd);
        container.add(gradeEtd);

        container.add(idFiliere);
        container.add(idProjet);
        container.add(idEntreprise);
        container.add(etdFiliere);
        container.add(etdProjet);
        container.add(etdEntreprise);
    }

    private void locationProf(){
        labelTable.setBounds(900, 70, 250, 30);
        labelTable.setFont(new Font("Montserrat", Font.ITALIC, 15));
        labelTable2.setBounds(900, 470, 250, 30);
        labelTable2.setFont(new Font("Montserrat", Font.ITALIC, 15));

        addEtd.setBounds(20, 400, 100, 30);
        delEtd.setBounds(120, 400, 100, 30);
        updEtd.setBounds(220, 400, 100, 30);
        refreshEtd.setBounds(320, 400, 100, 30);

        etdId.setBounds(20, 100, 180, 40);
        etdId.setFont(etdId.getFont().deriveFont(Font.PLAIN, 20));
        etdNom.setBounds(220, 100, 180, 40);
        etdNom.setFont(etdNom.getFont().deriveFont(Font.PLAIN, 20));
        etdPrenom.setBounds(420, 100, 180, 40);
        etdPrenom.setFont(etdPrenom.getFont().deriveFont(Font.PLAIN, 20));
        etdEmail.setBounds(620, 100, 180, 40);
        etdEmail.setFont(etdEmail.getFont().deriveFont(Font.PLAIN, 20));
        etdGrade.setBounds(20, 200, 180, 40);
        etdGrade.setFont(etdGrade.getFont().deriveFont(Font.PLAIN, 20));
        etdFiliere.setBounds(220, 200, 180, 40);
        etdFiliere.setFont(etdGrade.getFont().deriveFont(Font.PLAIN, 20));
        etdProjet.setBounds(20, 300, 180, 40);
        etdProjet.setFont(etdGrade.getFont().deriveFont(Font.PLAIN, 20));
        etdEntreprise.setBounds(220, 300, 180, 40);
        etdEntreprise.setFont(etdGrade.getFont().deriveFont(Font.PLAIN, 20));

        cneEtd.setBounds(20, 80, 200, 30);
        nomEtd.setBounds(220, 80, 200, 30);
        prenomEtd.setBounds(420, 80, 200, 30);
        emailEtd.setBounds(620, 80, 200, 30);
        gradeEtd.setBounds(20, 180, 200, 30);
        idFiliere.setBounds(220, 180, 200, 30);
        idProjet.setBounds(20, 280,200, 30);
        idEntreprise.setBounds(220, 280, 200, 30);
    }

    private void locationAndSize() {
        userName.setBounds(20, 30, 250, 30); // hafidiimad@gmail.com
        userName.setFont(new Font("Montserrat", Font.BOLD, 18));

        userGrade.setBounds(20, 50, 250, 30);
        userGrade.setFont(new Font("Montserrat", Font.ITALIC, 13));

    }

    private void addToContainer() {
        container.add(userName);
        container.add(userGrade);

    }

    private void addAction(){
        addEtd.addActionListener(this);
        delEtd.addActionListener(this);
        updEtd.addActionListener(this);
        refreshEtd.addActionListener(this);
    }

    private void createUIEtudiant(Etudiant etd) {
        userName.setText(etd.getNomEtd() + " " + etd.getPrenomEtd());
        userGrade.setText(etd.getNiveauEtd());
        encaLabel.setText("Votre Professeur encaderent est HAFIDI IMAD");
        Projet projet = controleur.getProjById(etd.getIdProjet());
        projLabel.setText("Votre Projet Actuel est " + projet.getTitreProj());
    }

    private void createUIProfesseur(Professeur prof) {
        userName.setText("Monsieur " + prof.getNomProf() + " " + prof.getPrenomProf());
        userGrade.setText(prof.getGradeProf());
        createTable();
        createTable2();
    }



    private void createTable(){
        ArrayList<Etudiant> listEtd = controleur.getListeEtd();
        int size = listEtd.size();
        Object Data[][]=new Object[size][8];
        for(int i=0;i<size;i++) {
            Data[i][0]=listEtd.get(i).getIdEtd();
            Data[i][1]=listEtd.get(i).getNomEtd();
            Data[i][2]=listEtd.get(i).getPrenomEtd();
            Data[i][3]=listEtd.get(i).getEmailEtd();
            Data[i][4]=listEtd.get(i).getNiveauEtd();
            Data[i][5]=listEtd.get(i).getIdFiliere();
            Data[i][6]=listEtd.get(i).getIdProjet();
            Data[i][7]=listEtd.get(i).getIdEntreprise();
        }
        String titles[]= {"ID","Nom","Prenom","Email","Niveau","Filiere", "Projet", "Entreprise"};
        JPanel panel = new JPanel();
        JTable table = new JTable(Data,titles);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(900, 100, 500, 275);
        container.add(scrollPane);
        scrollPane.setViewportView(table);
    }

    private void createTable2(){
        ArrayList<Projet> listProj = controleur.getListeProj();
        int size = listProj.size();
        Object Data[][]=new Object[size][4];
        for(int i=0;i<size;i++) {
            Data[i][0]=listProj.get(i).getIdProj();
            Data[i][1]=listProj.get(i).getTitreProj();
            Data[i][2]=listProj.get(i).getDureeProj();
            Data[i][3]=listProj.get(i).getDateDbProjet();
        }
        String titles[]= {"ID","Titre","Duree","Debut"};
        JPanel panel = new JPanel();
        JTable table = new JTable(Data,titles);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(900, 500, 500, 275);
        container.add(scrollPane);
        scrollPane.setViewportView(table);
    }

    private void showComponents(boolean b){
        etdId.show(b);
        etdNom.show(b);
        etdPrenom.show(b);
        etdEmail.show(b);
        etdGrade.show(b);
        etdFiliere.show(b);
        etdProjet.show(b);
        etdEntreprise.show(b);
        cneEtd.show(b);
        nomEtd.show(b);
        prenomEtd.show(b);
        emailEtd.show(b);
        gradeEtd.show(b);
        idEntreprise.show(b);
        idProjet.show(b);
        idFiliere.show(b);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ((e.getSource() == addEtd) && e.getActionCommand().equals("Ajouter")){
            addEtd.setText("Comfirmer ?");
            showComponents(true);
        }
        if ((e.getSource() == addEtd) && e.getActionCommand().equals("Comfirmer ?")){
            addEtd.setText("Ajouter");
            showComponents(false);
            Etudiant etd = new Etudiant(etdId.getText(), etdNom.getText(), etdPrenom.getText(), etdEmail.getText(), etdGrade.getText(),
                    etdFiliere.getText(), etdProjet.getText(), etdEntreprise.getText());
            controleur.createEtd(etd);
        }

        if((e.getSource() == delEtd) && e.getActionCommand().equals("Supprimer")){
            delEtd.setText("Comfirmer ?");
            etdId.show();
        }

        if((e.getSource() == delEtd) && e.getActionCommand().equals("Comfirmer ?")){
            delEtd.setText("Supprimer");
            controleur.deleteEtd(etdId.getText());
            etdId.hide();
        }

        if((e.getSource() == updEtd) ){
            updEtd.setText("Comfirmer ?");
            showComponents(true);
        }

        if((e.getSource() == updEtd) && e.getActionCommand().equals("Comfirmer ?")){
            updEtd.setText("Modifier");
            showComponents(false);
            Etudiant etd = new Etudiant(etdId.getText(), etdNom.getText(), etdPrenom.getText(), etdEmail.getText(), etdGrade.getText(),
                    etdFiliere.getText(), etdProjet.getText(), etdEntreprise.getText());
            controleur.updateEtd(etd);
        }

        if((e.getSource() == refreshEtd)){
            showComponents(false);
            createTable();
        }
    }
}
