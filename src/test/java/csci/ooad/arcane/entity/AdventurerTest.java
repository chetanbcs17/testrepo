package csci.ooad.arcane.entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import csci.ooad.arcane.maze.Room;

public class AdventurerTest {

    private Adventurer adventurer;
    private Room currentRoom;
    private Room nextRoom;

    @BeforeEach
    public void setUp() {
        adventurer = new Adventurer("Bill", 5);
        currentRoom = Mockito.mock(Room.class);
        nextRoom = Mockito.mock(Room.class);
        adventurer.setCurrentRoom(currentRoom);
    }

    @Test
    public void testMoveToRoomCurrentRoomNull() {
        adventurer.setCurrentRoom(null);
        adventurer.moveToRoom();
        Mockito.verify(currentRoom, Mockito.never()).removeAdventurer();

    }

    @Test
    public void testMoveToRoomNextRoomNull() {
        Mockito.when(currentRoom.getNextNeighbor()).thenReturn(null);
        adventurer.moveToRoom();
        Mockito.verify(currentRoom, Mockito.never()).removeAdventurer();
        Mockito.verify(nextRoom, Mockito.never()).setAdventurer(adventurer);

    }

    @AfterEach
    public void cleanUp() {
        adventurer = null;
        currentRoom = null;
        nextRoom = null;
    }
}
