package daniKazzoul.view;

import daniKazzoul.controller.*;
import daniKazzoul.model.BoissonNomEnum;
import daniKazzoul.model.SimulateurModel;

import javax.swing.*;
import java.awt.*;


public abstract class Vue extends JFrame {

    // Create views swing UI components
    // Launch the application.
    public JFrame frame;
    public final SimulateurController simulateurController;
    public final ParametreControlleur parametreControlleur;
    public final MaintenanceEntretientControlleur maintenanceEntretientControlleur;
    public final DonneeFavoris donneeFavoris;
    public final OperationControlleur operationControlleur;
    public final SimulateurModel simulateurModel;


    static Timer timer;
    public int intensite = 0, quantite = 0;
    public boolean selected;                           // Deux tasses

    public static boolean nettoyageAccompli = true;
    public static boolean detartrageAccompli = true;
    public static boolean nettoyerMousseurAccompli = true;
    public static boolean calcNCleanAccompli = true;

    //--------------------------------
    public static JTextField textField_Choice;
    public static JTextField textField_Quantite;
    public static JTextField textField_Intensite;

    public static JTextArea textArea_MessageEcran;
    public static JProgressBar progressBar;

    public static JButton btnStartStop;
    public static JButton btnBas;
    public static JButton btnOk;
    public static JButton btnMenu;
    public static JButton btnRetour;

    public static JButton btnExpresso;
    public static JButton btnCafeLait;
    public static JButton btnCafe;
    public static JButton btnCappuccino;
    public static JButton btnEauChaude;
    public static JButton btnAmericano;

    public static JButton btnDeuxtasses;
    public static JButton btnFavorisSecurite;
    public static JButton btnQuantit;
    public static JButton btnIntensit;


    //public abstract void registerListener(SimulateurController controller);

    // Create the application.
    public Vue() {
        simulateurController = SimulateurController.getInstance();
        parametreControlleur = ParametreControlleur.getInstance();
        maintenanceEntretientControlleur = MaintenanceEntretientControlleur.getInstance();
        donneeFavoris = DonneeFavoris.getInstance();
        operationControlleur = OperationControlleur.getInstance();
        simulateurModel = SimulateurModel.getInstance();
    }


    /******************************************
     * - Les bouttons
     *****************************************/
    // Menu -----------------------------------------------------
    public void createButtonMenu() {
        btnMenu = new JButton("Menu");
        //btnMenu.setIcon(new ImageIcon("icon//Menu.png"));

        btnMenu.setFont(new Font("Dialog", Font.BOLD, 24));
        btnMenu.setBounds(867, 222, 120, 120);
        frame.getContentPane().add(btnMenu);
    }

    // Ok -------------------------------------------------------

    public void createOKButton() {

        btnOk = new JButton("Ok");
        //btnOk.setIcon(new ImageIcon("icon/Ok.png"));

        btnOk.setFont(new Font("Dialog", Font.BOLD, 24));
        btnOk.setBounds(690, 222, 120, 120);

        frame.getContentPane().add(btnOk);
    }


    // Retour ---------------------------------------------------

    public void createRetourButton() {
        btnRetour = new JButton("Retour");
        //btnRetour.setIcon(new ImageIcon("icon//Retour.png"));

        btnRetour.setFont(new Font("Dialog", Font.BOLD, 24));
        btnRetour.setBounds(150, 222, 120, 120);

        frame.getContentPane().add(btnRetour);
    }


    // Bas --------------------------------------------------------

    public void createBasButton() {
        btnBas = new JButton("Bas");
        //    btnBas.setIcon(new ImageIcon("icon//bas.png"));

        btnBas.setFont(new Font("Dialog", Font.BOLD, 20));
        btnBas.setBounds(362, 145, 249, 65);
        frame.getContentPane().add(btnBas);
    }


    /********************    Les bouttons des boissons  ***************************************/

    // Les boissons cafe, qui contient (eau et café)
    // Expresso-----------------------------------------
    public void createExpressoButton() {
        btnExpresso = new JButton(String.valueOf(BoissonNomEnum.Expresso));
        //btnExpresso = new JButton("");
        btnExpresso.setIcon(new ImageIcon("icon//Expresso.80.png"));
        btnExpresso.setForeground(new Color(204, 255, 255));
        btnExpresso.setBackground(new Color(51, 51, 51));

        btnExpresso.setFont(new Font("Dialog", Font.BOLD, 12));
        btnExpresso.setBounds(12, 12, 110, 105);

        frame.getContentPane().add(btnExpresso);
        //  btnExpresso.addActionListener(e -> textField_Choice.setText("Expresso"));


    }

    // Café -----------------------------------------
    public void createCafeButton() {
        //btnCafe = new JButton(String.valueOf(BoissonNomEnum.Cafe));
        btnCafe = new JButton();
        btnCafe.setIcon(new ImageIcon("icon//Cafe.png"));
        btnCafe.setForeground(new Color(204, 255, 255));
        btnCafe.setBackground(new Color(51, 51, 51));

        btnCafe.setFont(new Font("Dialog", Font.BOLD, 12));
        btnCafe.setBounds(148, 12, 110, 105);

        //btnCafe.addActionListener(e -> textField_Choice.setText("Cafe"));
        frame.getContentPane().add(btnCafe);
    }

    // Café au Lait-----------------------------------------
    public void createCafeAuLaitButton() {
        //btnCafeLait = new JButton(String.valueOf(BoissonNomEnum.CafeLait));
        btnCafeLait = new JButton();
        btnCafeLait.setIcon(new ImageIcon("icon//CafeLait.png"));
        btnCafeLait.setForeground(new Color(204, 255, 255));
        btnCafeLait.setBackground(new Color(51, 51, 51));

        btnCafeLait.setFont(new Font("Dialog", Font.BOLD, 12));
        btnCafeLait.setBounds(282, 12, 110, 105);

        //btnCafeLait.addActionListener(e -> textField_Choice.setText("CafeLait"));
        frame.getContentPane().add(btnCafeLait);
    }

    // Cappuccino -----------------------------------------
    public void createCappuccinoButton() {
        //btnCappuccino = new JButton(String.valueOf(BoissonNomEnum.Cappuccino));
        btnCappuccino = new JButton();
        btnCappuccino.setIcon(new ImageIcon("icon//Cappuccino.png"));
        btnCappuccino.setForeground(new Color(204, 255, 255));
        btnCappuccino.setBackground(new Color(51, 51, 51));

        btnCappuccino.setBounds(416, 12, 110, 105);

        //btnCappuccino.addActionListener(e -> textField_Choice.setText("Cappuccino"));
        frame.getContentPane().add(btnCappuccino);
    }

    // Eau Chaude -------------------------------------------
    public void createEauChaudeButton() {
        //btnEauChaude = new JButton(String.valueOf(BoissonNomEnum.EauChaude));
        btnEauChaude = new JButton();
        btnEauChaude.setIcon(new ImageIcon("icon//EauChaude.png"));
        btnEauChaude.setForeground(new Color(204, 255, 255));
        btnEauChaude.setBackground(new Color(51, 51, 51));

        btnEauChaude.setBounds(550, 12, 110, 105);

        //btnEauChaude.addActionListener(e -> textField_Choice.setText("EauChaude"));
        frame.getContentPane().add(btnEauChaude);
    }

    // Americano --------------------------------------------
    public void createAmericanoButton() {
        //btnAmericano = new JButton(String.valueOf(BoissonNomEnum.Americano));
        btnAmericano = new JButton();
        btnAmericano.setIcon(new ImageIcon("icon//Americano.png"));
        btnAmericano.setForeground(new Color(204, 255, 255));
        btnAmericano.setBackground(new Color(51, 51, 51));

        btnAmericano.setBounds(686, 12, 110, 105);

        //btnAmericano.addActionListener(e -> textField_Choice.setText("Americano"));
        frame.getContentPane().add(btnAmericano);
    }

    // Frame -----------------------------------------------------
    public void createJframe() {
        frame = new JFrame("Simulateur Machine à café");
        frame.setForeground(new Color(0, 0, 0));
        frame.setBackground(new Color(255, 255, 255));
        frame.getContentPane().setFont(new Font("Dialog", Font.PLAIN, 14));
        frame.getContentPane().setBackground(new Color(51, 51, 51));
        frame.setBounds(100, 100, 1000, 600);
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
        textField_Choice.setEditable(false);

        textField_Quantite = new JTextField("Petit");
        textField_Quantite.setHorizontalAlignment(SwingConstants.CENTER);
        textField_Quantite.setFont(new Font("Dialog", Font.BOLD, 16));
        textField_Quantite.setBounds(279, 513, 149, 28);
        frame.getContentPane().add(textField_Quantite);
        textField_Quantite.setColumns(10);
        textField_Quantite.setEditable(false);

        textField_Intensite = new JTextField("Doux");
        textField_Intensite.setHorizontalAlignment(SwingConstants.CENTER);
        textField_Intensite.setFont(new Font("Dialog", Font.BOLD, 16));
        textField_Intensite.setBounds(529, 513, 153, 29);
        frame.getContentPane().add(textField_Intensite);
        textField_Intensite.setColumns(10);
        textField_Intensite.setEditable(false);

    }

    // TextArea -----------------------------------------------------
    public void createJTextArea() {

        textArea_MessageEcran = new JTextArea();
        textArea_MessageEcran.setFont(new Font("Dialog", Font.BOLD, 14));
        textArea_MessageEcran.setBounds(280, 272, 402, 179);
        frame.getContentPane().add(textArea_MessageEcran);
        textArea_MessageEcran.setColumns(10);
        textArea_MessageEcran.setEditable(false);
    }


    public abstract void registerListener(SimulateurController controller);
}