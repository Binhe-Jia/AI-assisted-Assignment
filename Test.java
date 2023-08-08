package Blackjack;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BlackjackGameTest {

    @Test
    void testCalculateHandValue() {
        BlackjackGame game = new BlackjackGame();
        game.start();
        int[] playerHand = game.getPlayerHand();

        // Test hand value calculation
        assertEquals(21, game.calculateHandValue(playerHand));

        // Test hand value calculation with an Ace
        playerHand[1] = 11; // Change the second card to Ace
        assertEquals(12, game.calculateHandValue(playerHand));
    }

    @Test
    void testCalculateRemainingCardsProbability() {
        BlackjackGame game = new BlackjackGame();
        Map<Integer, Integer> cardCountMap = new HashMap<>();
        cardCountMap.put(2, 2);
        cardCountMap.put(5, 1);
        game.updateCardCount(cardCountMap);

        Map<Integer, Double> remainingCardsProbability = game.calculateRemainingCardsProbability();

        // Test remaining cards probability for specific card values
        assertEquals(0.875, remainingCardsProbability.get(2), 0.001);
        assertEquals(1.0, remainingCardsProbability.get(3), 0.001);
        assertEquals(1.0, remainingCardsProbability.get(4), 0.001);
        assertEquals(0.75, remainingCardsProbability.get(5), 0.001);
    }
}

class CardUtilsTest {

    @Test
    void testGetCardValue() {
        assertEquals(10, CardUtils.getCardValue("10"));
        assertEquals(10, CardUtils.getCardValue("j"));
        assertEquals(10, CardUtils.getCardValue("q"));
        assertEquals(10, CardUtils.getCardValue("k"));
        assertEquals(11, CardUtils.getCardValue("a"));
        assertEquals(0, CardUtils.getCardValue("invalid"));
    }

    @Test
    void testGetCardCountValue() {
        assertEquals(1, CardUtils.getCardCountValue(2));
        assertEquals(1, CardUtils.getCardCountValue(3));
        assertEquals(1, CardUtils.getCardCountValue(4));
        assertEquals(1, CardUtils.getCardCountValue(5));
        assertEquals(1, CardUtils.getCardCountValue(6));
        assertEquals(-1, CardUtils.getCardCountValue(10));
        assertEquals(0, CardUtils.getCardCountValue(7));
    }
}
