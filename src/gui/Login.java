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
    private JLabel errorMessage;
    private JLabel loginLabel;
    private JButton btnLogin;

    /**
     * Create the panel.
     */
    public Login() {
        setForeground(Color.GRAY);
        setBackground(Color.LIGHT_GRAY);
        setBounds(100, 100, 668, 395);
        setLayout(null);

        loginLabel = new JLabel("SNAKE GAME");
        loginLabel.setBounds(245, 37, 177, 41);
        loginLabel.setForeground(Color.BLACK);
        loginLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        loginLabel.setBackground(Color.BLACK);
        add(loginLabel);

        txtUsername = new JTextField();
        txtUsername.setText("Type Username");
        txtUsername.setBounds(245, 153, 177, 48);
        add(txtUsername);
        txtUsername.setColumns(10);

        txtTypePassword = new JTextField();
        txtTypePassword.setText("Type Password");
        txtTypePassword.setColumns(10);
        txtTypePassword.setBounds(245, 226, 177, 48);
        add(txtTypePassword);

        errorMessage = new JLabel("");
        errorMessage.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        errorMessage.setBounds(175, 90, 318, 51);
        add(errorMessage);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(260, 306, 147, 41);
        btnLogin.setActionCommand("Login");
        add(btnLogin);
    }

    public JTextField getTxtUsername() {
        return txtUsername;
    }

    public JTextField getTxtTypePassword() {
        return txtTypePassword;
    }

    public void setErrorMessage(String errorMessage){
        this.errorMessage.setText(errorMessage);
    }

    public JLabel getErrorMessage(){
        return errorMessage;
    }

    public JButton getBtnLogin()
    {
        return btnLogin;
    }

    public void addActionListener(ActionListener l) {
        btnLogin.addActionListener(l);
    }
}
