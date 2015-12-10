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
     * In this class we will find verify the user, by identifying the user's inputs, by the login-method in the
     * serverconncetion.class by a "PUT" - request - where the path for it will be found.
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

            //Our String we want to send to the serverconnection's login-resource(See the login request in serverConnection)
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

                    if (currentUser.getUsername().equals(usr.getUsername()) && currentUser.getPassword().equals(usr.getPassword())) {
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
     * In this class we will find what single screen's/Panel's values/ressources, through the method called in the
     * serverConnections.class, where the givin path is.
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
                sc.getUserData();
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
     * In this class a user can join a existing game in the database.
     * This is done by get the values, which is set by the user, which we have to put to a method in the serverConncetion.class.
     * Where the method can be found with its "PUT", "GET"-request to the specific path.
     * "PUT" as we have to refresh the server with new values
     * "GET" as we have to get the arraylist of games and a list of user
     */
    private class JoinActionListener implements ActionListener {

        /**
         * As this actionlistener gets called by the run method, it will then execute for this
         * JPanel through the screen(in the run() method)
         * @param e the object of the action event
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            //creating the variable, which will be initialized inside the loop
            //otherwise it will have to create a new object every single time
            //if the variable was created in the loop, and create the object in the loop, we could make return in the loop

            Game gameStart = null;

            //for-statement that makes it possible to repeat the loop until the condition is satisfied.
            //An if-statement within the for-loop to test the condition
            //gameChallenge is the arraylist of the game, which hold these variables,
            //as we want to "receive" our challenge, we have called a method(getChallenge) in the JoinGame,
            //that makes it possible for us to see the challanges, as you choose a game/challenge, we have
            //set the value for a game, "gameStart=game"
            for (Game game : gameChallenge) {
                if (screen.getJoinGame().getChallenge().equals(game.getName())) {
                    gameStart = game;
                }
            }
            //as we get the game's opponent and game, the user can set his/her control in the textfield
            gameStart.getOpponent().setControls(screen.getJoinGame().getTxtJoinMove());

            //as we receive these values, we then this to put these values into a "PUT-request" through the server
            //in the serverconnection.class
            sc.joinGame(gameStart);
            sc.gameStart(gameStart);
            //for-statement that makes it possible to repeat the loop until the condition is satisfied.
            //An if-statement within the for-loop to test the condition
            //As we "PUT-request" from the server, the server have already calculated the winner of the game
            for (User usr : sc.getUserData()) {
                if (usr.getId() == gameStart.getWinner().getId()) {
                    gameStart.getWinner().setUsername(usr.getUsername());
                }
                // As a game is joined, it will bring the user back to the menu screen.
                screen.show(Screen.MENU);
                // At the same time, when the user i referred back to the menu screen, the label menuMessage will be set
                screen.getMenu().setMenuMessage("You have joined a game and you: " + gameStart.getWinner().getId());

            }
        }
    }

    /**
     * An inner class that is called by the run() method and
     * contains the actionlistener when it is called.
     * In this class a user can create a new game to the database.
     * This is done by get the values, which is set by the user, which we have a put method in the serverConncetion.class.
     * Where the method can be found with its "POST", "GET"-request to the specific path.
     * "POST" as we have to set some new values(the controls,mapsize, host, opponent, game name)
     * "GET" as we have to get the arraylist of games and a list of user
     */
    private class CreateActionListener implements ActionListener {

        /**
         * As this actionlistener gets called by the run method, it will then execute for this
         * JPanel through the screen(in the run() method)
         * @param e the object of the action event
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            //Initializing variables in the class
            Gamer host = new Gamer();
            host.setId(currentUser.getId());
            //the controls is being set, by the inputs from the user in the JTextfield.
            host.setControls(screen.getCreateGame().getTxtFMovements());
            System.out.println(host.getId());

            Game game = new Game();
            Gamer opponent = new Gamer();
            game.setHost(host);
            game.setOpponent(opponent);
            //mapsize set
            game.setMapSize(20);
            //the game of the name is set by the user, with its input in the JTextfield.
            game.setName(screen.getCreateGame().getTxtFGameName());

            //for-statement that makes it possible to repeat the loop until the condition is satisfied.
            //An if-statement within the for-loop to test the condition
            //As we want to create a game, we want to set the user's opponent by the user choose in the givin arraylist,
            // it displays the users in the database, through the serverconnection.class.
            //As a "GET-request" to the givin path.
            for (User usr : sc.getUserData()) {
                if (usr.getUsername().equals(screen.getCreateGame().getUser())) {
                    opponent.setId(usr.getId());
                }
            }
            //as all the values are set from the user, we then add the values to the database though the server,
            //with a "POST"-request.
            sc.createGame(game);

            //as we create a game, the user will return to the menu screen.
            //at the same time, a them menumessage-label is set.
            if (currentUser != null) {
                // As a game is create, it will bring the user back to the menu screen.
                screen.show(Screen.MENU);
                // At the same time, when the user i referred back to the menu screen, the label menuMessage will be set
                screen.getMenu().setMenuMessage("The game " + screen.getCreateGame().getTxtFGameName() + " is created ");
            }
        }
    }

    /**
     * An inner class that is called by the run() method and
     * contains the actionlistener when it is called.
     * In this class a user can delete a game to the database.
     * This is done by get the values/game, which is chose by the user, which we have to delete, with a givin method
     * in the serverConncetion.class. In this method, we DELETE-request to the server, with a givin path.
     * "DELETE" as we have to delete a value/resource from the database.
     */
    private class DeleteActionListener implements ActionListener {
        /**
         * As this actionlistener gets called by the run method, it will then execute for this
         * JPanel through the screen(in the run() method)
         * @param e the object of the action event
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            //Initializing variables in the class
            Game game = new Game();

            //for-statement that makes it possible to repeat the loop until the condition is satisfied.
            //An if-statement within the for-loop to test the condition
            //As we want to delete a game, we want see the all games in an arraylist, the user choose in the givin arraylist,
            //it displays the games in the database, through the serverconnection.class.
            //As a "DELETE-request" to the givin path.
            for (Game games : deleteGames) {
                screen.getDeleteGame().getDeleteBox();
                if (games.getName().equals(screen.getDeleteGame().getDeleteBox())) {
                    game = games;
                }
            }
            //An if-statement within the for-loop to test the condition
            //Our String we want to send to the serverconnection's delete-resource(See delete resource in serverConnection)
            String message = sc.deleteGames(game.getGameId());
            if (message.equals("Game was deleted")) {
                // as a game gets deleted, we update the arraylist, by removing the removed resource/value in the
                //arraylist
                screen.getDeleteGame().RemoveGame();
                // As a game is deleted, it will bring the user back to the menu screen.
                screen.show(Screen.MENU);
                // At the same time, when the user i referred back to the menu screen, the label menuMessage will be set
                screen.getMenu().setMenuMessage("You have deleted the game: " + game.getName());
            }

        }
    }

    /**
     * An inner class that is called by the run() method and
     * contains the actionlistener when it is called.
     * In this class a user press the "back to menu" from the JoinGame.class  by its actionlistener, the user will be can delete a game to the database.
     */
    private class JoinActionListenerBack implements ActionListener {

        public void actionPerformed(ActionEvent back) {
            screen.show(Screen.MENU);
        }

    }

    /**
     * An inner class that is called by the run() method and
     * contains the actionlistener when it is called.
     * In this class a user press the "back to menu" from the CreateGame.class  by its actionlistener, the user will be can delete a game to the database.
     */
    private class CreateActionListenerBack implements ActionListener {

        public void actionPerformed(ActionEvent back) {
            screen.show(Screen.MENU);
        }
    }

    /**
     * An inner class that is called by the run() method and
     * contains the actionlistener when it is called.
     * In this class a user press the "back to menu" from the DeleteGame.class  by its actionlistener, the user will be can delete a game to the database.
     */
    private class DeleteActionListenerBack implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            screen.show(Screen.MENU);
        }
    }

    /**
     * An inner class that is called by the run() method and
     * contains the actionlistener when it is called.
     * In this class a user press the "back to menu" from the Highscore.class  by its actionlistener, the user will be can delete a game to the database.
     */
    private class HighscoreActionListenerBack implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            screen.show(Screen.MENU);
        }
    }
}