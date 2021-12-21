package main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.Entity.Difficulty;

public class Game {

    private static Stage primaryStage;
    private static Scene scene;
    private static Game instance;
    private static Difficulty diff;

    private static Pane playArea;

    /*
        Setting the Game constructor
        Game: creating the Game
        init: creating the instance of the Game
        getInstance: getter method for the instance of the Game
     */
    public Game(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public static Game init(Stage primaryStage){
        if (instance == null) {
            instance = new Game(primaryStage);
        }
        return instance;
    }

    public static Game getInstance() {
        return instance;
    }

    /*
        FXML loader for the screens - this method is needed to catch the exceptions when calling the method
        Since it is impossible to call the FXML for each screen every time by extending Applications,
        we handle the exceptions through this method
     */
    private static Parent fxmlLoad(String path) {
        Parent parent = null;
        try {
            FXMLLoader loader = new FXMLLoader(Game.class.getResource(path));
            parent = loader.load();
        } catch (Exception e) {
            System.out.println("NO FILE: " + path);
        }
        return parent;
    }

    /*
        Go to the welcoming screen of the Farming Game
     */
    public void welcomingScreen() {
        // Load the FXML file from the resources file and build the scene
        Scene scene = new Scene(fxmlLoad("Front/WelcomingScreen.fxml"));

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public void options() {
        Scene scene = new Scene(playArea, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    /*
        Go to the initial configuration screen of the Farming Game
     */
    public void configScreen() {
        Scene scene = new Scene(fxmlLoad("Front/ConfigurationScreen.fxml"));

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    /*
        FROM HERE are the methods(mostly getters and setters) needed for the screens
     */


    public void setDifficulty(Difficulty diff) {
        this.diff = diff;
    }
}
