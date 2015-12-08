package sdk;

/**
 * Created by Jacky on 10/11/15.
 *
 * **/
/**
 * This class is from a template from GitHub from the prototype, otherwise it is found in the server as well.
 * The class represent the objects and variables of Score, which are used to set the score of the game.
 */


// Creates class Score
public class Score {

    // Declare highScore
    private int id;
    private Gamer user;
    private Gamer opponent;
    private Game game;
    private int score;

    // Creates constructor
    public Score(int id, Gamer user, Game game, Gamer opponent, int score) {
        this.id = id;
        this.user = user;
        this.game = game;
        this.opponent = opponent;
        this.score = score;
    }

    public Score() {
    }

    // Creates get method which returns the highScore

    public Gamer getOpponent() {
        return opponent;
    }

    public void setOpponent(Gamer opponent) {
        this.opponent = opponent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Gamer getUser() {
        return user;
    }

    public void setUser(Gamer user) {
        this.user = user;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
