package main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.Entity.Difficulty;
import main.Entity.Season;
import main.Entity.Seed;

import main.Controllers.FarmUIController;

public class Game {

    private static Stage primaryStage;
    private static Scene scene;
    private static Game instance;

    private static Difficulty diff;
    private static Seed seed;
    private static Season season;
    private static String player_name;

    private static int money;
    private static int amount_of_orange_seed;
    private static int amount_of_watermelon_seed;
    private static int amount_of_peach_seed;


    // only for options
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
        Exit game: close the stage itself
     */
    public void exit() {
        primaryStage.close();
    }

    /*
        Go to the initial configuration screen of the Farming Game
     */
    public void configScreen() {
        Scene scene = new Scene(fxmlLoad("Front/ConfigurationScreen.fxml"));

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void FarmUI() {
        Scene scene = new Scene(fxmlLoad("Front/FarmUI.fxml"));

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void inventoryScreen() {
        Scene scene = new Scene(fxmlLoad("Front/InventoryScreen.fxml"));

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    /*
        FROM HERE are the methods(mostly getters and setters) needed for the screens
     */

    public void setDifficulty(Difficulty diff) {
        this.diff = diff;
    }

    public Difficulty getDifficulty() {
        return diff;
    }

    public void setSeed(Seed seed) {
        this.seed = seed;
    }

    public Seed getSeed() {
        return seed;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Season getSeason() {
        return season;
    }

    public void setName(String player_name) {
        this.player_name = player_name;
    }

    public static String getName() {
        return player_name;
    }

    /*
        Methods for the initial game values - starting money based on difficulty and the date
     */

    public static int giveStartingDate() {
        return 1;
    }

    public static int giveStartingMoney() {
        if (diff == Difficulty.EASY) {
            money = 1000;
        } else if (diff == Difficulty.MEDIUM) {
            money = 700;
        } else {
            money = 500;
        }
        return money;
    }

    public static int get_currentMoney() {
        return money;
    }

    public void set_StartingSeed() {
        if (diff == Difficulty.EASY) {
            if (seed == Seed.Orange) {
                amount_of_orange_seed = 10;
            } else if (seed == Seed.Peach) {
                amount_of_peach_seed = 10;
            } else {
                amount_of_watermelon_seed = 10;
            }
        } else if (diff == Difficulty.MEDIUM) {
            if (seed == Seed.Orange) {
                amount_of_orange_seed = 7;
            } else if (seed == Seed.Peach) {
                amount_of_peach_seed = 7;
            } else {
                amount_of_watermelon_seed = 7;
            }
        } else {
            if (seed == Seed.Orange) {
                amount_of_orange_seed = 5;
            } else if (seed == Seed.Peach) {
                amount_of_peach_seed = 5;
            } else {
                amount_of_watermelon_seed = 5;
            }
        }
    }

    public static int getAmount_of_orange_seed() {
        return amount_of_orange_seed;
    }

    public static int getAmount_of_watermelon_seed_seed() {
        return amount_of_watermelon_seed;
    }

    public static int getAmount_of_peach_seed() {
        return amount_of_peach_seed;
    }

}
