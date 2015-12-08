package gui;

/**
 * Created by Jacky on 16/11/15.
 * This class (JoinGame class) contains all needed inputs and outputs for the class' GUI.
 */

/**
 * Import all needed imports for this panel/class.
 */

import sdk.Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class JoinGame extends JPanel {
    private JLabel lblJoinMove;
    private JButton btnBack;
    private JButton btnJoinGame;
    private JTextField txtJoinMove;
    private JLabel lblJoinActions;
    private JLabel lblSelectGame;
    private JComboBox comboJoinBox;
    private JLabel backGround;


    /**
     * Create the panel.
     */
    public JoinGame() {
        setForeground(Color.GRAY);
        setBackground(Color.LIGHT_GRAY);
        setBounds(100, 100, 668, 495);
        setLayout(null);

        btnBack = new JButton("BACK TO MENU");
        btnBack.setForeground(Color.black);
        btnBack.setBounds(406, 416, 174, 70);
        btnBack.setActionCommand("BACK TO MENU");
        add(btnBack);

        btnJoinGame = new JButton("JOIN GAME");
        btnJoinGame.setForeground(Color.black);
        btnJoinGame.setBounds(83, 416, 174, 70);
        add(btnJoinGame);

        txtJoinMove = new JTextField();
        txtJoinMove.setColumns(10);
        txtJoinMove.setBounds(378, 305, 245, 28);
        add(txtJoinMove);

        lblJoinActions = new JLabel("Actions: ");
        lblJoinActions.setForeground(Color.CYAN);
        lblJoinActions.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        lblJoinActions.setHorizontalAlignment(SwingConstants.CENTER);
        lblJoinActions.setBounds(121, 254, 94, 16);
        add(lblJoinActions);

        lblJoinMove = new JLabel("Type Movements:");
        lblJoinMove.setForeground(Color.CYAN);
        lblJoinMove.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        lblJoinMove.setBounds(440, 277, 127, 16);
        add(lblJoinMove);

        lblSelectGame = new JLabel("Join game by selecting a game!");
        lblSelectGame.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        lblSelectGame.setForeground(Color.CYAN);
        lblSelectGame.setBounds(211, 149, 246, 28);
        add(lblSelectGame);

        comboJoinBox = new JComboBox();
        comboJoinBox.setBounds(211, 189, 246, 41);
        add(comboJoinBox);

        //background picture for this class' screen.
        backGround = new JLabel("");
        backGround.setIcon(new ImageIcon(Login.class.getResource("snakejoin.jpg")));
        backGround.setBounds(0, 0, 668, 495);
        add(backGround);
    }

    /**
     * A method to get the movements to join game, which is insert by the user in the textfield, which are being converted to a String
     * @return txtJoinMove.getText()
     */
    public String getTxtJoinMove() {
        return txtJoinMove.getText();
    }

    /**
     * An arraylist of games is being added to the combobox at the JoinGame/panel. As an user can choose a game.
     * An removeAllItems method is called/used to "refresh" the combobox, as it remove all the items/values and add the latest games according to the database.
     * @param gameChallenge
     */
    public void setGameChallenge(ArrayList<Game> gameChallenge) {
        comboJoinBox.removeAllItems();
        for (Game game : gameChallenge) {
            comboJoinBox.addItem(game.getName());
        }
    }

    /**
     * A method of JCombobox that returns the selected item, from the combobox.
     * @return (String) comboJoinBox.getSelectedItem();
     */
    public String getChallenge() {
        return (String) comboJoinBox.getSelectedItem();
    }

    /**
     * A method that is clearing all the textfield in this CreateGame.class
     */
    public void ClearTextfieldJoin() {
        txtJoinMove.setText("");
    }

    /**
     * A method that adds an actionlistener for the the join-button
     * @param Join
     */
    public void actionListenerJoin(ActionListener Join) {
        btnJoinGame.addActionListener(Join);
    }

    /**
     * A method that adds an actionlistener for the back-button
     * @param back
     */
    public void actionPerformedBack(ActionListener back) {
        btnBack.addActionListener(back);
    }
}
