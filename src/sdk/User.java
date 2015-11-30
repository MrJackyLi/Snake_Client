package sdk;

/**
 * Created by Jacky on 10/11/15.
 */
public class User {

    private String username;
    private String password;
    private String email;

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() { return password; }

    public String getUsername() { return username; }

    public String getEmail(){ return email; }
}