package gui;

/**
 * Created by Jacky on 16/11/15.
 * This class (Highscore class) contains all needed inputs and outputs for the class' GUI.
 */

/**
 * Import all needed imports for this panel/class.
 */

import sdk.Score;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Highscore extends JPanel {
    private JButton btnBack;
    private JTable highscoreTable;
    private JLabel backGround;

    /**
     * Create the panel.
     */
    public Highscore() {
        setForeground(Color.GRAY);
        setBackground(Color.LIGHT_GRAY);
        setBounds(100, 100, 668, 495);
        setLayout(null);

        btnBack = new JButton("BACK TO MENU");
        btnBack.setBounds(247, 389, 174, 70);
        btnBack.setForeground(Color.black);
        btnBack.setActionCommand("BACK TO MENU");
        add(btnBack);

        highscoreTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(highscoreTable);
        scrollPane.setBounds(122, 139, 424, 199);
        add(scrollPane);

        //background picture for this class' screen.
        backGround = new JLabel("");
        backGround.setIcon(new ImageIcon(Login.class.getResource("snakehigh.jpg")));
        backGround.setBounds(0, 0, 668, 495);
        add(backGround);

    }

    /**
     * A method that sets the JTable from the HighscoreTable.class and contains an arraylist from Score.
     * @param highscores
     */
    public void setHighscoreTableModel(ArrayList<Score> highscores) {
        HighscoreTable highscoreTableModel = new HighscoreTable(highscores);
        highscoreTable.setModel(highscoreTableModel);
    }

    /**
     * A method that adds an actionlistener for the back-button
     * @param back
     */
    public void actionPerformedBack(ActionListener back) {
        btnBack.addActionListener(back);
    }
}