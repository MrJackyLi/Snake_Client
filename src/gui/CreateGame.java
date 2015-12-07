package gui;

import sdk.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    private JComboBox comboCreateBox;
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
        txtFGameName.setBounds(241, 121, 186, 41);
        add(txtFGameName);
        txtFGameName.setColumns(10);

        txtFMovements = new JTextField();
        txtFMovements.setColumns(10);
        txtFMovements.setBounds(360, 301, 245, 81);
        add(txtFMovements);

        lblGameName = new JLabel("Game Name:");
        lblGameName.setBounds(288, 93, 92, 16);
        add(lblGameName);

        lblTypeMovements = new JLabel("Type Movements:");
        lblTypeMovements.setBounds(421, 284, 117, 16);
        add(lblTypeMovements);

        lblActionsA = new JLabel("Actions: ");
        lblActionsA.setHorizontalAlignment(SwingConstants.CENTER);
        lblActionsA.setBounds(127, 284, 94, 16);
        add(lblActionsA);

        lblWUp = new JLabel("\"W\": UP");
        lblWUp.setHorizontalAlignment(SwingConstants.CENTER);
        lblWUp.setBounds(138, 310, 61, 16);
        add(lblWUp);

        lblsDown = new JLabel("\"S\": DOWN");
        lblsDown.setHorizontalAlignment(SwingConstants.CENTER);
        lblsDown.setBounds(132, 376, 74, 16);
        add(lblsDown);

        lblaLeft = new JLabel("\"A\": LEFT");
        lblaLeft.setHorizontalAlignment(SwingConstants.CENTER);
        lblaLeft.setBounds(48, 337, 74, 16);
        add(lblaLeft);

        lbldRight = new JLabel("\"D\": RIGHT");
        lbldRight.setHorizontalAlignment(SwingConstants.CENTER);
        lbldRight.setBounds(225, 335, 74, 21);
        add(lbldRight);

        lblChooseOpponent = new JLabel("Choose opponent");
        lblChooseOpponent.setBounds(275, 188, 117, 16);
        add(lblChooseOpponent);

        comboCreateBox = new JComboBox();
        comboCreateBox.setBounds(211, 215, 246, 41);
        add(comboCreateBox);
    }


    public String getTxtFGameName() {
        return txtFGameName.getText();
    }

    public String getTxtFMovements() {
        return txtFMovements.getText();
    }

    public void actionPerformedBack(ActionListener back) {
        btnBack.addActionListener(back);
    }

    public void addActionCreate(ActionListener create) {btnCreateGame.addActionListener(create);}

    public void addUser(ArrayList<User>users) {
        comboCreateBox.removeAllItems();
        for (User usr : users) {
            comboCreateBox.addItem(usr.getUsername());
        }
    }

    public String getUser(){

        return (String) comboCreateBox.getSelectedItem();
        }

    public void ClearTextFieldCreate(){
        txtFGameName.setText("");
        txtFMovements.setText("");
    }


}


