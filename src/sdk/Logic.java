
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
            screen.getLogin().actionPerformedLogin(
                    new LoginActionListener());
            screen.getMenu().addACList(
                    new MenuActionListener());

            screen.show(screen.LOGIN);
        }


        /*public static void login(String username, String password){

            ServerConnection serverConnection = new ServerConnection();

            User user = new User();
            user.setPassword(password);
            user.setUsername(username);

            String json = new Gson().toJson(user);

            serverConnection.post(json, "login/");


        }*/
        /*public static void createUser(User user){

        }
        public static void deleteUser(int userId){

        }
        public static void getUser(int userId){

        }
        public static void getGame(int gameId){

        }
        public static void joinGame(int gameId, User opponent, String controls){

        }
        public static void startGame(int gameId){

        }
        public static void createGame(String name, int status){

            ServerConnection serverConnection = new ServerConnection();

            Game game = new Game();
            game.setName(name);
            //game.setHost();
            game.setStatus(status);

            String json = new Gson().toJson(game);

            serverConnection.post(json, "create");

        }
        public static void deleteGame(int gameId){

        }
*/

    private boolean isEmpty(String text){
        //trim sørger for at der ikke er tomme spaces
        text = text.trim();

        if (text.equals("") || text.length() < 1 || text == null){
            return true;
        } else {
            return false;
        }
    }

    private class LoginActionListener implements ActionListener{

        public void actionPerformed(ActionEvent e){
            String actCom = e.getActionCommand();
            if (actCom.equals("Login")) {
                screen.show(screen.MENU);

                /*String usernameField = screen.getLogin().getTxtUsername().getText();
                String passwordField = screen.getLogin().getTxtTypePassword().getText();
                screen.getLogin().getTxtUsername().setText("");
                screen.getLogin().getTxtTypePassword().setText("");
                    //Checks if username and pass field is filled
                if (isEmpty(usernameField) || isEmpty(passwordField)) {
                    //Errormsg in label in window
                    screen.getLogin().setErrorMessage("Please type username and password");
                } else {
                    screen.getLogin().setErrorMessage("Wrong username or password");
                    //Checking login
                    if (null)
                        screen.show.(screen.MENU);
                }
*/

                }

            }
        }

    }

    }


