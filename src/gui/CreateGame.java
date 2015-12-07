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
    private JButton btnBack;
    private JButton btnCreateGame;
    private JTextField txtFGameName;
    private JTextField txtFMovements;
    private JLabel lblActionsA;
    private JLabel lblGameName;
    private JLabel lblTypeMovements;
    private JComboBox comboCreateBox;
    private JLabel backGround;
    private JLabel lblChooseOpponent;


    /**
     * Create the panel.
     */
    public CreateGame(){
        setForeground(Color.GRAY);
        setBackground(Color.LIGHT_GRAY);
        setBounds(100, 100, 668, 495);
        setLayout(null);

        btnBack = new JButton("BACK TO MENU");
        btnBack.setForeground(Color.CYAN);
        btnBack.setBounds(406, 416, 174, 70);
        btnBack.setActionCommand("BACK TO MENU");
        add(btnBack);

        btnCreateGame = new JButton("CREATE GAME");
        btnCreateGame.setForeground(Color.CYAN);
        btnCreateGame.setActionCommand("CREATE GAME");
        btnCreateGame.setBounds(83, 416, 174, 70);
        add(btnCreateGame);

        txtFGameName = new JTextField();
        txtFGameName.setBounds(83, 162, 186, 41);
        add(txtFGameName);
        txtFGameName.setColumns(10);

        txtFMovements = new JTextField();
        txtFMovements.setColumns(10);
        txtFMovements.setBounds(376, 271, 245, 35);
        add(txtFMovements);

        lblGameName = new JLabel("Game Name:");
        lblGameName.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        lblGameName.setForeground(Color.CYAN);
        lblGameName.setBounds(130, 145, 92, 16);
        add(lblGameName);

        lblTypeMovements = new JLabel("Type Movements:");
        lblTypeMovements.setForeground(Color.CYAN);
        lblTypeMovements.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        lblTypeMovements.setBounds(439, 243, 132, 16);
        add(lblTypeMovements);

        lblActionsA = new JLabel("Actions: ");
        lblActionsA.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        lblActionsA.setForeground(Color.CYAN);
        lblActionsA.setHorizontalAlignment(SwingConstants.CENTER);
        lblActionsA.setBounds(117, 255, 94, 16);
        add(lblActionsA);

        lblChooseOpponent = new JLabel("Choose opponent");
        lblChooseOpponent.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        lblChooseOpponent.setForeground(Color.CYAN);
        lblChooseOpponent.setBounds(431, 145, 132, 16);
        add(lblChooseOpponent);

        comboCreateBox = new JComboBox();
        comboCreateBox.setBounds(375, 160, 246, 41);
        add(comboCreateBox);

        backGround = new JLabel("");
        backGround.setIcon(new ImageIcon(Login.class.getResource("snakecreate.jpg")));
        backGround.setBounds(0, 0, 668, 495);
        add(backGround);
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


