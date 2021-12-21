package main.Controllers;

import javafx.fxml.FXML;
import main.Game;

public class WelcomingScreenController {

    // When the Start Button is clicked, we move to the initial configuration screen
    @FXML
    protected void onStartButtonClick() {
        Game.getInstance().configScreen();
    }
    @FXML
    protected void onOptionsButtonClick() {
        Game.getInstance().options();
    }
    @FXML
    protected void onExitButtonClick() {

    }
}