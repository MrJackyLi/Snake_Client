package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Created by Jacky on 16/11/15.
 */
public class StartGame extends JPanel {

    private JLabel lblStart;
    private JButton btnBack;
    /**
     * Create the panel.
     */
    public StartGame() {
        setForeground(Color.GRAY);
        setBackground(Color.LIGHT_GRAY);
        setBounds(100, 100, 668, 395);
        setLayout(null);

        lblStart = new JLabel("START GAME");
        lblStart.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
        lblStart.setBounds(250, 16, 167, 41);
        add(lblStart);

        btnBack = new JButton("BACK TO MENU");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnBack.setBounds(260, 336, 147, 41);
        add(btnBack);

    }

}
