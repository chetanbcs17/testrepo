package csci.ooad.arcane;

import java.util.Random;

/*
 * Creating static random object to ensure randomness.
 */
public class Dice {
    private static final Random random = new Random();

    public static int roll() {
        return random.nextInt(1, 7);
    }
}
