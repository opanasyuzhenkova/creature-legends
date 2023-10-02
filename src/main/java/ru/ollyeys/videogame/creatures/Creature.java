package ru.ollyeys.videogame.creatures;

import java.util.Random;

public class Creature {
    private String name;
    private int attack;
    private int defense;
    private int maxHealth;
    protected int health;
    private int damageMin;
    private int damageMax;

    public Creature(String name, int attack, int defense, int maxHealth, int health, int damageMin, int damageMax) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("ILLEGAL ARGUMENT! Name can't be empty");
        }
        if (attack < 1 || attack > 30) {
            throw new IllegalArgumentException("ILLEGAL ARGUMENT! Attack value must be 1-30");
        }
        if (defense < 1 || defense > 30) {
            throw new IllegalArgumentException("ILLEGAL ARGUMENT! Defense value must be 1-30");
        }
        if (health < 0) {
            throw new IllegalArgumentException("ILLEGAL ARGUMENT! Health value must be > 0");
        }
        if (maxHealth < 0) {
            throw new IllegalArgumentException("ILLEGAL ARGUMENT! maxHealth value must be > 0");
        }
        if (damageMin < 1 || damageMax < damageMin) {
            throw new IllegalArgumentException("ILLEGAL ARGUMENT! damageMin must be < damageMax");
        }

        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.maxHealth = maxHealth;
        this.health = health;
        this.damageMin = damageMin;
        this.damageMax = damageMax;

    }

    public int getDefense() {
        return defense;
    }

    public int getAttack() {
        return attack;
    }

    public int getDamageMin() {
        return damageMin;
    }

    public int getDamageMax() {
        return damageMax;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int calculateAttackModifier(int attackValue, int defenseValue) {
        return Math.max(attackValue - defenseValue + 1, 1);
    }

    public int calculateDamage() {
        Random random = new Random();
        int damageRange = damageMax - damageMin + 1;
        int damage = random.nextInt(damageRange) + damageMin;
        return damage;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    public void attack(Creature target) {

        int modifier = calculateAttackModifier(attack, target.defense);
        System.out.println("Attack Modifier = " + modifier);
        Random random = new Random();

        for (int i = 0; i < modifier; i++) {
            int dice = random.nextInt(6) + 1;
            System.out.println("Dice value= " + dice);
            if (dice >= 5) {
                int damage = calculateDamage();
                target.takeDamage(damage);
                System.out.println("Successful hit! Damage: " + damage);
                System.out.println(target.getName() + "'s health = " + target.getHealth());
                if (target instanceof Player && target.getHealth() == 0) {
                    ((Player) target).heal();
                }
                break;
            } else {
                System.out.println("Bad shot!");
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[name=").append(getName())
                .append(", maxHealth=").append(getMaxHealth())
                .append(", health=").append(getHealth())
                .append(", defense=").append(getDefense())
                .append(", attack=").append(getAttack())
                .append(", damageMin=").append(getDamageMin())
                .append(", damageMax=").append(getDamageMax())
                .append("] ");
        return builder.toString();
    }
}