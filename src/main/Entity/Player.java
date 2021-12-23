package main.Entity;

import main.Game;

public class Player {
    private static String name;
    private static int date;
    private static int money;

    public Player(String name, int date, int money) {
        name = Game.getName();
        date = 1;
        money = Game.giveStartingMoney();
    }
}
