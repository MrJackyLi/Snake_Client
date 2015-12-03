
/**
 * Created by Jacky on 10/11/15.
 */

package sdk;

import com.google.gson.Gson;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import gui.*;

public class Logic {

    private Screen screen;
    private ServerConnection sc;
    private User currentUser;
    private ArrayList<Game> gameChallenge;

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

        public void actionPerformed(ActionEvent e) {
            String actCom = e.getActionCommand();
            if (actCom.equals("Login")) {

                String userField = screen.getLogin().getTxtUsername();
                String passField = screen.getLogin().getTxtTypePassword().getText();



                if (isEmpty(userField) || isEmpty(passField)) {
                    screen.getLogin().setErrorMessage("Please type username and password!");
                } else {
                    screen.getLogin().setErrorMessage("Wrong username or password");

                    //User usr = new User();
                    currentUser = sc.login(userField, passField);

                    for(User usr: sc.userData()) {
                        System.out.println(usr.getUsername()+" "+usr.getId());
                        if(usr.getUsername().equals(screen.getLogin().getTxtUsername())){
                            currentUser = usr;

                        }

                    }

                        if (currentUser != null) {

                            screen.show(Screen.MENU);

                        }
                    System.out.println(currentUser.getId());
                }
            }
        }
    }


    private class MenuActionListener implements ActionListener{

        public void actionPerformed(ActionEvent e){
            String actCom = e.getActionCommand();
            if(actCom.equals("Join Game")) {
                screen.show(Screen.JOINGAME);



                gameChallenge = sc.gameChallenge(currentUser.getId());

                //for (Game g : gameChallenge)

                    //g.getGameId();
                    screen.getJoinGame().setGame(gameChallenge);



                System.out.println(gameChallenge);

            }
            else if(actCom.equals("Create Game")){
                screen.show(Screen.CREATEGAME);
                screen.getCreateGame().addUser(sc.userData());
            }
            else if(actCom.equals("Delete Game")){
                screen.show(Screen.DELETEGAME);
            }
            else if(actCom.equals("Highscore")){
                screen.show(Screen.HIGHSCORE);
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
            String actCom = e.getActionCommand();
            if (actCom.equals("Join Game")){

            }
            else if(e.getSource() == screen.getJoinGame().getBtnJoinGame()){

                Game gameStart = null;

                for (Game game : gameChallenge){
                    if(screen.getJoinGame().getChallenge().equals(game.getName())){
                        gameStart = game;
                    }
                }
                gameStart.getOpponent().setControls(screen.getJoinGame().getTxtJoinMove());

                sc.joinGame(gameStart);
                sc.gameStart(gameStart);
                for (User usr : sc.userData()){
                    if(usr.getId()==gameStart.getWinner().getId())
                    {
                        gameStart.getWinner().setUsername(usr.getUsername());
                    }
                }

            }
        }
    }

    private class CreateActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String actCom = e.getActionCommand();
            if (actCom.equals("Create Game")) {
               // screen.getCreateGame().addUser(sc.userData());
            }
             else if(e.getSource() == screen.getCreateGame().getBtnCreateGame()){
                Gamer host = new Gamer();
                host.setId(currentUser.getId());
                host.setControls(screen.getCreateGame().getTxtFMovements());

                Game game = new Game();
                Gamer opponent = new Gamer();
                game.setHost(host);
                game.setOpponent(opponent);
                game.setMapSize(20);
                game.setName(screen.getCreateGame().getTxtFGameName());


                for (User usr : sc.userData()) {
                    if (usr.getUsername().equals(screen.getCreateGame().getUser())) {
                        opponent.setId(usr.getId());
                        System.out.println(usr.getId());
                    }
                }

                sc.createGame(game);
            }
            if (currentUser != null) {

                screen.show(Screen.MENU);
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