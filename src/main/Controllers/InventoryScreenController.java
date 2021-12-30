package main.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import main.Game;

import java.awt.*;

public class InventoryScreenController {

    @FXML
    private Label orange_seeds;
    @FXML
    private Label peach_seeds;
    @FXML
    private Label watermelon_seeds;

    // Needed for the inventory capacity
    private int seed_capacity = 50;
    private int crop_capacity;

    // Initializing the starting number of seeds
    @FXML
    public void initialize() {
        orange_seeds.setText("Orange Seeds: " + Game.getInstance().getAmount_of_orange_seed());
        peach_seeds.setText("Peach Seeds: " + Game.getInstance().getAmount_of_peach_seed());
        watermelon_seeds.setText("Watermelon Seeds: " + Game.getInstance().getAmount_of_watermelon_seed_seed());
    }

    // Check whether the total number of seeds exceeds the inventory's seed capacity
    public boolean seed_capacity_check() {
        if (Game.getInstance().getAmount_of_orange_seed() + Game.getInstance().getAmount_of_peach_seed()
                + Game.getInstance().getAmount_of_watermelon_seed_seed() > seed_capacity) {
            return false;
        }
        return true;
    }

    // Go back to the Farm Screen
    @FXML
    protected void onClickFarmButton() {
        Game.getInstance().FarmUI();
    }
}
