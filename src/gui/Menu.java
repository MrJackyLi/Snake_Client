package gui;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

/**
 * Created by Jacky on 12/11/15.
 */

public class Menu extends JPanel {

    private JButton btnJoinGame;
    private JButton btnCreateGame;
    private JButton btnDeleteGame;
    private JButton btnGetHighscore;
    private JButton btnLogOut;
    private JLabel backGround;
    private JLabel menuMessage;


    public Menu() {
        setForeground(Color.GRAY);
        setBackground(Color.LIGHT_GRAY);
        setBounds(100, 100, 668, 495);
        setLayout(null);

        menuMessage = new JLabel("");
        menuMessage.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        menuMessage.setForeground(Color.CYAN);
        menuMessage.setHorizontalAlignment(SwingConstants.CENTER);
        menuMessage.setBounds(51, 119, 566, 42);
        add(menuMessage);

        btnJoinGame = new JButton("Join Game");
        btnJoinGame.setForeground(Color.BLACK);
        btnJoinGame.setBounds(397, 196, 174, 70);
        btnJoinGame.setActionCommand("Join Game");
        add(btnJoinGame);

        btnCreateGame = new JButton("Create Game");
        btnCreateGame.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        btnCreateGame.setForeground(Color.BLACK);
        btnCreateGame.setBounds(96, 196, 174, 70);
        btnCreateGame.setActionCommand("Create Game");
        add(btnCreateGame);

        btnDeleteGame = new JButton("Delete Game");
        btnDeleteGame.setForeground(Color.BLACK);
        btnDeleteGame.setBounds(96, 290, 174, 70);
        btnDeleteGame.setActionCommand("Delete Game");
        add(btnDeleteGame);

        btnGetHighscore = new JButton("Get Highscore");
        btnGetHighscore.setForeground(Color.BLACK);
        btnGetHighscore.setBounds(397, 290, 174, 70);
        btnGetHighscore.setActionCommand("Highscore");
        add(btnGetHighscore);

        btnLogOut = new JButton("Log Out");
        btnLogOut.setBackground(Color.WHITE);
        btnLogOut.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        btnLogOut.setForeground(Color.BLACK);
        btnLogOut.setBounds(247, 383, 174, 70);
        btnLogOut.setActionCommand("Log Out");
        add(btnLogOut);

        backGround = new JLabel("");
        backGround.setIcon(new ImageIcon(Login.class.getResource("snakemenu.jpg")));
        backGround.setBounds(0, 0, 668, 495);
        add(backGround);

    }

    public void setMenuMessage(String menuMessage) {
        this.menuMessage.setText(menuMessage);
    }

    public void addACList(ActionListener ac) {
        btnJoinGame.addActionListener(ac);
        btnCreateGame.addActionListener(ac);
        btnDeleteGame.addActionListener(ac);
        btnGetHighscore.addActionListener(ac);
        btnLogOut.addActionListener(ac);
    }

}