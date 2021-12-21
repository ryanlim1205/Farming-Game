package main.Controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import main.Entity.Difficulty;
import main.Game;

public class ConfigurationScreenController {

    @FXML
    private ComboBox<String> difficulty_box;

    // Initialize method is needed -> when the game restarts, when the player comes back to this screen
    @FXML
    public void initialize() {
        difficulty_box.getItems().clear();
        difficulty_box.getItems().addAll("Easy", "Medium", "Hard");
        difficulty_box.getSelectionModel().selectFirst();
        setDifficulty_combo_box();
    }

    // Using switch-case to cover all difficulties
    @FXML
    protected void setDifficulty_combo_box() {
        switch (difficulty_box.getValue()) {
            case "Easy" :
                Game.getInstance().setDifficulty(Difficulty.EASY);
                break;
            case "Medium" :
                Game.getInstance().setDifficulty(Difficulty.MEDIUM);
                break;
            case "Hard" :
                Game.getInstance().setDifficulty(Difficulty.HARD);
                break;
            default:
        }
    }
}
