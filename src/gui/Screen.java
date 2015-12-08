package gui;

/**
 * Created by Jacky on 12/11/15.
 * This class (Screen.class) contains all needed inputs and outputs for the class' GUI.
 */

/**
 * Import all needed imports for this panel/class.
 */

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;

/**
 * Extends JFrame which contains alle JPanel's contentpane
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

    //creates the frame for the application
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

    /**
     *This methods is used for showing the specific panel
     * @param panel
     * @return false
     */
    public boolean show(String panel) {
        c.show(contentPane, panel);
        return false;
    }

    /**
     * A method that gets the Login(JPanel)
     * @return login
     */
    public Login getLogin() {
        return login;
    }

    /**
     * A method that gets the Menu(JPanel)
     * @return menu
     */
    public Menu getMenu() {
        return menu;
    }

    /**
     * A method that gets the JoinGame(JPanel)
     * @return joingame
     */
    public JoinGame getJoinGame() {
        return joingame;
    }

    /**
     * A method that gets the CreateGame(JPanel)
     * @return creategame
     */
    public CreateGame getCreateGame() {
        return creategame;
    }

    /**
     * A method that gets the DeleteGame(JPanel)
     * @return deletegame
     */
    public DeleteGame getDeleteGame() {
        return deletegame;
    }

    /**
     * A method that gets the Highscore(JPanel)
     * @return highscore
     */
    public Highscore getHighscore() {
        return highscore;
    }

}