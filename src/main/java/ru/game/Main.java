package ru.game;

import ru.game.model.Monster;
import ru.game.model.Player;

public class Main {
    public static void main(String[] args) {
        Player player = new Player(15, 10, 100);
        Monster monster = new Monster(12, 8, 80);

        player.attack(monster);
        monster.attack(player);
        player.heal();
        player.attack(monster);
        monster.attack(player);
    }
}

