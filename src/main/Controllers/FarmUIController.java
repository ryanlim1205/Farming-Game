package main.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import main.Game;

public class FarmUIController {

    @FXML
    private Label name;
    @FXML
    private Label current_date;
    @FXML
    private Label current_money;
    @FXML
    private Label current_season;
    @FXML
    private Label seed;
    @FXML
    private Button inventory;

    @FXML
    private Button plot_1;

    @FXML
    protected void initialize() {
        name.setText("Name: " + Game.getInstance().getName());
        current_date.setText("Day: " + Game.getInstance().giveStartingDate());
        current_money.setText("Cash: " + Game.getInstance().get_currentMoney());
        current_season.setText("Season: " + Game.getInstance().getSeason());
        seed.setText("Seed: " + Game.getInstance().getSeed());
    }

    @FXML
    protected void onClickInventoryButton() throws InterruptedException {
        Game.getInstance().inventoryScreen();
    }

    @FXML
    protected void onClickMarketButton() throws InterruptedException {
        Game.getInstance().marketScreen();
    }
}
