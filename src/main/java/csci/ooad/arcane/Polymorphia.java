package csci.ooad.arcane;

import csci.ooad.arcane.entity.Adventurer;
import csci.ooad.arcane.entity.Creature;
import csci.ooad.arcane.maze.Maze;

public class Polymorphia {

    static final float INIT_HEALTH = 5.0f;

    Maze maze;
    Adventurer adventurer;
    Creature creature;

    public Polymorphia() {
        maze = new Maze();
        adventurer = new Adventurer("Adventurer", INIT_HEALTH);
        creature = new Creature("Ogre", INIT_HEALTH);
        maze.placeCharacters(adventurer, creature);
    }

    public Polymorphia(Maze maze,
            Adventurer adventurer,
            Creature creature) {
        this.maze = maze;
        this.adventurer = adventurer;
        this.creature = creature;
    }

    public void play() {
        int turn = 0;
        System.out.println("Starting play...");
        while (adventurer.getHealth() > 0 && creature.getHealth() > 0) {
            turn += 1;
            System.out.println("Polymorphia MAZE: turn " + turn);
            maze.printMaze();
            if (adventurer.getCurrentRoom() == creature.getCurrentRoom()) {
                adventurer.fight(creature);
            } else {
                adventurer.moveToRoom();
            }
            System.out.println();
        }
        System.out.println(adventurer.getHealth() <= 0 ? "Boo, the Creature won!" : "Yaay, the Adventurer won!");
    }

    public boolean isOver() {
        return adventurer.getHealth() <= 0 || creature.getHealth() <= 0;
    }
}
