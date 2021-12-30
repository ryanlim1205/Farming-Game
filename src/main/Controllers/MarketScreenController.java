package main.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import main.Game;

public class MarketScreenController {

    @FXML
    private TextField number_of_seeds;

    private int price_orange_seeds = 10;
    private int price_peach_seeds = 15;
    private int price_watermelon_seeds = 20;

    public boolean can_purchase(int seed_price, int number_of_seeds) {
        if (Game.getInstance().get_currentMoney() > seed_price * number_of_seeds) {
            return true;
        }

        Alert warning = new Alert(Alert.AlertType.WARNING);
        warning.setContentText("Lack of money!");
        warning.show();

        return false;
    }

    public void set_number_of_seeds_purchase() {
        Game.getInstance().set_purchased_seeds_number(Integer.valueOf(number_of_seeds.getText()));
    }

    // purchasing orange seeds, but returning money after transaction
    public void purchase_orange_seeds() {
        if (can_purchase(price_orange_seeds, Game.getInstance().get_purchased_seeds_number())) {
            // money update
            Game.getInstance().set_currentMoney(Game.getInstance().get_currentMoney() -
                    (price_orange_seeds * Game.getInstance().get_purchased_seeds_number()));
            // number of seeds update
            Game.getInstance().setAmount_of_orange_seed(Game.getInstance().getAmount_of_orange_seed() + Game.getInstance().get_purchased_seeds_number());

            Game.getInstance().FarmUI();
        }
    }
}
