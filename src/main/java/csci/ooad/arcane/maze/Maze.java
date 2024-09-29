package csci.ooad.arcane.maze;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import csci.ooad.arcane.entity.Adventurer;
import csci.ooad.arcane.entity.Creature;

public class Maze {
    private final List<Room> rooms;
    private static final int NUM_OF_ROOMS = 4;
    private final Random random = new Random();

    public Maze() {
        this.rooms = new ArrayList<>(NUM_OF_ROOMS);
        initializeRooms();
        initializeNeighbourRooms();
    }

    private void initializeRooms() {
        for (RoomName roomName : RoomName.values()) {
            rooms.add(new Room(roomName.name()));
        }
    }

    private void initializeNeighbourRooms() {
        List<List<Room>> adjacentRooms = List.of(
                List.of(rooms.get(1), rooms.get(2)),
                List.of(rooms.get(0), rooms.get(3)),
                List.of(rooms.get(0), rooms.get(3)),
                List.of(rooms.get(1), rooms.get(2)));
        for (int i = 0; i < NUM_OF_ROOMS; i++) {
            rooms.get(i).setNeighboringRooms(adjacentRooms.get(i));
        }
    }

    public void printMaze() {
        for (Room room : rooms) {
            room.printRoom();
        }
    }

    public void placeCharacters(Adventurer adventurer, Creature creature) {
        rooms.get(random.nextInt(NUM_OF_ROOMS)).setAdventurer(adventurer);
        rooms.get(random.nextInt(NUM_OF_ROOMS)).setCreature(creature);
    }

    public enum RoomName {
        NORTH_WEST, NORTH_EAST, SOUTH_WEST, SOUTH_EAST
    }

}
