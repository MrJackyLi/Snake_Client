package gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;


/**
 * Created by Jacky on 12/11/15.
 */
public class Screen extends JFrame {

    public static final String LOGIN = "Login";
    public static final String MENU = "Menu";
    public static final String JOINGAME = "Join Game";
    public static final String CREATEGAME = "Create Game";
    public static final String DELETEGAME = "Delete Game";
    public static final String HIGHSCORE = "HighScore";


    private JPanel contentPane;
    private Login login;
    private Menu menu;
    private JoinGame joingame;
    private CreateGame creategame;
    private DeleteGame deletegame;
    private Highscore highscore;


    private CardLayout c;

    /**
     * Create the frame.
     */
    public Screen() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 668, 517);
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        contentPane.setLayout(new CardLayout(0, 0));

        login = new Login();
        contentPane.add(login, LOGIN);

        menu = new Menu();
        contentPane.add(menu, MENU);

        joingame = new JoinGame();
        contentPane.add(joingame, JOINGAME);

        creategame = new CreateGame();
        contentPane.add(creategame, CREATEGAME);

        deletegame = new DeleteGame();
        contentPane.add(deletegame, DELETEGAME);

        highscore = new Highscore();
        contentPane.add(highscore, HIGHSCORE);

        c = (CardLayout) getContentPane().getLayout();
    }

    public boolean show(String panel) {
        c.show(contentPane, panel);
        return false;
    }

    public Login getLogin() {
        return login;
    }

    public Menu getMenu() {
        return menu;
    }

    public JoinGame getJoinGame() {
        return joingame;
    }

    public JoinGame getBtnJoinGame() {
        return joingame;
    }

    public CreateGame getCreateGame() {
        return creategame;
    }

    public CreateGame getBtnCreateGame() {
        return creategame;
    }

    public DeleteGame getDeleteGame() {
        return deletegame;
    }

    public DeleteGame getBtnDeleteGame() {
        return deletegame;
    }

    public Highscore getHighscore() {
        return highscore;
    }

}