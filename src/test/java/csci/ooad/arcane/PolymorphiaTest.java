package csci.ooad.arcane;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import csci.ooad.arcane.entity.Adventurer;
import csci.ooad.arcane.entity.Creature;
import csci.ooad.arcane.maze.Maze;

public class PolymorphiaTest {

    private Polymorphia game;
    private Adventurer adventurer;
    private Creature creature;
    private Maze maze;

    @BeforeEach
    public void setUp() {
        adventurer = mock(Adventurer.class);
        creature = mock(Creature.class);
        maze = mock(Maze.class);
        game = new Polymorphia();
    }

    @AfterEach
    public void cleanUp() {
        adventurer = null;
        creature = null;
        maze = null;
        game = null;
    }

    @Test
    public void testGame() {
        game.play();
        assert game.isOver();
    }

    @Test
    public void testIsOverMethod() {
        assertFalse(game.isOver());
        game.adventurer.setHealth(0);
        assertTrue(game.isOver());
        game.adventurer.setHealth(Polymorphia.INIT_HEALTH);
        game.creature.setHealth(0);
        assertTrue(game.isOver());
        game.adventurer.setHealth(Polymorphia.INIT_HEALTH);
        game.creature.setHealth(Polymorphia.INIT_HEALTH);
        assertFalse(game.isOver());
    }

    /*
     * This covers the else case in while loop in play method
     */
    @Test
    public void testPlayBothLowHealth() {
        adventurer = mock(Adventurer.class);
        creature = mock(Creature.class);
        maze = mock(Maze.class);
        game = new Polymorphia(maze, adventurer, creature);
        when(adventurer.getHealth()).thenReturn(0.0f);
        when(creature.getHealth()).thenReturn(0.0f);
        game.play();
        assertTrue(game.isOver());
    }

}
