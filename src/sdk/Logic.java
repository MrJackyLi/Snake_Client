
/**
 * Created by Jacky on 10/11/15.
 */

package sdk;

import com.google.gson.Gson;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.*;

public class Logic {

    private Screen screen;
    private ServerConnection sc;
    private User currentUser;

    public Logic() {
        screen = new Screen();
        screen.setVisible(true);
        sc = new ServerConnection();
    }

    public void run() {
        screen.getLogin().addActionListener(
                new LoginActionListener());
        screen.getMenu().addACList(
                new MenuActionListener());
        screen.getJoinGame().actionPerformedBack(
                new JoinActionListenerBack());
        screen.getCreateGame().actionPerformedBack(
                new CreateActionListenerBack());
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

                String userField = screen.getLogin().getTxtUsername().getText();
                String passField = screen.getLogin().getTxtTypePassword().getText();


                if (isEmpty(userField) || isEmpty(passField)) {
                    screen.getLogin().setErrorMessage("Please type username and password!");
                } else {
                    screen.getLogin().setErrorMessage("Wrong username or password");

                    currentUser = new User();
                    //User usr = new User();
                    currentUser = sc.login(userField, passField);

                    //tjek login
                  //  if (userField.equals(usr.getUsername()) && passField.equals(usr.getPassword())) {

                        if (currentUser != null) {
                            screen.show(Screen.MENU);
                        }

                }
            }
        }
    }


    private class MenuActionListener implements ActionListener{

        public void actionPerformed(ActionEvent e){
            String actCom = e.getActionCommand();
            if(actCom.equals("Join Game")){
                screen.show(Screen.JOINGAME);
            }
            else if(actCom.equals("Create Game")){
                screen.show(Screen.CREATEGAME);
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

    private class CreateActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == screen.getCreateGame().getBtnCreateGame()){
                Game game = new Game();
                Gamer host = new Gamer();
                Gamer opponent = new Gamer();

                game.setHost(host);
                game.setOpponent(opponent);
                game.setMapSize(500);

                host.setId(currentUser.getId());
                game.setName(screen.getCreateGame().getTxtFGameName());
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