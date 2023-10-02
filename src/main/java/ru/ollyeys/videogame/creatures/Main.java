package ru.ollyeys.videogame.creatures;


public class Main {
    public static void main(String[] args) {
        Player player = null;
        Monster monster = null;

        try {
            player = new Player("Olya", 20, 15, 50, -1, 20, 30, 5);
            monster = new Monster("Godzilla", 30, 30, 50, 30, 30, 35, MonsterType.ORC);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        if (player != null && monster != null) {


            System.out.println("Player: " + player + " is created!");
            System.out.println("Monster: " + monster + " is created!");

            while (player.isAlive() && monster.isAlive()) {
                System.out.println(player.getName() + " is attacking!");
                player.attack(monster);
                System.out.println("---------------------");
                System.out.println(player.getName() + "'s health: " + player.getHealth());
                System.out.println(monster.getName() + " health: " + monster.getHealth());
                System.out.println("---------------------");
                if (monster.isAlive()) {
                    System.out.println(monster.getName() + " is attacking!");
                    monster.attack(player);
                    System.out.println("---------------------");
                    System.out.println(player.getName() + "'s health: " + player.getHealth());
                    System.out.println(monster.getName() + " health: " + monster.getHealth());
                    System.out.println("---------------------");
                }
            }

            if (player.isAlive()) {
                System.out.println("Player " + player.getName() + " wins!");
                System.out.println("Monster " + monster.getName() + " is dead!");
            } else {
                System.out.println("Monster " + monster.getName() + " wins!");
            }
        }
    }
}
