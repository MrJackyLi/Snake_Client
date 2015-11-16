package gui;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Jacky on 16/11/15.
 */
public class Highscore extends JPanel {

    /**
     * Create the panel.
     */
    public Highscore(){
            setForeground(Color.GRAY);
            setBackground(Color.LIGHT_GRAY);
            setBounds(100, 100, 668, 395);
            setLayout(null);

        JButton btnBack = new JButton("Back to menu");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnBack.setBounds(260, 306, 147, 41);
        add(btnBack);

    }

}
