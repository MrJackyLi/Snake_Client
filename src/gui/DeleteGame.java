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
public class DeleteGame extends JPanel {

    /**
     * Create the panel
     */

    public DeleteGame(){
        setForeground(Color.GRAY);
        setBackground(Color.LIGHT_GRAY);
        setBounds(100, 100, 668, 395);
        setLayout(null);

        JLabel lblDeleteGame = new JLabel("DELETE GAME");
        lblDeleteGame.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
        lblDeleteGame.setBounds(243, 55, 182, 41);
        add(lblDeleteGame);

        JButton btnBack = new JButton("BACK TO MENU");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnBack.setBounds(260, 306, 147, 41);
        add(btnBack);
    }

}
