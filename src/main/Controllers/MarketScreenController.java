package main.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import main.Entity.Seed;
import main.Game;

public class MarketScreenController {

    @FXML
    private ComboBox<String> seed_box;
    @FXML
    private TextField number_of_seeds;

    private int which_seed;

    private int price_orange_seeds = 10;
    private int price_peach_seeds = 15;
    private int price_watermelon_seeds = 20;

    @FXML
    public void initialize() {
        seed_box.getItems().clear();
        seed_box.getItems().addAll("Choose Seed","Orange", "Peach", "Watermelon");
        seed_box.getSelectionModel().selectFirst();   // for default, just display the first choice
        purchase_seeds();
    }

    @FXML
    protected void choose_which_seed_purchase() {
        switch (seed_box.getValue()) {
            case "Orange" :
                which_seed = 1;
                break;
            case "Peach" :
                which_seed = 2;
                break;
            case "Watermelon" :
                which_seed = 3;
                break;
            default:
        }
    }

    public boolean can_purchase(int seed_price, int number_of_seeds) {
        if (Game.getInstance().get_currentMoney() > seed_price * number_of_seeds) {
            return true;
        }

        Alert warning = new Alert(Alert.AlertType.WARNING);
        warning.setContentText("Lack of money!");
        warning.show();

        return false;
    }

    @FXML
    public void set_number_of_seeds_purchase() {
        Game.getInstance().set_purchased_seeds_number(Integer.valueOf(number_of_seeds.getText()));
    }

    // purchasing orange seeds, but returning money after transaction
    @FXML
    public void purchase_seeds() {
        if (which_seed == 1) {
            if (can_purchase(price_orange_seeds, Game.getInstance().get_purchased_seeds_number())) {
                // money update
                Game.getInstance().set_currentMoney(Game.getInstance().get_currentMoney() -
                        (price_orange_seeds * Game.getInstance().get_purchased_seeds_number()));
                // number of seeds update
                Game.getInstance().setAmount_of_orange_seed(Game.getInstance().getAmount_of_orange_seed() + Game.getInstance().get_purchased_seeds_number());

                Game.getInstance().FarmUI();
            }
        } else if (which_seed == 2) {
            if (can_purchase(price_peach_seeds, Game.getInstance().get_purchased_seeds_number())) {
                // money update
                Game.getInstance().set_currentMoney(Game.getInstance().get_currentMoney() -
                        (price_peach_seeds * Game.getInstance().get_purchased_seeds_number()));
                // number of seeds update
                Game.getInstance().setAmount_of_peach_seed(Game.getInstance().getAmount_of_peach_seed() + Game.getInstance().get_purchased_seeds_number());

                Game.getInstance().FarmUI();
            }
        } else if (which_seed == 3) {
            if (can_purchase(price_watermelon_seeds, Game.getInstance().get_purchased_seeds_number())) {
                // money update
                Game.getInstance().set_currentMoney(Game.getInstance().get_currentMoney() -
                        (price_watermelon_seeds * Game.getInstance().get_purchased_seeds_number()));
                // number of seeds update
                Game.getInstance().setAmount_of_watermelon_seed((Game.getInstance().getAmount_of_watermelon_seed() + Game.getInstance().get_purchased_seeds_number()));

                Game.getInstance().FarmUI();
            }
        }
    }
}
