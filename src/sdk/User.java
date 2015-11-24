package sdk;

/**
 * Created by Jacky on 10/11/15.
 */
public class User {

    private String username;
    private String password;

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void getPassword(String password) { this.password = password; }

    public void getUsername(String username) { this.username = username; }
}