package gui;

/**
 * Created by Jacky on 16/11/15.
 * This class (CreateGame class) contains all needed inputs and outputs for the class' GUI.
 */

/**
 * Import all needed imports for this panel/class.
 */

import sdk.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    public CreateGame() {
        setForeground(Color.GRAY);
        setBackground(Color.LIGHT_GRAY);
        setBounds(100, 100, 668, 495);
        setLayout(null);

        btnBack = new JButton("BACK TO MENU");
        btnBack.setForeground(Color.black);
        btnBack.setBounds(406, 416, 174, 70);
        btnBack.setActionCommand("BACK TO MENU");
        add(btnBack);

        btnCreateGame = new JButton("CREATE GAME");
        btnCreateGame.setForeground(Color.black);
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

        //background picture for this class' screen.
        backGround = new JLabel("");
        backGround.setIcon(new ImageIcon(Login.class.getResource("snakecreate.jpg")));
        backGround.setBounds(0, 0, 668, 495);
        add(backGround);
    }

    /**
     * A method to get the name of the game, which is insert by the user in the textfield, which are being converted to a String
     * @return txtFGameName.getText()
     */
    public String getTxtFGameName() {
        return txtFGameName.getText();
    }

    /**
     * A method to get the user's movements/actions of the game, which is insert by the user in the textfield, which are being converted to a String
     * @return txtFMovements.getText()
     */
    public String getTxtFMovements() {
        return txtFMovements.getText();
    }

    /**
     * An arraylist of users is being added to the combobox at the CreateGame/panel. As an user can choose an opponnent.
     * An removeAllItems method is called/used to "refresh" the combobox, as it remove all the items/values and add the latest values according to the database.
     * @param users
     */
    public void addUser(ArrayList<User> users) {
        comboCreateBox.removeAllItems();
        for (User usr : users) {
            comboCreateBox.addItem(usr.getUsername());
        }
    }

    /**
     * A method that returns the selected item, from the combobox.
     * @return (String) comboCreateBox.getSelectedItem()
     */
    public String getUser() {

        return (String) comboCreateBox.getSelectedItem();
    }

    /**
     * A method that is clearing all the textfield in this CreateGame.class
     */
    public void ClearTextFieldCreate() {
        txtFGameName.setText("");
        txtFMovements.setText("");
    }

    /**
     * A method that adds an actionlistener for the back-button
     * @param back
     */
    public void actionPerformedBack(ActionListener back) {
        btnBack.addActionListener(back);
    }

    /**
     * A method that adds an actionlisten for the create-button
     * @param create
     */
    public void addActionCreate(ActionListener create) {
        btnCreateGame.addActionListener(create);
    }

}