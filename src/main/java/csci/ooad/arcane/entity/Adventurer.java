package csci.ooad.arcane.entity;

import csci.ooad.arcane.maze.Room;

public class Adventurer extends Character {
    private static final float REDUCE_QUARTER_HEALTH = 0.25f;

    public Adventurer(String name, float health) {
        super(name, health);
    }

    public void moveToRoom() {
        Room currentRoom = this.getCurrentRoom();
        if (null != currentRoom) {
            Room nextRoom = this.getCurrentRoom().getNextNeighbor();
            if (null != nextRoom) {
                this.getCurrentRoom().removeAdventurer();
                nextRoom.setAdventurer(this);
                this.setHealth(this.getHealth() - REDUCE_QUARTER_HEALTH);
            }
        }
    }
}
