package Blackjack;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Represents a decision-making strategy for the Blackjack game.
 */
interface DecisionStrategy {
    String makeDecision(double trueCount, int handValue, Map<Integer, Double> remainingCardsProbability);
}

/**
 * A basic decision strategy based on the true count and hand value.
 */
class BasicDecisionStrategy implements DecisionStrategy {
    @Override
    public String makeDecision(double trueCount, int handValue, Map<Integer, Double> remainingCardsProbability) {
        if (handValue == 11) {
            return "Double Down";
        }else if (handValue >= 12 && handValue <= 16 && trueCount >= 1) {
            return "Hit";
        } else {
            return "Stand";
        }
    }
}

/**
 * Simulates a Blackjack game and makes the best decision based on user input and card counting.
 */
class BlackjackGame {
    private static final int DECKS = 6;

    private Map<Integer, Integer> cardCountMap = new HashMap<>();
    private DecisionStrategy decisionStrategy = new BasicDecisionStrategy();
    private int[] playerHand;

    /**
     * Starts the Blackjack game simulation.
     */
    public void start() {
        Scanner scanner = new Scanner(System.in);

        playerHandInput(scanner);

        updateCardCount(cardCountMap);

        double trueCount = calculateTrueCount();
        Map<Integer, Double> remainingCardsProbability = calculateRemainingCardsProbability();

        String decision = decisionStrategy.makeDecision(trueCount, calculateHandValue(playerHand), remainingCardsProbability);
        System.out.println("Player A - Current true count: " + trueCount + " - Best decision: " + decision);

        scanner.close();
    }

    /**
     * Handles user input for the player's hand.
     *
     * @param scanner The Scanner object for user input.
     */
    private void playerHandInput(Scanner scanner) {
        playerHand = new int[2];

        for (int i = 0; i < 2; i++) {
            System.out.println("Enter card " + (i + 1) + " (2-10, J, Q, K, A):");
            String input = scanner.nextLine().trim().toLowerCase();

            int cardValue = CardUtils.getCardValue(input);
            if (cardValue == 0) {
                System.out.println("Invalid card value. Please enter a valid card.");
                i--;
            } else {
                playerHand[i] = cardValue;
            }
        }
    }

    // Inside the BlackjackGame class
    public int[] getPlayerHand() {
        return playerHand;
    }


    /**
     * Updates the card count based on the player's hand.
     */
    void updateCardCount(Map<Integer, Integer> cardCountMap) {
        for (int cardValue : playerHand) {
            int cardCountValue = CardUtils.getCardCountValue(cardValue);
            this.cardCountMap.put(cardValue, this.cardCountMap.getOrDefault(cardValue, 0) + cardCountValue);
        }
    }

    /**
     * Calculates the true count based on the running count and the number of decks.
     *
     * @return The calculated true count.
     */
    private double calculateTrueCount() {
        int runningCount = cardCountMap.values().stream().mapToInt(Integer::intValue).sum();
        return (double) runningCount / DECKS;
    }

    /**
     * Calculates the probability of remaining cards for each value.
     *
     * @return A map of card values to their corresponding remaining card probabilities.
     */
    Map<Integer, Double> calculateRemainingCardsProbability() {
        Map<Integer, Double> remainingCardsProbability = new HashMap<>();
        int remainingCards = DECKS * 52 - cardCountMap.size();
        for (int i = 2; i <= 11; i++) {
            int cardsLeft = 4;
            if (cardCountMap.containsKey(i)) {
                cardsLeft -= cardCountMap.get(i);
            }
            remainingCardsProbability.put(i, (double) cardsLeft / remainingCards);
        }
        return remainingCardsProbability;
    }

    /**
     * Calculates the total value of the player's hand.
     *
     * @return The total value of the player's hand.
     */
    int calculateHandValue(int[] playerHand) {
        int sum = 0;
        int numAces = 0;
        for (int cardValue : this.playerHand) {
            if (cardValue == 11) {
                numAces++;
            }
            sum += cardValue;
        }
        while (sum > 21 && numAces > 0) {
            sum -= 10;
            numAces--;
        }
        return sum;
    }
}

/**
 * A utility class for card-related operations.
 */
class CardUtils {
    private static final Map<String, Integer> cardValues = new HashMap<>();

    static {
        cardValues.put("2", 2);
        cardValues.put("3", 3);
        cardValues.put("4", 4);
        cardValues.put("5", 5);
        cardValues.put("6", 6);
        cardValues.put("7", 7);
        cardValues.put("8", 8);
        cardValues.put("9", 9);
        cardValues.put("10", 10);
        cardValues.put("j", 10);
        cardValues.put("q", 10);
        cardValues.put("k", 10);
        cardValues.put("a", 11);
    }

    /**
     * Gets the numerical value of a card based on its input string.
     *
     * @param card The input string representing the card.
     * @return The numerical value of the card.
     */
    public static int getCardValue(String card) {
        return cardValues.getOrDefault(card, 0);
    }

    /**
     * Gets the card counting value based on the numerical card value.
     *
     * @param cardValue The numerical value of the card.
     * @return The card counting value.
     */
    public static int getCardCountValue(int cardValue) {
        if (cardValue >= 2 && cardValue <= 6) {
            return 1;
        } else if (cardValue >= 10) {
            return -1;
        } else {
            return 0;
        }
    }
}

/**
 * The main class that starts the Blackjack game simulation.
 */
public class ImprovedBlackjackGame {
    public static void main(String[] args) {
        BlackjackGame game = new BlackjackGame();
        game.start();
    }
}
