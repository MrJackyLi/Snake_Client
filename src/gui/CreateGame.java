package gui;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Created by Jacky on 16/11/15.
 */

public class CreateGame extends JPanel {
    private JLabel lblCreateGame;
    private JButton btnBack;

    /**
     * Create the panel.
     */
    public CreateGame(){
        setForeground(Color.GRAY);
        setBackground(Color.LIGHT_GRAY);
        setBounds(100, 100, 668, 395);
        setLayout(null);

        lblCreateGame = new JLabel("CREATE GAME");
        lblCreateGame.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
        lblCreateGame.setBounds(241, 55, 186, 41);
        add(lblCreateGame);

        btnBack = new JButton("BACK TO MENU");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnBack.setBounds(260, 306, 147, 41);
        add(btnBack);
    }

}
