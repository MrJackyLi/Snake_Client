package gui;

import sdk.Logic;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Created by Jacky on 12/11/15.
 */

public class Menu extends JPanel {

    private JButton btnJoinGame;
    private JButton btnCreateGame;
    private JButton btnDeleteGame;
    private JButton btnGetHighscore;
    private JButton btnLogOut;
    private JLabel lblSnake;
    private JLabel menuLabel;
    private JLabel lblHiWelcome;


    public Menu() {
        setForeground(Color.GRAY);
        setBackground(Color.LIGHT_GRAY);
        setBounds(100, 100, 668, 395);
        setLayout(null);

        lblSnake = new JLabel("SNAKE");
        lblSnake.setForeground(Color.BLACK);
        lblSnake.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
        lblSnake.setBounds(292, 27, 84, 36);
        add(lblSnake);

        menuLabel = new JLabel("MENU");
        menuLabel.setForeground(Color.BLACK);
        menuLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
        menuLabel.setBounds(296, 62, 75, 36);
        add(menuLabel);

        lblHiWelcome = new JLabel("Hi, welcome! Please choose your option");
        lblHiWelcome.setForeground(Color.BLACK);
        lblHiWelcome.setBounds(213, 100, 250, 16);
        add(lblHiWelcome);

        btnJoinGame = new JButton("Join Game");
        btnJoinGame.setForeground(Color.BLACK);
        btnJoinGame.setBounds(53, 128, 243, 70);
        btnJoinGame.setActionCommand("Join Game");
        add(btnJoinGame);

        btnCreateGame = new JButton("Create Game");
        btnCreateGame.setForeground(Color.BLACK);
        btnCreateGame.setBounds(53, 213, 243, 70);
        btnCreateGame.setActionCommand("Create Game");
        add(btnCreateGame);

        btnDeleteGame = new JButton("Delete Game");
        btnDeleteGame.setForeground(Color.BLACK);
        btnDeleteGame.setBounds(376, 213, 243, 70);
        btnDeleteGame.setActionCommand("Delete Game");
        add(btnDeleteGame);

        btnGetHighscore = new JButton("Get Highscore");
        btnGetHighscore.setForeground(Color.BLACK);
        btnGetHighscore.setBounds(376, 128, 243, 70);
        btnGetHighscore.setActionCommand("Highscore");
        add(btnGetHighscore);

        btnLogOut = new JButton("Log Out");
        btnLogOut.setForeground(Color.BLACK);
        btnLogOut.setBounds(212, 302, 243, 70);
        btnLogOut.setActionCommand("Log Out");
        add(btnLogOut);

    }

    public void addACList(ActionListener ac){
        btnJoinGame.addActionListener(ac);
        btnCreateGame.addActionListener(ac);
        btnDeleteGame.addActionListener(ac);
        btnGetHighscore.addActionListener(ac);
        btnLogOut.addActionListener(ac);
    }

}
