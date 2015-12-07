package gui;

import sdk.Score;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Jacky on 16/11/15.
 */
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
        btnBack.setForeground(Color.cyan);
        btnBack.setActionCommand("BACK TO MENU");
        add(btnBack);

        highscoreTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(highscoreTable);
        scrollPane.setBounds(122, 139, 424, 199);
        add(scrollPane);

        backGround = new JLabel("");
        backGround.setIcon(new ImageIcon(Login.class.getResource("snakehigh.jpg")));
        backGround.setBounds(0, 0, 668, 495);
        add(backGround);

    }

    public void setHighscoreTableModel(ArrayList<Score> highscores) {
        HighscoreTable highscoreTableModel = new HighscoreTable(highscores);
        highscoreTable.setModel(highscoreTableModel);
    }

    public void actionPerformedBack(ActionListener back) {
        btnBack.addActionListener(back);
    }
}
