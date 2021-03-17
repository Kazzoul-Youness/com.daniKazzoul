package daniKazzoul.view;

import daniKazzoul.controller.*;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;


public class Vue extends JFrame {

    // Create views swing UI components
    // Launch the application.
    public JFrame frame;
    public final BoissonController boissonController;
    public final ParametreControlleur parametreControlleur;
    public final MaintenanceEntretientControlleur maintenanceControlleur;
    public final DonneeFavoris donneeFavoris;
    public final OperationControlleur operationControlleur;


    Timer timer, timer1, timer2, timer3, timer4, timer5, timer6;
    public int intensite = 0, quantite = 0;
    public boolean selected;                           // Deux tasses
    public boolean nettoyageAccompli = true;           // Si nettoyage est effectuer ou pas
    String langue;                              // Programme de traduction, il n'est pas completement fini.!

    //--------------------------------
    public JTextField textField_Choice;
    public JTextField textField_Quantite;
    public JTextField textField_Intensite;

    public JTextArea textArea_MessageEcran;
    public JProgressBar progressBar;

    public JButton btnStartStop;
    public JButton btnBas;
    public JButton btnOk;
    public JButton btnMenu;
    public JButton btnRetour;
    public JButton btnExpresso;
    public JButton btnCafeLait;
    public JButton btnCafe;
    public JButton btnCappuccino;
    public JButton btnEauChaude;
    public JButton btnDeuxtasses;
    public JButton btnAmericano;
    public JButton btnFavorisSecurite;
    public JButton btnQuantit;
    public JButton btnIntensit;


    // Create the application.
    public Vue() throws FileNotFoundException {
        boissonController      = BoissonController.getInstance();
        parametreControlleur   = ParametreControlleur.getInstance();
        maintenanceControlleur = MaintenanceEntretientControlleur.getInstance();
        donneeFavoris          = DonneeFavoris.getInstance();
        operationControlleur   = OperationControlleur.getInstance();
    }


    /* *********************************************************************************/
    /*      - Les bouttons                                            ********/

    // Menu -----------------------------------------------------
    public void createButtonMenuPrincipal() {
        btnMenu = new JButton("Menu");
        btnMenu.setIcon(new ImageIcon("icon//Menu.png"));
        btnMenu.setForeground(new Color(204, 255, 255));
        btnMenu.setBackground(new Color(255, 255, 255));
        btnMenu.setBounds(867, 228, 107, 104);
        frame.getContentPane().add(btnMenu);
    }

    // Retour ---------------------------------------------------

    public void createRetourButton() {
        btnRetour = new JButton("Retour");
        btnRetour.setEnabled(true);
        btnRetour.setIcon(new ImageIcon("icon//Retour.png"));
        btnRetour.setBounds(131, 230, 107, 100);
        frame.getContentPane().add(btnRetour);
    }

    // Ok -------------------------------------------------------

    public void createOKButton() {

        btnOk = new JButton("Ok");
        btnOk.setIcon(new ImageIcon("icon/Ok.png"));
        btnOk.setForeground(new Color(204, 255, 255));
        btnOk.setBackground(new Color(51, 51, 51));
        btnOk.setBounds(725, 228, 97, 104);
        frame.getContentPane().add(btnOk);
        //btnOk.setEnabled(false);

    }

    // Bas --------------------------------------------------------

    public void createBasButton() {
        btnBas = new JButton("Bas");
        btnBas.setIcon(new ImageIcon("icon//bas.png"));
        btnBas.setBounds(362, 145, 249, 65);
        frame.getContentPane().add(btnBas);
        // clickBasMenu();
    }

    // Americano ------------------------------------------------

    public void createAmericanoButton() {
        btnAmericano = new JButton("Americano");
        btnAmericano.setIcon(new ImageIcon("icon//Americano.png"));
        btnAmericano.setForeground(new Color(204, 255, 255));
        btnAmericano.setBackground(new Color(51, 51, 51));

        btnAmericano.addActionListener(e -> textField_Choice.setText("Americano"));
        btnAmericano.setBounds(715, 12, 107, 104);
        frame.getContentPane().add(btnAmericano);
    }

    // Deux Tasses -----------------------------------------------------

    // Eau Chaude -------------------------------------------

    public void createEauChaudeButton() {
        btnEauChaude = new JButton("EauChaude");
        btnEauChaude.setIcon(new ImageIcon("icon//EauChaude.png"));
        btnEauChaude.setForeground(new Color(204, 255, 255));
        btnEauChaude.setBackground(new Color(51, 51, 51));

        btnEauChaude.addActionListener(e -> textField_Choice.setText("EauChaude"));
        btnEauChaude.setBounds(558, 12, 110, 104);
        frame.getContentPane().add(btnEauChaude);
    }

    // Cappuccino -----------------------------------------

    public void createCappuccinoButton() {
        btnCappuccino = new JButton("Cappuccino");
        btnCappuccino.setIcon(new ImageIcon("icon//Cappuccino.png"));
        btnCappuccino.setForeground(new Color(204, 255, 255));
        btnCappuccino.setBackground(new Color(51, 51, 51));

        btnCappuccino.addActionListener(e -> textField_Choice.setText("Cappuccino"));
        btnCappuccino.setBounds(420, 12, 110, 104);
        frame.getContentPane().add(btnCappuccino);
    }

    // Café -----------------------------------------

    public void createCafeButton() {
        btnCafe = new JButton("Cafe");
        btnCafe.setIcon(new ImageIcon("icon//Cafe.png"));
        btnCafe.setForeground(new Color(204, 255, 255));
        btnCafe.setBackground(new Color(51, 51, 51));

        btnCafe.addActionListener(e -> textField_Choice.setText("Café"));
        btnCafe.setFont(new Font("Dialog", Font.BOLD, 12));
        btnCafe.setBounds(148, 12, 110, 104);
        frame.getContentPane().add(btnCafe);
    }

    // Café au Lait-----------------------------------------------------

    public void createCafeAuLaitButton() {
        btnCafeLait = new JButton("CafeLait");
        btnCafeLait.setIcon(new ImageIcon("icon//CafeLait.png"));
        btnCafeLait.setForeground(new Color(204, 255, 255));
        btnCafeLait.setBackground(new Color(51, 51, 51));

        btnCafeLait.addActionListener(e -> textField_Choice.setText("CaféLait"));
        btnCafeLait.setFont(new Font("Dialog", Font.BOLD, 12));
        btnCafeLait.setBounds(282, 12, 110, 104);
        frame.getContentPane().add(btnCafeLait);
    }

    // Expresso-----------------------------------------

    public void createExpressoButton() {
        btnExpresso = new JButton("Expresso");
        btnExpresso.setIcon(new ImageIcon("icon//Expresso.80.png"));
        btnExpresso.setForeground(new Color(204, 255, 255));
        btnExpresso.setBackground(new Color(51, 51, 51));

        btnExpresso.setFont(new Font("Dialog", Font.BOLD, 12));
        btnExpresso.setBounds(12, 12, 110, 104);
        frame.getContentPane().add(btnExpresso);

        btnExpresso.addActionListener(e -> textField_Choice.setText("Expresso"));
    }

    // Frame -----------------------------------------------------

    public void createJframe() {
        frame = new JFrame("Simulateur Machine à café");
        frame.setForeground(new Color(0, 0, 0));
        frame.setBackground(new Color(255, 255, 255));
        frame.getContentPane().setFont(new Font("Dialog", Font.PLAIN, 14));
        frame.getContentPane().setBackground(new Color(51, 51, 51));
        frame.setBounds(100, 100, 1000, 593);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);

    }

    // TextField -----------------------------------------------------

    public void createJTextField() {

        textField_Choice = new JTextField("Expresso");
        textField_Choice.setHorizontalAlignment(SwingConstants.CENTER);
        textField_Choice.setFont(new Font("Dialog", Font.BOLD, 16));
        textField_Choice.setBounds(279, 222, 403, 38);
        frame.getContentPane().add(textField_Choice);
        textField_Choice.setColumns(10);

        textField_Quantite = new JTextField("Petit");
        textField_Quantite.setHorizontalAlignment(SwingConstants.CENTER);
        textField_Quantite.setFont(new Font("Dialog", Font.BOLD, 16));
        textField_Quantite.setBounds(279, 513, 149, 28);
        frame.getContentPane().add(textField_Quantite);
        textField_Quantite.setColumns(10);

        textField_Intensite = new JTextField("Doux");
        textField_Intensite.setHorizontalAlignment(SwingConstants.CENTER);
        textField_Intensite.setFont(new Font("Dialog", Font.BOLD, 16));
        textField_Intensite.setBounds(529, 513, 153, 29);
        frame.getContentPane().add(textField_Intensite);
        textField_Intensite.setColumns(10);

    }

    // TextArea -----------------------------------------------------

    public void createJTextArea() {

        textArea_MessageEcran = new JTextArea();
        textArea_MessageEcran.setFont(new Font("Dialog", Font.BOLD, 14));
        textArea_MessageEcran.setBounds(280, 272, 402, 179);
        frame.getContentPane().add(textArea_MessageEcran);
        textArea_MessageEcran.setColumns(10);
    }


}