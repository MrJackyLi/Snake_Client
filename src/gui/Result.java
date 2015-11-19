package gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Created by Jacky on 16/11/15.
 */

public class Result extends JPanel {

    private JLabel lblResult;
    private JButton btnBack;
    /**
     * Create the panel.
     */
    public Result() {
        setForeground(Color.GRAY);
        setBackground(Color.LIGHT_GRAY);
        setBounds(100, 100, 668, 395);
        setLayout(null);

        lblResult = new JLabel("RESULT");
        lblResult.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
        lblResult.setBounds(282, 55, 103, 41);
        add(lblResult);

        btnBack = new JButton("BACK TO MENU");
        btnBack.setBounds(260, 306, 147, 41);
        btnBack.setActionCommand("BACK TO MENU");
        add(btnBack);

    }
    public void actionPerformedBack(ActionListener back) {
        btnBack.addActionListener(back);
    }

}
