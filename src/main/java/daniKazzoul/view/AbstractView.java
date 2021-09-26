package daniKazzoul.view;

import daniKazzoul.controller.DonneeFavorisController;
import daniKazzoul.controller.MaintenanceEntretientController;
import daniKazzoul.controller.SimulateurController;
import daniKazzoul.model.SimulateurModel;

import javax.swing.*;
import java.awt.*;


public abstract class AbstractView extends JFrame {

    public JFrame frame;
    static Timer timer;
    public static int intensite;
    public static int quantite;
    public static boolean selected;

    public static boolean nettoyageAccompli;
    public static boolean detartrageAccompli;
    public static boolean nettoyerMousseurAccompli;
    public static boolean calcNCleanAccompli;

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

    public SimulateurController simulateurController;
    public MaintenanceEntretientController maintenanceEntretientController;
    public DonneeFavorisController donneeFavorisController;
    public SimulateurModel simulateurModel;


    // use Singleton design pattern
    public static AbstractView initialState = SimulateurView.getInstance();
    private static AbstractView instance = null;
    public static AbstractView getInstance() {
        if (instance == null) {
            // initialise les valeurs
            intensite = 0;
            quantite = 0;
            selected = true;
            nettoyageAccompli = true;
            detartrageAccompli = true;
            nettoyerMousseurAccompli = true;
            calcNCleanAccompli = true;

            instance = initialState;
        }
        return instance;
    }












    /** Create the application. **/

    public AbstractView() {
        simulateurController = SimulateurController.getInstance();
        maintenanceEntretientController = MaintenanceEntretientController.getInstance();
        donneeFavorisController = DonneeFavorisController.getInstance();
        simulateurModel = SimulateurModel.getInstance();
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


    /********************    Les bouttons des boissons  ***************************************/

    // Expresso-----------------------------------------

    public void createExpressoButton() {
        btnExpresso = new JButton("");
        btnExpresso.setIcon(new ImageIcon("icon//Expresso.png"));
        btnExpresso.setForeground(new Color(204, 255, 255));
        btnExpresso.setBackground(new Color(51, 51, 51));
        btnExpresso.setFont(new Font("Dialog", Font.BOLD, 12));
        btnExpresso.setBounds(12, 12, 110, 105);
        frame.getContentPane().add(btnExpresso);

    }

    // Café -----------------------------------------

    public void createCafeButton() {
        btnCafe = new JButton();
        btnCafe.setIcon(new ImageIcon("icon//Cafe.png"));
        btnCafe.setForeground(new Color(204, 255, 255));
        btnCafe.setBackground(new Color(51, 51, 51));
        btnCafe.setFont(new Font("Dialog", Font.BOLD, 12));
        btnCafe.setBounds(148, 12, 110, 105);
        frame.getContentPane().add(btnCafe);
    }

    // Café au Lait-----------------------------------------
    public void createCafeAuLaitButton() {
        btnCafeLait = new JButton();
        btnCafeLait.setIcon(new ImageIcon("icon//CafeLait.png"));
        btnCafeLait.setForeground(new Color(204, 255, 255));
        btnCafeLait.setBackground(new Color(51, 51, 51));
        btnCafeLait.setFont(new Font("Dialog", Font.BOLD, 12));
        btnCafeLait.setBounds(282, 12, 110, 105);
        frame.getContentPane().add(btnCafeLait);
    }

    // Cappuccino -----------------------------------------
    public void createCappuccinoButton() {
        btnCappuccino = new JButton();
        btnCappuccino.setIcon(new ImageIcon("icon//Cappuccino.png"));
        btnCappuccino.setForeground(new Color(204, 255, 255));
        btnCappuccino.setBackground(new Color(51, 51, 51));
        btnCappuccino.setBounds(416, 12, 110, 105);
        frame.getContentPane().add(btnCappuccino);
    }

    // Eau Chaude -------------------------------------------
    public void createEauChaudeButton() {
        btnEauChaude = new JButton();
        btnEauChaude.setIcon(new ImageIcon("icon//EauChaude.png"));
        btnEauChaude.setForeground(new Color(204, 255, 255));
        btnEauChaude.setBackground(new Color(51, 51, 51));
        btnEauChaude.setBounds(550, 12, 110, 105);
        frame.getContentPane().add(btnEauChaude);
    }

    // Americano --------------------------------------------
    public void createAmericanoButton() {
        btnAmericano = new JButton();
        btnAmericano.setIcon(new ImageIcon("icon//Americano.png"));
        btnAmericano.setForeground(new Color(204, 255, 255));
        btnAmericano.setBackground(new Color(51, 51, 51));
        btnAmericano.setBounds(686, 12, 110, 105);
        frame.getContentPane().add(btnAmericano);
    }



    // TextField -----------------------------------------------------
    public void createJTextField() {
        textField_Choice = new JTextField("Expresso");
        textField_Choice.setHorizontalAlignment(SwingConstants.CENTER);
        textField_Choice.setFont(new Font("Dialog", Font.BOLD, 16));
        textField_Choice.setBounds(279, 222, 403, 38);
        textField_Choice.setColumns(10);
        textField_Choice.setEditable(false);
        frame.getContentPane().add(textField_Choice);


        textField_Quantite = new JTextField("Petit");
        textField_Quantite.setHorizontalAlignment(SwingConstants.CENTER);
        textField_Quantite.setFont(new Font("Dialog", Font.BOLD, 16));
        textField_Quantite.setBounds(279, 510, 150, 34);
        textField_Quantite.setColumns(10);
        textField_Quantite.setEditable(false);
        frame.getContentPane().add(textField_Quantite);


        textField_Intensite = new JTextField("Doux");
        textField_Intensite.setHorizontalAlignment(SwingConstants.CENTER);
        textField_Intensite.setFont(new Font("Dialog", Font.BOLD, 16));
        textField_Intensite.setBounds(529, 510, 150, 34);
        textField_Intensite.setColumns(10);
        textField_Intensite.setEditable(false);
        frame.getContentPane().add(textField_Intensite);

    }

    // TextArea -----------------------------------------------------
    public void createJTextArea() {
        textArea_MessageEcran = new JTextArea();
        textArea_MessageEcran.setFont(new Font("Dialog", Font.BOLD, 14));
        textArea_MessageEcran.setBounds(280, 272, 402, 180);
        textArea_MessageEcran.setColumns(10);
        textArea_MessageEcran.setEditable(false);
        frame.getContentPane().add(textArea_MessageEcran);

    }

}