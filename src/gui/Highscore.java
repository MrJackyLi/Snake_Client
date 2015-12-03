package gui;

import sdk.Score;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * Created by Jacky on 16/11/15.
 */
public class Highscore extends JPanel {
    private JLabel lblHighscore;
    private JButton btnBack;
    private JTable highscoreTable;

    /**
     * Create the panel.
     */
    public Highscore(){
        setForeground(Color.GRAY);
        setBackground(Color.LIGHT_GRAY);
        setBounds(100, 100, 668, 395);
        setLayout(null);

        lblHighscore = new JLabel("HIGHSCORE");
        lblHighscore.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
        lblHighscore.setBounds(255, 55, 158, 41);
        add(lblHighscore);

        btnBack = new JButton("BACK TO MENU");
        btnBack.setBounds(260, 354, 147, 41);
        btnBack.setActionCommand("BACK TO MENU");
        add(btnBack);
//highscoretable inside the scrollpane

        highscoreTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(highscoreTable);
        scrollPane.setBounds(126, 95, 424, 199);
        add(scrollPane);

    }

    public void setHighscoreTableModel(ArrayList<Score> highscores){
        HighscoreTable highscoreTableModel = new HighscoreTable(highscores);
        highscoreTable.setModel(highscoreTableModel);
    }

        public void actionPerformedBack(ActionListener back) {
        btnBack.addActionListener(back);
    }
}
