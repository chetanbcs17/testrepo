package csci.ooad.arcane.maze;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import csci.ooad.arcane.entity.Adventurer;
import csci.ooad.arcane.entity.Creature;

public class Room {
    private final String name;
    private List<Room> neighboringRooms;
    private Adventurer adventurer;
    private Creature creature;
    private final Random random;

    public Room(String name) {
        this.name = name;
        this.neighboringRooms = new ArrayList<>();
        this.adventurer = null;
        this.creature = null;
        this.random = new Random();
    }

    public Adventurer getAdventurer() {
        return adventurer;
    }

    public List<Room> getNeighboringRooms() {
        return neighboringRooms;
    }

    public void setNeighboringRooms(List<Room> neighboring_rooms) {
        this.neighboringRooms = neighboring_rooms;
    }

    public void setCreature(Creature creature) {
        this.creature = creature;
        this.creature.setCurrentRoom(this);
    }

    public void setAdventurer(Adventurer adventurer) {
        this.adventurer = adventurer;
        this.adventurer.setCurrentRoom(this);
    }

    public void removeAdventurer() {
        this.adventurer = null;
    }

    public Room getNextNeighbor() {
        return neighboringRooms.get(random.nextInt(neighboringRooms.size()));
    }

    public void printRoom() {
        System.out.println(name + " :");
        if (null != adventurer) {
            System.out.printf("Adventurer %s(health : %.2f) is here%n", adventurer.getName(), adventurer.getHealth());
        }
        if (null != creature) {
            System.out.printf("Creature %s(health : %.2f) is here%n", creature.getName(), creature.getHealth());
        }
    }
}
