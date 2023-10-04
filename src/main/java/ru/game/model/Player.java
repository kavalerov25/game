package ru.game.model;

import java.util.Random;

public class Player extends Creature {
    private static final int MAX_HEAL_COUNT = 4;
    private int healCount; // Переменная для отслеживания количества исцелений игрока

    public Player(int attack, int defense, int health) {
        super(attack, defense, health);
        this.healCount = health;
    }

    public void heal() {
        int maxHealth = 100; // Примерное максимальное значение здоровья игрока
        int maxHealAmount = (int) (maxHealth * 0.3); // 30% от максимального здоровья
        if (healCount < MAX_HEAL_COUNT) {
            int currentHealth = getHealth();
            int newHealth = currentHealth + maxHealAmount;
            setHealth(Math.min(newHealth, maxHealth));
            healCount++;
            System.out.println("Вы исцелились на " + maxHealAmount + " единиц здоровья.");
        } else {
            System.out.println("Вы исцелились максимальное количество раз.");
        }
    }
}


