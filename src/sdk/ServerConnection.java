package sdk;

/**
 * Created by Jacky on 10/11/15.
 */

/**
 * This class is from a template from GitHub from the prototype, otherwise most of it is written by the author@Jacky Li.
 * The class handles the server connection; As we are handling with Json to communicate with the server, we are sending
 * GET-, PUT-, DELETE-, POST-REQUEST to the server. To either receive, update, delete, post something to our database,
 * through the server, as the methods for these are in the server's api.
 */

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;

public class ServerConnection {
     //Declaring variables that are needed for this class
    private String hostAddress;
    private int port;
    //The class' constructor
    public ServerConnection() {
        //Initializing variables
        this.hostAddress = "http://localhost";
        this.port = 8888;
    }

    /**
     * The method to get the Host adress
     * @return hostAdress
     */
    public String getHostAddress() {
        return hostAddress;
    }

    /**
     * The method to get the port
     * @return port
     */
    public int getPort() {
        return port;
    }

    /**
     * As we send the several request to the server, we want to receive the message value, which is the requested object in JSon, from the response(The response(message) I chose, there are several responses).
     * The message we receive, has to be parsed, to the specific requested/responded message(In my case, since other response/request are defined)
     * @param json Since the object is encoded in JSon, we need to decode it by parsing it to a String, to make it usable for us.
     * @return message
     * responsetojson
     * en masse forskellige message, den specifikke, jsonobject, converts messag
     */
    public String messageParser(String json) {
        JSONParser jsonParser = new JSONParser();

        String message = "";
        //try-catch method to enclose the code which have may throw exception
        try {
            Object obj = jsonParser.parse(json);
            JSONObject jsonObject = (JSONObject) obj;
            //http message contains json
            message = ((String) jsonObject.get("message"));
        // the catch which has to handle the exception
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return message;
    }

    /**
     *The method is for, to "get" objects from the server, which is send by a request from this client, as it need specific values from the database through the server.
     * @param path We can by the path, choose the specific path in the server's API, which identifies the needed resource.
     * @return output
     */

    public String get(String path) {

        Client client = Client.create();

        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").get(ClientResponse.class);

        String output = response.getEntity(String.class);

        return output;

    }

    /**
     * The method is for, to "post" objects/resource to the server, which are send from this client. Which specifies where our resource are being post to, by the path.
     * @param json as we want to post/send our Java objects/resource to the server, we have to convert it to Json by using Gson.
     * @param path as we post/send our objects/resources, we have to chose its specific path.
     * @return output
     */
    public String post(String json, String path) {

        Client client = Client.create();

        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").post(ClientResponse.class, json);

        String output = response.getEntity(String.class);
        return output;

    }

    /**
     * The method is for, to "put" objects/resource to the server, which are send from this client. In other words, we want update our resource by "put", by the path.
     * @param path as we post/send our objects/resources, we have to chose its specific path.
     * @param json as we want to post/send our Java objects/resource to the server, we have to convert it to Json by using Gson.
     * @return output
     */

    public String put(String path, String json) {
        Client client = Client.create();

        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").put(ClientResponse.class, json);

        String output = response.getEntity(String.class);
        return output;
    }


    /**
     * The method is for the login through the server, and posting an object of the User.class in Gson to Json.
     * @param user posting object of user
     * @return this.messageParser(jsonLogin)
     */
    public String login(User user) {

        String jsonLogin = this.post(new Gson().toJson(user), "login/");

        return this.messageParser(jsonLogin);
    }

    /**
     * The method is to delete a object on the server, and deleting an object by the client.
     * @param path as we delete the resource, we are deleting by the specific path.
     * @return output
     */
    public String delete(String path) {
        Client client = Client.create();

        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").delete(ClientResponse.class);

        String output = response.getEntity(String.class);
        return output;
    }

    /**
     * The method is using a "get"-request by the path ("games/pending/" + userid), in return we will receive some Json-objects,
     * and as we receive them, we will convert them to Gson, and creates an arraylist of it.
     * @param userId
     * @return new Gson().fromJson(jsonOfGames, new TypeToken<ArrayList<Game>>() {
    }.getType());
     */
    public ArrayList<Game> getGameChallenge(int userId) {
        String jsonOfGames = this.get("games/pending/" + userId);
        return new Gson().fromJson(jsonOfGames, new TypeToken<ArrayList<Game>>() {
        }.getType());
    }

    /**
     *  The method is using a "GET"-request by the path ("users/"), in return we will receive some Json-objects,
     * and as we receive them, we will convert them to Gson, and creates an arraylist of it.
     * @return new Gson().fromJson(jsonOfUsers, new TypeToken<ArrayList<User>>() {
    }.getType());
     */
    public ArrayList<User> getUserData() {
        String jsonOfUsers = this.get("users/");
        return new Gson().fromJson(jsonOfUsers, new TypeToken<ArrayList<User>>() {
        }.getType());
    }

    /**
     * The method is used by joining a game, as we are sending a "PUT-request" by the path("games/join"),
     * the request sends a Gson object and converts it to a Json object, and adds an update to the object
     * in the game class.
     * @param game posting object of game
     * @return this.messageParser(jsonOfJoinGame)
     */

    public String joinGame(Game game) {
        String jsonOfJoinGame = this.put("games/join", (new Gson().toJson(game)));
        return this.messageParser(jsonOfJoinGame);

    }

    /**
     * The method is used by starting a game, as we are sending a "PUT-request" by the path("games/start),
     * the request sends a Gson object and converts it to a Json object, and adds an update to the object
     * in the game class.
     * @param game posting object of game
     * @return this.messageParser(jsonOfGameStart)
     */
    public String gameStart(Game game) {
        String jsonOfGameStart = this.put("games/start", (new Gson().toJson(game)));
        return this.messageParser(jsonOfGameStart);
    }

    /**
     * The method is used by creating a new game, as we are sending a "POST-request" by the path("games/",
     * the request sends a Gson-object which is being converted to a Json object.
     * @param game posting object of game
     * @return this.messageParser(jsonOfCreateGame)
     */
    public String createGame(Game game) {
        String jsonOfCreateGame = this.post(new Gson().toJson(game), "games/");
        return this.messageParser(jsonOfCreateGame);

    }

    /**
     * The method is used by deleting a game, as we are sending a "DELETE-request" by the path("games/" + gameid)
     * @param gameId deleting object of gameid
     * @return this.messageParser(jsonOfDelete
     */
    public String deleteGames(int gameId) {
        String jsonOfDelete = this.delete("games/" + gameId);
        return this.messageParser(jsonOfDelete);
    }

    /**
     * The method is using a "GET"-request by the path ("games/finished/" + userid), in return we will receive some Json-objects,
     * and as we receive them, we will convert them to Gson, and creates an arraylist of it.
     * @param userid deleting an object by userid
     * @return new Gson().fromJson(jsonOfUsers, new TypeToken<ArrayList<User>>() {
    }.getType());
     */
    public ArrayList<Game> getDeleteGame(int userid) {
        String jsonOfDeleteGame = this.get("games/finished/" + userid);
        return new Gson().fromJson(jsonOfDeleteGame, new TypeToken<ArrayList<Game>>() {
        }.getType());
    }

    /**
     * The method is using a "GET"-request by the path ("highscores"), in return we will receive some Json-objects,
     * and as we receive them, we will convert them to Gson, and creates an arraylist of it.
     * @return
     */
    public ArrayList<Score> getHighscores() {
        String jsonOfUsers = this.get("highscores");
        return new Gson().fromJson(jsonOfUsers, new TypeToken<ArrayList<Score>>() {
        }.getType());
    }

}