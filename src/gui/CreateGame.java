package gui;

import sdk.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
//import gui.OpponentTable;

/**
 * Created by Jacky on 16/11/15.
 */

public class CreateGame extends JPanel {
    private JLabel lblCreateGame;
    private JButton btnBack;
    private JButton btnCreateGame;
    private JTextField txtFGameName;
    private JTextField txtFMovements;
    private JLabel lblActionsA;
    private JLabel lblWUp;
    private JLabel lblsDown;
    private JLabel lblaLeft;
    private JLabel lbldRight;
    private JLabel lblGameName;
    private JLabel lblTypeMovements;
    private JComboBox comboBox;
    private JLabel lblChooseOpponent;


    /**
     * Create the panel.
     */
    public CreateGame(){
        setForeground(Color.GRAY);
        setBackground(Color.LIGHT_GRAY);
        setBounds(100, 100, 668, 495);
        setLayout(null);

        lblCreateGame = new JLabel("CREATE GAME");
        lblCreateGame.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
        lblCreateGame.setBounds(240, 29, 186, 41);
        add(lblCreateGame);

        btnBack = new JButton("BACK TO MENU");
        btnBack.setForeground(Color.RED);
        btnBack.setBounds(406, 416, 147, 41);
        btnBack.setActionCommand("BACK TO MENU");
        add(btnBack);

        btnCreateGame = new JButton("CREATE GAME");
        btnCreateGame.setForeground(Color.GREEN);
        btnCreateGame.setActionCommand("CREATE GAME");
        btnCreateGame.setBounds(83, 416, 147, 41);
        add(btnCreateGame);

        txtFGameName = new JTextField();
        txtFGameName.setBounds(83, 137, 186, 41);
        add(txtFGameName);
        txtFGameName.setColumns(10);

        txtFMovements = new JTextField();
        txtFMovements.setColumns(10);
        txtFMovements.setBounds(355, 255, 245, 81);
        add(txtFMovements);

        lblGameName = new JLabel("Game Name:");
        lblGameName.setBounds(138, 109, 92, 16);
        add(lblGameName);

        lblTypeMovements = new JLabel("Type Movements:");
        lblTypeMovements.setBounds(416, 238, 117, 16);
        add(lblTypeMovements);

        lblActionsA = new JLabel("Actions: ");
        lblActionsA.setHorizontalAlignment(SwingConstants.CENTER);
        lblActionsA.setBounds(127, 241, 94, 16);
        add(lblActionsA);

        lblWUp = new JLabel("\"W\": UP");
        lblWUp.setHorizontalAlignment(SwingConstants.CENTER);
        lblWUp.setBounds(138, 267, 61, 16);
        add(lblWUp);

        lblsDown = new JLabel("\"S\": DOWN");
        lblsDown.setHorizontalAlignment(SwingConstants.CENTER);
        lblsDown.setBounds(132, 333, 74, 16);
        add(lblsDown);

        lblaLeft = new JLabel("\"A\": LEFT");
        lblaLeft.setHorizontalAlignment(SwingConstants.CENTER);
        lblaLeft.setBounds(48, 294, 74, 16);
        add(lblaLeft);

        lbldRight = new JLabel("\"D\": RIGHT");
        lbldRight.setHorizontalAlignment(SwingConstants.CENTER);
        lbldRight.setBounds(225, 292, 74, 21);
        add(lbldRight);

        lblChooseOpponent = new JLabel("Choose opponent");
        lblChooseOpponent.setBounds(429, 110, 117, 16);
        add(lblChooseOpponent);

        comboBox = new JComboBox();
        comboBox.setBounds(355, 137, 246, 41);
        add(comboBox);
    }


    public String getTxtFGameName() {
        return txtFGameName.getText();
    }

    public String getTxtFMovements() {
        return txtFMovements.getText();
    }

    public JButton getBtnCreateGame(){return btnCreateGame;}

    public void actionPerformedBack(ActionListener back) {
        btnBack.addActionListener(back);
    }

    public void addActionCreate(ActionListener create) {btnCreateGame.addActionListener(create);}

    public void addUser(ArrayList<User>users) {
        comboBox.removeAllItems();;
        for (User usr : users) {
            comboBox.addItem(usr.getUsername());
        }
    }

    public String getUser(){

        return (String) comboBox.getSelectedItem();
        }
    }


