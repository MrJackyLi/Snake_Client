
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

    public Logic(){
        screen = new Screen();
        screen.setVisible(true);
    }

        public void run(){
            screen.getLogin().addActionListener(
                    new LoginActionListener());
            screen.getMenu().addACList(
                    new MenuActionListener());
            screen.getStartGame().actionPerformedBack(
                    new StartActionListenerBack());
            screen.show(Screen.LOGIN);
        }

   /* private boolean isEmpty(String text){
        //trim sørger for at der ikke er tomme spaces
        text = text.trim();

        if (text.equals("") || text.length() < 1 || text == null){
            return true;
        } else {
            return false;
        }
    }*/

    private class LoginActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String actCom = e.getActionCommand();
            if (actCom.equals("Login")) {
                screen.show(Screen.MENU);
            }
        }
    }

    private class MenuActionListener implements ActionListener{

        public void actionPerformed(ActionEvent e){
            String actCom = e.getActionCommand();
            if(actCom.equals("Start Game")){
                screen.show(Screen.STARTGAME);
            }
        }
    }

    private class StartActionListenerBack implements ActionListener{

        public void actionPerformed(ActionEvent back){
            screen.show(Screen.MENU);
        }
    }


}






