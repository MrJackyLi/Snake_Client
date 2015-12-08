package sdk;


/**
 * Created by Jacky on 29/11/15.
 */

/**
 * This class is from a template from GitHub from the prototype, otherwise it is found in the server as well.
 * The class represent the objects and variables of a gamer, which are used to set a gamer, in this case only the gamer's controls are set by the gamer.
 */
public class Gamer extends User {

    private int score;
    private int totalScore;
    private int kills;
    private String controls;
    private boolean winner;

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public void setControls(String controls) {
        this.controls = controls;
    }

    public int getKills() {
        return kills;
    }

    public int getScore() {
        return score;
    }

    public String getControls() {
        return controls;
    }
}