package ru.ollyeys.videogame.creatures;


import java.util.Random;

class Monster extends Creature {

    protected MonsterType monsterType;

    public Monster(String name, int attack, int defense, int maxHealth, int health, int damageMin, int damageMax, MonsterType monsterType) {
        super(name, attack, defense, maxHealth, health, damageMin, damageMax);
        this.monsterType = monsterType;
    }

    private MonsterType getRandomMonsterType() {
        MonsterType[] types = MonsterType.values();
        Random random = new Random();
        int ind = random.nextInt(types.length);
        return types[ind];
    }

    public void setMonsterType(MonsterType monsterType) {
        this.monsterType = monsterType;
    }

    public MonsterType getMonsterType() {
        return monsterType;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString())
                .append("MonsterType=").append(monsterType)
                .append("]");
        return builder.toString();
    }
}