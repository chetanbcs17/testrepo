package csci.ooad.arcane.entity;

import csci.ooad.arcane.Dice;
import csci.ooad.arcane.maze.Room;

// @Data Asked not to use lombok
public class Character {
    private final String name;
    private static final float REDUCE_HALF_HEALTH = 0.5f;
    private float health;
    private Room currentRoom = null;

    public Character(String name, float health) {
        this.name = name;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void fight(Character opponent) {
        int characterRoll = Dice.roll();
        int opponentRoll = Dice.roll();
        reduceHealthByHalf(opponent);

        if (characterRoll == opponentRoll) {
            return;
        }

        if (characterRoll > opponentRoll) {
            opponent.updateHealth(characterRoll - opponentRoll);
        } else {
            this.updateHealth(opponentRoll - characterRoll);
        }

    }

    public void reduceHealthByHalf(Character opponent) {
        this.updateHealth(REDUCE_HALF_HEALTH);
        opponent.updateHealth(REDUCE_HALF_HEALTH);
    }

    public void updateHealth(float reduceHalfhealth) {
        this.health -= reduceHalfhealth;
    }

}
