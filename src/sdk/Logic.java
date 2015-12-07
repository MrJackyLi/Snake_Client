
/**
 * Created by Jacky on 10/11/15.
 */

package sdk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import gui.*;

public class Logic {

    private Screen screen;
    private ServerConnection sc;
    private User currentUser;
    private ArrayList<Game> gameChallenge;
    private ArrayList<Game> deleteGames;

    public Logic() {
        screen = new Screen();
        screen.setVisible(true);
        sc = new ServerConnection();
        currentUser = new User();
    }

    public void run() {
        screen.getLogin().addActionListener(
                new LoginActionListener());
        screen.getMenu().addACList(
                new MenuActionListener());
        screen.getJoinGame().actionPerformedBack(
                new JoinActionListenerBack());
        screen.getBtnJoinGame().actionListenerJoin(
                new JoinActionListener());
        screen.getCreateGame().actionPerformedBack(
                new CreateActionListenerBack());
        screen.getBtnCreateGame().addActionCreate(
                new CreateActionListener() );
        screen.getDeleteGame().actionPerformedBack(
                new DeleteActionListenerBack());
        screen.getBtnDeleteGame().addActionDelete(
                new DeleteActionListener());
        screen.getHighscore().actionPerformedBack(
                new HighscoreActionListenerBack());
        screen.show(Screen.LOGIN);
    }


    private boolean isEmpty(String text) {
        //trim sørger for at der ikke er tomme spaces
        text = text.trim();

        if (text.equals("") || text.length() < 1 || text == null) {
            return true;
        } else {
            return false;
        }
    }


    private class LoginActionListener implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {

                currentUser.setUsername(screen.getLogin().getTxtUsername());
                currentUser.setPassword(screen.getLogin().getTxtTypePassword());

                String message = sc.login(currentUser);
                if(isEmpty(currentUser.getUsername()) || isEmpty(currentUser.getPassword())){
                    screen.getLogin().setErrorMessage("Please type username/password!");
                }

            else{
                screen.getLogin().setErrorMessage("Wrong username/password!");

                for(User usr : sc.getUserData()){
                    System.out.println(usr.getUsername() + " " + usr.getId());
                    if(currentUser.equals(usr.getUsername()) && currentUser.equals(usr.getPassword()))     {
                        currentUser = usr;
                    }

                    else if(message.equals("Login successful")){
                        screen.show(Screen.MENU);


                    }


                }
                }

            }

    }

    private class MenuActionListener implements ActionListener{

        public void actionPerformed(ActionEvent e){
            String actCom = e.getActionCommand();
            if(actCom.equals("Join Game")) {
                screen.show(Screen.JOINGAME);
                gameChallenge = sc.getGameChallenge(currentUser.getId());
                for (Game game : gameChallenge)
                    game.getGameId();
                    screen.getJoinGame().setGameChallenge(gameChallenge);
                System.out.println(gameChallenge);

            }
            else if(actCom.equals("Create Game")){
                screen.show(Screen.CREATEGAME);
                screen.getCreateGame().addUser(sc.getUserData());
            }
            else if(actCom.equals("Delete Game")){
                screen.show(Screen.DELETEGAME);
                deleteGames = sc.getDeleteGame(currentUser.getId());
                screen.getDeleteGame().setDeleteBox(deleteGames);

                System.out.println(deleteGames);


            }
            else if(actCom.equals("Highscore")){
                screen.show(Screen.HIGHSCORE);
                screen.getHighscore().setHighscoreTableModel(sc.getHighscores());
            }
            else{
                screen.show(Screen.LOGIN);
                screen.getLogin().setErrorMessage("");
            }
        }
    }

    private class JoinActionListener implements ActionListener{

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
            }
        }}

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
                    System.out.println(usr.getId());
                }
            }
            sc.createGame(game);

            if (currentUser != null) {

                screen.show(Screen.MENU);
            }
        }
    }

    private class DeleteActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Game game = new Game();


            for (Game games : deleteGames) {

                //if(screen.getDeleteGame().getDeleteBox().equals(games.getGameId())){


                if (games.getName().equals(screen.getDeleteGame().getDeleteBox())) {
                    game = games;

                }

                String message = sc.deleteGames(game.getGameId());
                if (message.equals("Game was deleted")) {
                    screen.getDeleteGame().RemoveGame();
                }
            }
        }
        }

    private class JoinActionListenerBack implements ActionListener{

        public void actionPerformed(ActionEvent back){
            screen.show(Screen.MENU);
        }

    }

    private class CreateActionListenerBack implements ActionListener{

        public void actionPerformed(ActionEvent back){
            screen.show(Screen.MENU);
        }
    }

    private class DeleteActionListenerBack implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            screen.show(Screen.MENU);
        }
    }

    private class HighscoreActionListenerBack implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            screen.show(Screen.MENU);
        }
    }
}