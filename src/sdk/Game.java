package sdk;

/**
 * Created by Jacky on 10/11/15.
 */

/**
 * This class is from a template from GitHub from the prototype, otherwise it is found in the server as well.
 * The class represent the objects and variables of a game, which are used to set the game.
 */

import java.sql.Date;

public class Game {
    //Creating the variables needed for the game
    private int gameId;
    private Gamer winner;
    private String name;
    private Gamer host;
    private Gamer opponent;
    private String status;
    private Date created;
    private int mapSize;

    public Game(){}

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getMapSize() {
        return mapSize;
    }

    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Creating get/set method for all the variables, so they can be used by other classes
    public int getGameId(){
        return gameId;
    }

    public void setGameId(int gameId){
        this.gameId = gameId;
    }

    public Gamer getHost(){
        return host;
    }

    public void setHost(Gamer host){
        this.host = host;
    }

    public Gamer getOpponent(){
        return opponent;
    }

    public void setOpponent(Gamer opponent){
        this.opponent = opponent;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public Gamer getWinner() {
        return winner;
    }

    public void setWinner(Gamer winner) {
        this.winner = winner;
    }


} //end of class

