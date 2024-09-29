package csci.ooad.arcane;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class DiceTest {
    private MockedStatic<Random> mockedRandom;

    @BeforeEach
    public void setUp() {
        mockedRandom = Mockito.mockStatic(Random.class);
    }

    @AfterEach
    public void cleanUp() {
        mockedRandom.close();
    }

    @Test
    @SuppressWarnings("static-access")
    public void testRoll() {
        Dice dice = new Dice();
        for (int i = 0; i < 1000; i++) {
            int result = dice.roll();
            assertTrue(result >= 1 && result <= 6);
        }
    }
}
