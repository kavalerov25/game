package ru.game.model;

import java.util.Random;

public class Creature {
    private int attack;
    private int defense;
    private int health;

    public Creature(int attack, int defense, int health) {
        this.attack = validateStat(attack);
        this.defense = validateStat(defense);
        this.health = health;
    }

    private int validateStat(int stat) {
        if (stat < 1) {
            return 1; // если stat меньше 1, возвращаем 1
        } else if (stat > 30) {
            return 30; // если stat больше 30, возвращаем 30
        } else {
            return stat; // если stat находится в диапазоне от 1 до 30, возвращаем само значение stat
        }
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = validateHealth(health);
    }

    private int validateHealth(int health) {
        int maxHealth = 100; // Примерное максимальное значение здоровья
        if (health < 0) {
            return 0; // Если здоровье меньше 0, устанавливаем его в 0
        } else if (health > maxHealth) {
            return maxHealth; // Если здоровье больше максимального значения, устанавливаем его в максимальное значение
        } else {
            return health; // Если здоровье находится в допустимом диапазоне, возвращаем его само
        }
    }

    public void attack(Creature target) {
        int attackModifier = attack - target.getDefense() + 1;
        attackModifier = Math.max(attackModifier, 1);
        int diceRolls = attackModifier;

        int successfulHits = 0;
        Random random = new Random();
        for (int i = 0; i < diceRolls; i++) {
            int diceRoll = random.nextInt(6) + 1;
            if (diceRoll >= 5) {
                successfulHits++;
            }
        }

        if (successfulHits > 0) {
            int damage = getRandomDamage();
            target.setHealth(target.getHealth() - damage);
            System.out.println("Существо успешно атаковано! Нанесен урон: " + damage);
        } else {
            System.out.println("Существо промахнулось при атаке.");
        }
    }

    public int getRandomDamage() {
        int minDamage = 1;
        int maxDamage = 6;
        Random random = new Random();
        return random.nextInt(maxDamage - minDamage + 1) + minDamage;
    }
}
