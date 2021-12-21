package main;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {

    private Game farmingGame;

    @Override
    public void start(Stage primaryStage) throws IOException {
        farmingGame = Game.init(primaryStage);
        farmingGame.welcomingScreen();
    }

    public static void main(String[] args) {
        launch();
    }
}