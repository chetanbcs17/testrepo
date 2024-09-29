package csci.ooad.arcane.entity;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import csci.ooad.arcane.Dice;

public class CharacterTest {

    private static final float INIT_HEALTH = 5.0f;
    private Character character;
    private Character opponent;
    private MockedStatic<Dice> diceMock;

    @BeforeEach
    public void setUp() {
        character = new Character("Character", INIT_HEALTH);
        opponent = new Character("Opponent", INIT_HEALTH);
        diceMock = Mockito.mockStatic(Dice.class);
    }

    /*
     * Need to hard mock Dice.roll() or else there is a probability that one fo two
     * cases may fail
     */
    @Test
    void testFightWhenCharacterLooses() {
        Character characterSpy = Mockito.spy(character);
        Character opponentSpy = Mockito.spy(opponent);
        diceMock.when(Dice::roll).thenReturn(3, 5);
        characterSpy.fight(opponentSpy);
        Mockito.verify(characterSpy).updateHealth(2);
        Mockito.verify(opponentSpy, never()).updateHealth(anyInt());

    }

    @Test
    void testFightWhenOpponentLooses() {
        Character characterSpy = Mockito.spy(character);
        Character opponentSpy = Mockito.spy(opponent);
        diceMock.when(Dice::roll).thenReturn(5, 3);
        characterSpy.fight(opponentSpy);
        Mockito.verify(opponentSpy).updateHealth(2);
        Mockito.verify(characterSpy, never()).updateHealth(anyInt());

    }

    @Test
    void testFightWheBothRollsSame() {
        Character characterSpy = Mockito.spy(character);
        Character opponentSpy = Mockito.spy(opponent);
        diceMock.when(Dice::roll).thenReturn(5, 5);
        characterSpy.fight(opponentSpy);
        Mockito.verify(characterSpy, times(1)).reduceHealthByHalf(opponentSpy);
        Mockito.verify(opponentSpy, never()).updateHealth(anyInt());
        Mockito.verify(characterSpy, never()).updateHealth(anyInt());

    }

    @AfterEach
    public void cleanUp() {
        diceMock.close();
    }

}
