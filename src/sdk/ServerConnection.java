package sdk;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;

/**
 * Created by Jacky on 10/11/15.
 */
public class ServerConnection {
    private String hostAddress;
    private int port;
    public ServerConnection() {
        this.hostAddress = "http://localhost";
        this.port = 8888;
    }

    public String getHostAddress() {
        return hostAddress;
    }

    public void setHostAddress(String hostAddress) {
        this.hostAddress = hostAddress;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String stringParser(String json) {
        JSONParser jsonParser = new JSONParser();

        String message = "";
        try {
            Object obj = jsonParser.parse(json);
            JSONObject jsonObject = (JSONObject) obj;

            message = ((String) jsonObject.get("message"));

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return message;

    }

    public String get(String path) {

        Client client = Client.create();

        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").get(ClientResponse.class);


        String output = response.getEntity(String.class);

        return output;

    }

    public String post(String json, String path) {

        Client client = Client.create();

        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").post(ClientResponse.class, json);

        String output = response.getEntity(String.class);
        return output;

    }

    public String put(String path, String json) {
        Client client = Client.create();

        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").put(ClientResponse.class, json);

        String output = response.getEntity(String.class);
        return output;
    }

    public String login(User user) { //når du kalder metoden, så skal den 'fodres' med et user objekt

        String message = "";

        String data = this.post(new Gson().toJson(user), "login");
        JSONParser parser = new JSONParser();
        try {
            Object object = parser.parse(data);
            JSONObject jsonobject = (JSONObject) object;

            message = (String) jsonobject.get("message");

            if (jsonobject.get("userid") != null)
                user.setId((int) (long) jsonobject.get("userid")); //Long tvinger JSON til int

        } catch (ParseException e) {
            message = "You didn't type anything";
        }
        return message;
    }

    public String delete(String path) {
        Client client = Client.create();

        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").delete(ClientResponse.class);

        String output = response.getEntity(String.class);
        return output;
    }


    public ArrayList<Game> getGameChallenge(int userId) {
        String jsonOfUsers = this.get("games/pending/" + userId);
        return new Gson().fromJson(jsonOfUsers, new TypeToken<ArrayList<Game>>() {
        }.getType());
    }

    public ArrayList<User> getUserData() {
        String jsonOfUsers = this.get("users/");
        return new Gson().fromJson(jsonOfUsers, new TypeToken<ArrayList<User>>() {
        }.getType());
    }

    public String joinGame(Game game) {
        String jsonOfUsers = this.put("games/join", (new Gson().toJson(game)));
        return this.stringParser(jsonOfUsers);

    }

    public String gameStart(Game game) {
        String jsonOfUsers = this.put("games/start", (new Gson().toJson(game)));
        return this.stringParser(jsonOfUsers);
    }

    public String createGame(Game game) {
        String jsonOfUsers = this.post(new Gson().toJson(game), "games/");

        return this.stringParser(jsonOfUsers);

    }

    public String deleteGames(int gameId) {
        String jsonOfUser = this.delete("games/" + gameId);
        return this.stringParser(jsonOfUser);
    }

    public ArrayList<Game> getDeleteGame(int userid) {
        String jsonOfUsers = this.get("games/finished/" + userid);
        return new Gson().fromJson(jsonOfUsers, new TypeToken<ArrayList<Game>>() {
        }.getType());
    }

    public ArrayList<Score> getHighscores() {
        String jsonOfUsers = this.get("highscores");
        return new Gson().fromJson(jsonOfUsers, new TypeToken<ArrayList<Score>>() {
        }.getType());
    }

}