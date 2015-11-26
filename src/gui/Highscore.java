package gui;

import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Created by Jacky on 16/11/15.
 */
public class Highscore extends JPanel {
    private JLabel lblHighscore;
    private JButton btnBack;
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

    }

        public void actionPerformedBack(ActionListener back) {
        btnBack.addActionListener(back);
    }
}
