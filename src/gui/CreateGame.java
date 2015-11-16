package gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Created by Jacky on 16/11/15.
 */

public class CreateGame extends JPanel {

    /**
     * Create the panel.
     */
    public CreateGame(){
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
