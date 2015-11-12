package gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Canvas;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Created by Jacky on 12/11/15.
 */
public class Login extends JPanel {
    private JTextField txtUsername;
    private JTextField txtTypePassword;

    /**
     * Create the panel.
     */
    public Login() {
        setForeground(Color.GRAY);
        setBackground(Color.LIGHT_GRAY);
        setBounds(100, 100, 668, 395);
        setLayout(null);

        JLabel screenLabel = new JLabel("SNAKE GAME");
        screenLabel.setBounds(234, 37, 177, 41);
        screenLabel.setForeground(Color.BLACK);
        screenLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        screenLabel.setBackground(Color.BLACK);
        add(screenLabel);

        txtUsername = new JTextField();
        txtUsername.setText("Type Username");
        txtUsername.setBounds(234, 153, 177, 48);
        add(txtUsername);
        txtUsername.setColumns(10);

        txtTypePassword = new JTextField();
        txtTypePassword.setText("Type Password");
        txtTypePassword.setColumns(10);
        txtTypePassword.setBounds(234, 226, 177, 48);
        add(txtTypePassword);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnLogin.setBounds(249, 306, 147, 41);
        add(btnLogin);


    }
}
