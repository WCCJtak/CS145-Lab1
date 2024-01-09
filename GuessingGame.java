import java.util.Random;
import java.util.Scanner;

/** 
 * GuessingGame.class
 * @Author: JeongGyu Tak, Same Clarke, Nick Ivancovich
 * @Date: 240109
 * @Class: CS&145
 * @Assignment: LAB#1
 * @Purpose: To generate a guessing game using java.util.Random.
 */
public class GuessingGame {
    final static int MAX_NUMBER = 100; // max number of guessing game
    /**
     * This program allows you to play a guessing game.
     * I will think of a number between 1 and 100 and will allow you to guess until you get it.
     * For each guess, I will tell you whether the right answer is higher or lower than your guess.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int gamesPlayed = 0;
        int sumScore = 0;
        int bestScore = Integer.MAX_VALUE; // initialize with max attempt
        showIntro();
        do {
            gamesPlayed++;
            int score = playGame(scanner);
            if (isBetterScore(bestScore, score)) bestScore = score;
            sumScore += score;
        } while (playAgain(scanner)); // break if user does not want to play again.
        showSummary(gamesPlayed, sumScore, bestScore);
        scanner.close();
    }

    /**
     * Play a single guessing game. Returns the score of the game.
     * 
     * @param scanner java.util.Scanner. To receive user input
     * @return int total guesses user made
     */
    public static int playGame(Scanner scanner) {
        Random random = new Random();
        int guessesCount = 0;
        int answer = random.nextInt(MAX_NUMBER);
        System.out.println("I'm thinking of a number between 1 and 100...");
        do {
            guessesCount++;
            System.out.println("Your guess?");
        } while(!isAns(answer, scanner.nextInt())); // compare the guess with answer
        System.out.printf("You got it right in %d guesses.\n", guessesCount); // show score
        return guessesCount;
    }

    /**
     * Returns True if the values are equal.
     * Also prints out if the attempt is higher or lower than the answer.
     * 
     * @param ans answer
     * @param atmpt attempt
     * @return boolean 
     */
    public static boolean isAns(int ans, int atmt) {
        if (ans == atmt){
            return true;
        } else if ((ans > atmt)) {
            System.out.println("It's higher.");
        } else { // answer < attempt
            System.out.println("It's lower.");
        }
        return false;
    }

    /**
     * Prints Intro of guessing game.
     */
    public static void showIntro() {
        System.out.println("This program allows you to play a guessing game.\n"
                        + "I will think of a number between 1 and\n"
                        + "100 and will allow you to guess until\n"
                        + "you get it. For each guess, I will tell you\n"
                        + "whether the right answer is higher or lower\n"
                        + "than your guess.");

    }

    /**
     * Prints the summary of the games from given info.
     * 
     * @param gamesPlayed number of games have played.
     * @param sumScore number of total guesses that user made
     * @param bestScore score of the game with lowest guess of all time.
     */
    public static void showSummary(int gamesPlayed, int sumScore, int bestScore) {
        double avgScore = sumScore/gamesPlayed;
        System.out.println("Overall scores: ");
        System.out.printf("total games: %d\n", gamesPlayed);
        System.out.printf("total guesses: %d\n", sumScore);
        System.out.printf("guesses/game: %.2f\n", avgScore);
        System.out.printf("best game: %d", bestScore);
    }

    /**
     * Ask the user if he wants to continue the game.
     * 
     * @param scanner java.util.Scanner. To receive user input
     * @return
     */
    public static boolean playAgain(Scanner scanner) {
        System.out.println("Do you want to play again? (y/n)");
        String answer = scanner.next();
        if (answer.startsWith("y") || answer.startsWith("Y")) {
            return true;
        } else if (answer.startsWith("n") || answer.startsWith("N")) {
            return false;
        } else {
            System.out.println("Please input (y/n)");
            return playAgain(scanner); // Ask again
        }
    }

    /**
     * Compare the scores of two games.
     * Returns true if the score2 is better than score1.
     * The lower value for score is better on guessing game.
     * 
     * @param score1
     * @param score2
     * @return boolean
     */
    public static boolean isBetterScore(int score1, int score2) {
        if (score1 > score2) {
            return true;
        } 
        return false;
    }
}
