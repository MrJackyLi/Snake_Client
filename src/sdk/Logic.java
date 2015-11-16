
/**
 * Created by Jacky on 10/11/15.
 */

package sdk;

import com.google.gson.Gson;

import java.awt.event.ActionListener;

public class Logic {

        public void run(){
        screen.getM
    }

        public static void login(String username, String password){

            ServerConnection serverConnection = new ServerConnection();

            User user = new User();
            user.setPassword(password);
            user.setUsername(username);

            String json = new Gson().toJson(user);

            serverConnection.post(json, "login/");


        }
        public static void createUser(User user){

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

    private class MenuActionListener implements ActionListener{

    }


    }
