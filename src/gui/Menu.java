package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

/**
 * Created by Jacky on 12/11/15.
 */

public class Menu extends JPanel {

    public Menu() {
        setForeground(Color.GRAY);
        setBackground(Color.LIGHT_GRAY);
        setBounds(100, 100, 668, 395);
        setLayout(null);

        JLabel menuLabel = new JLabel("MENU");
        menuLabel.setForeground(Color.BLACK);
        menuLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
        menuLabel.setBounds(296, 62, 75, 36);
        add(menuLabel);

        JLabel lblHiWelcome = new JLabel("Hi, welcome! Please choose your option");
        lblHiWelcome.setForeground(Color.BLACK);
        lblHiWelcome.setBounds(213, 100, 250, 16);
        add(lblHiWelcome);

        JButton btnStartGame = new JButton("Start Game");
        btnStartGame.setForeground(Color.BLACK);
        btnStartGame.setBounds(53, 128, 243, 70);
        add(btnStartGame);

        JButton btnCreateGame = new JButton("CreateGame");
        btnCreateGame.setForeground(Color.BLACK);
        btnCreateGame.setBounds(53, 213, 243, 70);
        add(btnCreateGame);

        JButton btnDeleteGame = new JButton("Delete Game");
        btnDeleteGame.setForeground(Color.BLACK);
        btnDeleteGame.setBounds(53, 299, 243, 70);
        add(btnDeleteGame);

        JButton btnGetHighscore = new JButton("Get Highscore");
        btnGetHighscore.setForeground(Color.BLACK);
        btnGetHighscore.setBounds(376, 128, 243, 70);
        add(btnGetHighscore);

        JButton btnGetResults = new JButton("Get Results");
        btnGetResults.setForeground(Color.BLACK);
        btnGetResults.setBounds(376, 213, 243, 70);
        add(btnGetResults);

        JButton btnLogOut = new JButton("Log Out");
        btnLogOut.setForeground(Color.BLACK);
        btnLogOut.setBounds(376, 299, 243, 70);
        add(btnLogOut);

        JLabel lblSnake = new JLabel("SNAKE");
        lblSnake.setForeground(Color.BLACK);
        lblSnake.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
        lblSnake.setBounds(292, 27, 84, 36);
        add(lblSnake);

    }
    }