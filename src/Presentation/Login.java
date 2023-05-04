package Presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Login extends JFrame  implements ActionListener{
    private JFrame window;
    private JLabel userName;
    private JLabel userPassword;
    private JTextField inputName;
    private JPasswordField inputPassword;
    private JButton loginButton;
    private JCheckBox showPassword;
    private Container container;
    private ControleurConnexion controleur;


    public Login(ControleurConnexion controleur){
        this.controleur = controleur;
        this.initialize();
        this.setLocationAndSize();
        this.addToContainer();
        this.addAction();

    }

    private void initialize(){
        //Initializing the fields
        window = new JFrame("PROJECT MANAGER");
        window.setSize(1440,1024);
        userName = new JLabel("USERNAME");
        userName.setFont(new Font("Montserrat", Font.BOLD, 30));
        userPassword = new JLabel("PASSWORD");
        userPassword.setFont(new Font("Montserrat", Font.BOLD, 30));
        inputName = new JTextField();
        inputName.setFont(inputName.getFont().deriveFont(Font.PLAIN, 25));
        inputPassword = new JPasswordField();
        inputPassword.setFont(inputName.getFont().deriveFont(Font.PLAIN, 25));
        loginButton = new JButton("LOG IN");
        loginButton.setFont(new Font("Montserrat", Font.BOLD, 25));
        showPassword = new JCheckBox("SHOW PASSWORD");
        showPassword.setFont(new Font("Montserrat", Font.PLAIN, 12));
        container = getContentPane();
        container.setBackground(new Color(119,166,247));
        container.setLayout(null);
        window.add(container);
        //Set the main frame
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void setLocationAndSize() {
        userName.setBounds(350, 150, 250, 40);
        userPassword.setBounds(350, 260, 250, 40);
        inputName.setBounds(650, 150, 250, 40);
        inputPassword.setBounds(650, 260, 250, 40);
        showPassword.setBounds(770, 320, 150, 30);
        loginButton.setBounds(650, 450, 200, 40);
    }

    private void addToContainer(){
        container.add(userName);
        container.add(userPassword);
        container.add(inputName);
        container.add(inputPassword);
        container.add(showPassword);
        container.add(loginButton);
    }

    private void addAction(){
        showPassword.addActionListener(this);
        loginButton.addActionListener(this);
    }

    private void actionShowPassword(ActionEvent e){
        if ((e.getSource() == showPassword) && showPassword.isSelected()) {
            inputPassword.setEchoChar((char)0);
        }
        else if((e.getSource() == showPassword))
                inputPassword.setEchoChar('●');
    }

    private void actionLoginButton(ActionEvent e){
        if ((e.getSource() == loginButton)){
            if(controleur.loginAccess(inputName.getText(), inputPassword.getText()))
                window.dispose();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        actionShowPassword(e);
        actionLoginButton(e);
    }

}
