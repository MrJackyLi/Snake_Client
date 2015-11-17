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
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Screen frame = new Screen();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Screen() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 668, 395);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        contentPane.setLayout(new CardLayout(0, 0));

        login = new Login();
            contentPane.add(login, LOGIN);

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
