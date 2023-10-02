package ru.ollyeys.videogame.creatures;

import java.util.Random;

class Player extends Creature {
    private int healCount;
    private int playerLevel;

    public Player(String name, int attack, int defense, int maxHealth, int health, int damageMin, int damageMax, int playerLevel) {
        super(name, attack, defense, maxHealth, health, damageMin, damageMax);
        this.playerLevel = playerLevel;
    }

    public void heal() {
        if (healCount < 4) {
            int maxHeal = (int) (0.3 * this.getMaxHealth());
            if (maxHeal > 0) {
                Random random = new Random();
                int healAmount = random.nextInt(maxHeal) + 1;
                int newHealth = this.getHealth() + healAmount;
                this.health = Math.min(newHealth, this.getMaxHealth());
                healCount++;
                System.out.println("Healing #" + healCount + ": Recovered " + healAmount + " health.");
            } else {
                System.out.println("Healing is not available, health at maximum.");
            }

        } else {
            System.out.println("Healing not available, 4 healings already done");
        }
    }

    public void gainLevel(int amount) {
        this.playerLevel += amount;
    }

    public int getPlayerLevel() {
        return playerLevel;
    }

    public void setLevel(int level) {
        if (level > 0) {
            playerLevel = level;
        } else {
            System.out.println("Player level must be > 0");
        }
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString())
                .append(", level=").append(getPlayerLevel())
                .append("]");
        return builder.toString();
    }
}