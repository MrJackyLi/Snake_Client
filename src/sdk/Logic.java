
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
    private ServerConnection serverConnection;
    private User user;

    public Logic(){
        screen = new Screen();
        screen.setVisible(true);
        serverConnection = new ServerConnection();
        user = new User();
    }

        public void run(){
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
            screen.getResult().actionPerformedBack(
                    new ResultActionListenerBack());

            screen.show(Screen.LOGIN);
        }



   private boolean isEmpty(String text){
        //trim sørger for at der ikke er tomme spaces
        text = text.trim();

        if (text.equals("") || text.length() < 1 || text == null){
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
                String json = new Gson().toJson(user);

                if (isEmpty(userField) || isEmpty(passField)){
                    screen.getLogin().setErrorMessage("Please type username and password!");
                }
                else {
                        screen.getLogin().setErrorMessage("Wrong username or password");
                    //tjek login
                    for (User user : serverConnection.) {

                        if (userField.equals(user.getUsername())
                                && passField.equals(user.getPassword())) {

                            else
                            screen.show(Screen.MENU);
                        }
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
            else if(actCom.equals("Result")){
                screen.show(Screen.RESULT);
            }
            else{
                screen.show(Screen.LOGIN);
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

    private class ResultActionListenerBack implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            screen.show(Screen.MENU);
        }
    }

}






