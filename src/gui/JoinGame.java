package gui;

import sdk.Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Created by Jacky on 16/11/15.
 */
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
        btnBack.setForeground(Color.cyan);
        btnBack.setBounds(406, 416, 174, 70);
        btnBack.setActionCommand("BACK TO MENU");
        add(btnBack);

        btnJoinGame = new JButton("JOIN GAME");
        btnJoinGame.setForeground(Color.CYAN);
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

        backGround = new JLabel("");
        backGround.setIcon(new ImageIcon(Login.class.getResource("snakejoin.jpg")));
        backGround.setBounds(0, 0, 668, 495);
        add(backGround);
    }

    public void actionListenerJoin(ActionListener Join) {
        btnJoinGame.addActionListener(Join);
    }

    public String getTxtJoinMove() {
        return txtJoinMove.getText();
    }

    public void setGameChallenge(ArrayList<Game> gameChallenge) {
        comboJoinBox.removeAllItems();
        for (Game game : gameChallenge) {
            comboJoinBox.addItem(game.getName());
        }
    }

    public String getChallenge() {
        return (String) comboJoinBox.getSelectedItem();
    }

    public void actionPerformedBack(ActionListener back) {
        btnBack.addActionListener(back);
    }

    public void ClearTextfieldJoin() {
        txtJoinMove.setText("");
    }
}
