package logic;

/**
 * Created by Jacky on 10/11/15.
 * The logic.class handles the client's/application's logic.
 * It connects/interact between the GUI(frontend) and SDK(backend)
 * The logic handles every single screen/JPanel's function, and a user's actions/inputs by the SDK.
 * In return from the SDK it returns events and output to the user
 * Contains an inner class of the JPanels
 */

//All needed imports to the the class.
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//Imported the gui.package and sdk.package as we interact with those packages.
import gui.*;
import sdk.*;

public class Logic {

    //Declaration of variables in the class
    private Screen screen;
    private ServerConnection sc;
    private User currentUser;
    private ArrayList<Game> gameChallenge;
    private ArrayList<Game> deleteGames;
    private ArrayList<Score> highScore;

    //Constructor of the class
    public Logic() {
        //Initializing variables in the class
        screen = new Screen();
        screen.setVisible(true);
        sc = new ServerConnection();
        currentUser = new User();
    }

    /**
     * The method to execute the client/application. It runs every interface, and
     * updates every JPanel when an actionlistener is called.
     */
    public void run() {
        screen.getLogin().addActionListener(
                new LoginActionListener());
        screen.getMenu().addACList(
                new MenuActionListener());
        screen.getJoinGame().actionPerformedBack(
                new JoinActionListenerBack());
        screen.getJoinGame().actionListenerJoin(
                new JoinActionListener());
        screen.getCreateGame().actionPerformedBack(
                new CreateActionListenerBack());
        screen.getCreateGame().addActionCreate(
                new CreateActionListener());
        screen.getDeleteGame().actionPerformedBack(
                new DeleteActionListenerBack());
        screen.getDeleteGame().addActionDelete(
                new DeleteActionListener());
        screen.getHighscore().actionPerformedBack(
                new HighscoreActionListenerBack());
        screen.show(Screen.LOGIN);
    }


    /**
     * A method that checks whether if a text is empty or not by an if else statement.
     * if-else statement; that test conditions
     * It returns true if the text is empty, if not it returns false
     * @param text checks the if text is empty or not
     * @return true or false
     */
    private boolean isEmpty(String text) {
        //the trim makes sure that there isn't any empty "spaces"
        text = text.trim();
        //if-else statement; that test conditions
        if (text.equals("") || text.length() < 1 || text == null) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * An inner class that is called by the run() method and
     * contains the actionlistener when it is called.
     */
    private class LoginActionListener implements ActionListener {
        /**
         * As this actionlistner gets called by the run method, it will then execute for this
         * JPanel through the screen(in the run() method)
         * @param e the object of the action event
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            //As we have a list of users, we then have to identify the user with its password
            //Through the currentuser(User.class) we have the variables to setUsername and setPassword
            //As we have them we can get the username and password by our JTextfield
            //in Login panel. By that we can compare them later on.
            currentUser.setUsername(screen.getLogin().getTxtUsername());
            currentUser.setPassword(screen.getLogin().getTxtTypePassword());

            //Our String we want to send to the serverconnection's login-method(See login method in serverConnection)
            String message = sc.login(currentUser);
            //if-else statement; that tests conditions
            //As we have the isEmpty method, we checks if the JTextfields are filled.
            if (isEmpty(currentUser.getUsername()) || isEmpty(currentUser.getPassword())) {
                screen.getLogin().setErrorMessage("Please type username/password!");
            } else {
                screen.getLogin().setErrorMessage("Wrong username/password!");

                //for-statement that makes it possible to repeat the loop until the condition is satisfied.
                //An if-else within the for-loop to test the condition
                //As we receive the user's input of username and password, we then make a
                //comparison of it according to the arraylist/database, through the path in the serverconnection.
                //If correct then welcomes the user
                for (User usr : sc.getUserData()) {
                    if (currentUser.equals(usr.getUsername()) && currentUser.equals(usr.getPassword())) {
                        currentUser = usr;
                    } else if (message.equals("Login successful")) {
                        screen.show(Screen.MENU);
                        screen.getMenu().setMenuMessage("Welcome " + currentUser.getUsername() + " please choose an option!");

                    }
                }
            }

        }

    }

    /**
     * An inner class that is called by the run() method and
     * contains the actionlistener when it is called.
     */

    private class MenuActionListener implements ActionListener {
        /**
         * As this actionlistner gets called by the run method, it will then execute for this
         * JPanel through the screen(in the run() method)
         * @param e the object of the action event
         */
        public void actionPerformed(ActionEvent e) {
            //getActionCommand, the given Strings that represent the action command.
            //An if-else within the for-loop to test the condition
            String actCom = e.getActionCommand();
            //As the String equals the givin String, it will show the following screen/JPanel.
            if (actCom.equals("Join Game")) {
                screen.show(Screen.JOINGAME);
                //A method which is called in the JoinGame.class to clear the Textfield in class.
                screen.getJoinGame().ClearTextfieldJoin();
                //initializing the arraylist from the serverconnection.class
                gameChallenge = sc.getGameChallenge(currentUser.getId());
                //for-statement that makes it possible to repeat the loop until the condition is satisfied,
                //as we want to "update/refresh" our arraylist in the panel.
                for (Game game : gameChallenge)
                    game.getGameId();
                screen.getJoinGame().setGameChallenge(gameChallenge);
            }
            //As the String equals the givin String, it will show the following screen/JPanel.
            else if (actCom.equals("Create Game")) {
                screen.show(Screen.CREATEGAME);
                //A method which is called in the CreateGame.class to clear the Textfield in class.
                screen.getCreateGame().ClearTextFieldCreate();
                //makes sure our screen update/refresh the arraylist of users.
                screen.getCreateGame().addUser(sc.getUserData());
            }
            //As the String equals the givin String, it will show the following screen/JPanel.
            else if (actCom.equals("Delete Game")) {
                screen.show(Screen.DELETEGAME);
                //initializing the arraylist from the serverconnection.class
                deleteGames = sc.getDeleteGame(currentUser.getId());
                //as we want to "update/refresh" our arraylist in the panel.
                screen.getDeleteGame().setDeleteBox(deleteGames);
            }
            //As the String equals the givin String, it will show the following screen/JPanel.
            else if (actCom.equals("Highscore")) {
                screen.show(Screen.HIGHSCORE);
                //initializing the arraylist from the serverconnection.class
                highScore = sc.getHighscores();
                //as we want to "update/refresh" our arraylist in the panel.
                screen.getHighscore().setHighscoreTableModel(highScore);
            }
            //As the String equals the givin String, it will show the following screen/JPanel.
            //If an user choose to log-out, it will then show the login panel
            else {
                screen.show(Screen.LOGIN);
                // sets the error-label in the login to empty
                screen.getLogin().setErrorMessage("");
                //A method which is called in the Login.class to clear the Textfield in class.
                screen.getLogin().ClearTextFieldLogin();
            }
        }
    }

    /**
     * An inner class that is called by the run() method and
     * contains the actionlistener when it is called.
     */
    private class JoinActionListener implements ActionListener {

        /**
         * As this actionlistener gets called by the run method, it will then execute for this
         * JPanel through the screen(in the run() method)
         * @param e the object of the action event
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            Game gameStart = null;

            for (Game game : gameChallenge) {
                if (screen.getJoinGame().getChallenge().equals(game.getName())) {
                    gameStart = game;
                }
            }
            gameStart.getOpponent().setControls(screen.getJoinGame().getTxtJoinMove());

            sc.joinGame(gameStart);
            sc.gameStart(gameStart);
            for (User usr : sc.getUserData()) {
                if (usr.getId() == gameStart.getWinner().getId()) {
                    gameStart.getWinner().setUsername(usr.getUsername());

                }
                screen.show(Screen.MENU);
                screen.getMenu().setMenuMessage("You have joined a game and you: " + gameStart.getWinner().getId());

            }
        }
    }

    private class CreateActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Gamer host = new Gamer();
            host.setId(currentUser.getId());
            host.setControls(screen.getCreateGame().getTxtFMovements());

            Game game = new Game();
            Gamer opponent = new Gamer();
            game.setHost(host);
            game.setOpponent(opponent);
            game.setMapSize(20);
            game.setName(screen.getCreateGame().getTxtFGameName());


            for (User usr : sc.getUserData()) {
                if (usr.getUsername().equals(screen.getCreateGame().getUser())) {
                    opponent.setId(usr.getId());
                }
            }
            sc.createGame(game);

            if (currentUser != null) {

                screen.show(Screen.MENU);
                screen.getMenu().setMenuMessage("The game " + screen.getCreateGame().getTxtFGameName() + " is created ");
            }
        }
    }

    private class DeleteActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Game game = new Game();

            for (Game games : deleteGames) {
                screen.getDeleteGame().getDeleteBox();
                if (games.getName().equals(screen.getDeleteGame().getDeleteBox())) {
                    game = games;

                }
            }
            String message = sc.deleteGames(game.getGameId());
            if (message.equals("Game was deleted")) {
                screen.getDeleteGame().RemoveGame();
                screen.show(Screen.MENU);
                screen.getMenu().setMenuMessage("You have deleted the game: " + game.getName());
            }

        }
    }

    private class JoinActionListenerBack implements ActionListener {

        public void actionPerformed(ActionEvent back) {
            screen.show(Screen.MENU);
        }

    }

    private class CreateActionListenerBack implements ActionListener {

        public void actionPerformed(ActionEvent back) {
            screen.show(Screen.MENU);
        }
    }

    private class DeleteActionListenerBack implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            screen.show(Screen.MENU);
        }
    }

    private class HighscoreActionListenerBack implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            screen.show(Screen.MENU);
        }
    }
}