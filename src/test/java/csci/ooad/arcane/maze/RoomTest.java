package csci.ooad.arcane.maze;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import csci.ooad.arcane.entity.Adventurer;

public class RoomTest {

    @Test
    public void testGetNeighboringRooms() {
        Room room = new Room("test");
        assertEquals(room.getNeighboringRooms().size(), 0);
    }

    @Test
    public void testRemoveAdventurer() {
        Room room = new Room("South East");
        Adventurer adventurer = new Adventurer("Adventurer", 5.0f);
        room.setAdventurer(adventurer);
        room.removeAdventurer();
        assertNull(room.getAdventurer());
    }
}
