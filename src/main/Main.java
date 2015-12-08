package main;

/**
 * Main-Class which is used to start the application/client
 * Created by Jacky on 19/11/15.
 */

import logic.Logic;

/**
 * The application/client starts by the run() method in the Logic.class
 */
public class Main {
    public static void main(String[] args) {
        Logic logic = new Logic();
        logic.run();
    }
}
