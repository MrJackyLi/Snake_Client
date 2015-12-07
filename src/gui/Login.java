package gui;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

/**
 * Created by Jacky on 12/11/15.
 */
public class Login extends JPanel {
    private JTextField txtUsername;
    private JPasswordField txtTypePassword;
    private JLabel errorMessage;
    private JLabel lblUser;
    private JLabel lblPass;
    private JLabel backGround;
    private JButton btnLogin;

    /**
     * Create the panel.
     */
    public Login() {
        setForeground(Color.GRAY);
        setBackground(Color.LIGHT_GRAY);
        setBounds(100, 100, 668, 495);
        setLayout(null);


        lblUser = new JLabel("USERNAME:");
        lblUser.setForeground(Color.CYAN);
        lblUser.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        lblUser.setBounds(66, 406, 120, 16);
        add(lblUser);

        lblPass = new JLabel("PASSWORD:");
        lblPass.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        lblPass.setForeground(Color.CYAN);
        lblPass.setBounds(271, 406, 120, 16);
        add(lblPass);

        txtUsername = new JTextField();
        txtUsername.setToolTipText("Type your username here!");
        txtUsername.setBounds(32, 424, 177, 48);
        add(txtUsername);
        txtUsername.setColumns(10);

        txtTypePassword = new JPasswordField();
        txtTypePassword.setToolTipText("Type your password here!");
        txtTypePassword.setColumns(10);
        txtTypePassword.setBounds(239, 424, 177, 48);
        add(txtTypePassword);

        errorMessage = new JLabel("");
        errorMessage.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        errorMessage.setHorizontalAlignment(SwingConstants.CENTER);
        errorMessage.setForeground(Color.red);
        errorMessage.setBounds(18, 368, 410, 35);
        add(errorMessage);

        btnLogin = new JButton("LOGIN");
        btnLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        btnLogin.setBackground(Color.WHITE);
        btnLogin.setForeground(Color.BLACK);
        btnLogin.setBounds(471, 411, 120, 70);
        btnLogin.setActionCommand("Login");
        add(btnLogin);

        backGround = new JLabel("");
        backGround.setIcon(new ImageIcon(Login.class.getResource("snake.jpg")));
        backGround.setBounds(0, 0, 668, 495);
        add(backGround);
    }

    public String getTxtUsername() {
        return txtUsername.getText();
    }

    public String getTxtTypePassword() {

        return String.valueOf(txtTypePassword.getPassword());
    }

    public void setErrorMessage(String errorMessage){
        this.errorMessage.setText(errorMessage);
    }

    public void addActionListener(ActionListener l) {
        btnLogin.addActionListener(l);
    }

    public void ClearTextFieldLogin()
    {
        txtTypePassword.setText("");
        txtUsername.setText("");
    }
}
