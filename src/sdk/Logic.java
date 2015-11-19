
/**
 * Created by Jacky on 10/11/15.
 */

package sdk;

import com.google.gson.Gson;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.Screen;

public class Logic {

    private Screen screen;

    public Logic(){
        screen = new Screen();
        screen.setVisible(true);
    }

        public void run(){
            screen.getLogin().addActionListener(
                    new LoginActionListener());
            //screen.getMenu().addACList(
                   // new MenuActionListener());
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

    private class LoginActionListener implements ActionListener{

        public void actionPerformed(ActionEvent e){

            if(e.getSource() == screen.getLogin().getBtnLogin())
                screen.show(Screen.MENU);

                }

            }
        }






