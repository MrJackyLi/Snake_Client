package sdk;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.corba.se.spi.activation.Server;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.codehaus.jackson.map.util.JSONPObject;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Jacky on 10/11/15.
 */
public class ServerConnection {
    public ServerConnection(){
        this.hostAddress = "http://localhost";
        this.port = 8888;
    }

    private String hostAddress;
    private int port;

    public void setHostAddress(String hostAddress) {
        this.hostAddress = hostAddress;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHostAddress() {
        return hostAddress;
    }

    public int getPort() {
        return port;
    }

    public String get(String path){

        Client client = Client.create();

        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").get(ClientResponse.class);


        String output = response.getEntity(String.class);
        System.out.println(output);

        return output;

    }

    public String post(String json, String path){

        Client client = Client.create();

        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").post(ClientResponse.class, json);

        if (response.getStatus() != 200 && response.getStatus() != 201) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        String output = response.getEntity(String.class);
        return output;
        //System.out.println(output);

    }

    public String put(String json, String path)
    {
        Client client = Client.create();

        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").put(ClientResponse.class, json);

        if (response.getStatus() != 200 && response.getStatus() != 201) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        String output = response.getEntity(String.class);
        return output;
    }

    public User login(String username, String password) {

        User usr = new User();

        usr.setPassword(password);
        usr.setUsername(username);

        String jsonUser = new Gson().toJson(usr);

        String response = post(jsonUser, "login/");

        usr = new Gson().fromJson(response, User.class);

        return usr;
    }

        public String stringParser(String json)
        {
            JSONParser jsonParser = new JSONParser();

            String message = "";
            try
            {
                Object obj = jsonParser.parse(json);
                JSONObject jsonObject = (JSONObject) obj;

                message = ((String) jsonObject.get("message"));

            } catch (ParseException e)
            {
                e.printStackTrace();
            }
            return message;

        }

    public ArrayList<Game> gameChallenge(int userId){
        String jsonOfUsers = this.get("games/pending/" + userId);
        return new Gson().fromJson(jsonOfUsers, new TypeToken<ArrayList<Game>>(){}.getType());
    }

    public ArrayList <User> userData(){
        String jsonOfUsers = this.get("users/");
        return new Gson().fromJson(jsonOfUsers, new TypeToken<ArrayList<User>>(){}.getType());
    }

    public String joinGame(Game game)
    {
        String jsonOfUsers = this.put(new Gson().toJson(game),"games/join");
        return this.stringParser(jsonOfUsers);

    }

    public String gameStart(Game game){
        String jsonOfUsers = this.put(new Gson().toJson(game),"games/start");
        return this.stringParser(jsonOfUsers);
    }

    public String createGame(Game game)
    {
        String jsonOfUsers = this.post(new Gson().toJson(game),"games/");

       return this.stringParser(jsonOfUsers);

        }
    }


