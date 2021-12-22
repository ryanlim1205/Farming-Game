package main.Controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import main.Entity.Difficulty;
import main.Entity.Season;
import main.Entity.Seed;
import main.Game;

public class ConfigurationScreenController {

    @FXML
    private ComboBox<String> difficulty_box;
    @FXML
    private ComboBox<String> seed_box;
    @FXML
    private ComboBox<String> season_box;
    @FXML
    private TextField name_of_player;

    // Initialize method is needed -> when the game restarts, when the player comes back to this screen
    @FXML
    public void initialize() {
        // Reset then add all difficulty enums
        difficulty_box.getItems().clear();
        difficulty_box.getItems().addAll("Easy", "Medium", "Hard");
        difficulty_box.getSelectionModel().selectFirst();   // for default, just display the first choice (Easy)
        setDifficulty_combo_box();
        // Reset then add all seed enums
        seed_box.getItems().clear();
        seed_box.getItems().addAll("Watermelon", "Orange", "Peach");
        seed_box.getSelectionModel().selectFirst();         // for default, just display the first choice (Watermelon)
        setSeed_combo_box();
        // Rest then add all season enums
        season_box.getItems().clear();
        season_box.getItems().addAll("Spring", "Summer", "Fall", "Winter");
        season_box.getSelectionModel().selectFirst();         // for default, just display the first choice (Spring)
        setSeed_combo_box();
    }

    // Using switch-case to cover all drop-down buttons - choosing difficulty, seed, and season.
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
    @FXML
    protected void setSeed_combo_box() {
        switch (seed_box.getValue()) {
            case "Watermelon" :
                Game.getInstance().setSeed(Seed.Watermelon);
                break;
            case "Orange" :
                Game.getInstance().setSeed(Seed.Orange);
                break;
            case "Peach" :
                Game.getInstance().setSeed(Seed.Peach);
                break;
            default:
        }
    }
    @FXML
    protected void setSeason_combo_box() {
        switch (season_box.getValue()) {
            case "Spring" :
                Game.getInstance().setSeason(Season.Spring);
                break;
            case "Summer" :
                Game.getInstance().setSeason(Season.Summer);
                break;
            case "Fall" :
                Game.getInstance().setSeason(Season.Fall);
                break;
            case "Winter" :
                Game.getInstance().setSeason(Season.Winter);
            default:
        }
    }
    @FXML
    protected void setName_text_field() {
        Game.getInstance().setName(name_of_player.getText());
    }

    private boolean name_check() {
        if (Game.getInstance().getName() == null || Game.getInstance().getName().isEmpty() || Game.getInstance().getName().isBlank()) {

            Alert warning = new Alert(Alert.AlertType.WARNING);
            warning.setContentText("Please enter your name.");
            warning.show();

            return false;
        }
        return true;
    }



}
