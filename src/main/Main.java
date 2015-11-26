package main;

import sdk.Logic;
import sdk.ServerConnection;

/**
 * Created by Jacky on 19/11/15.
 */
public class Main {
    public static void main(String[] args) {
        Logic logic = new Logic();
        logic.run();
        ServerConnection sc = new ServerConnection();

        //sc.get("users");


       // logic.login("jali","123");
    }
}
