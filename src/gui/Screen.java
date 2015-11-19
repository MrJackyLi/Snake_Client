package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;

import gui.Login;

/**
 * Created by Jacky on 12/11/15.
 */
public class Screen extends JFrame {

    public static final String LOGIN = "Login";
    public static final String MENU = "Menu";

    private JPanel contentPane;
    private Login login;
    private Menu menu;
    private CreateGame creategame;
    private DeleteGame deletegame;
    private Highscore highscore;
    private Result result;
    private StartGame startgame;


    private CardLayout c;

    /**
     * Create the frame.
     */
    public Screen() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 668, 495);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        contentPane.setLayout(new CardLayout(0, 0));

        login = new Login();
            contentPane.add(login, LOGIN);

        menu = new Menu();
            contentPane.add(menu, MENU);

        c = (CardLayout) getContentPane().getLayout();
    }

    public void show(String panel) {
        c.show(contentPane, panel);
    }

    public Login getLogin(){
        return login;
    }

    public Menu getMenu() {
        return menu;
    }


}
