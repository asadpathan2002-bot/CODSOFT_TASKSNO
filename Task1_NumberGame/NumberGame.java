import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalRounds = 0;
        int roundsWon = 0;
        int totalAttempts = 0;

        System.out.println("=================================");
        System.out.println("        NUMBER GUESSING GAME      ");
        System.out.println("=================================");

        boolean playAgain = true;

        while (playAgain) {

            totalRounds++;

            int min = 1;
            int max = 100;

            int randomNumber = random.nextInt(max - min + 1) + min;

            int maxAttempts = 7;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + totalRounds);
            System.out.println("---------------------------------");
            System.out.println("I have selected a number between "
                    + min + " and " + max + ".");
            System.out.println("You have " + maxAttempts + " attempts.");
            System.out.println("Try to guess the number!");

            while (attempts < maxAttempts) {

                System.out.print("\nEnter your guess: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    scanner.next();
                    continue;
                }

                int guess = scanner.nextInt();
                attempts++;
                totalAttempts++;

                if (guess < min || guess > max) {
                    System.out.println(
                            "Please enter a number between "
                                    + min + " and " + max + ".");
                    continue;
                }

                if (guess == randomNumber) {

                    guessedCorrectly = true;
                    roundsWon++;

                    int score = (maxAttempts - attempts + 1) * 10;

                    System.out.println("\nCongratulations!");
                    System.out.println("You guessed the correct number.");
                    System.out.println("Number: " + randomNumber);
                    System.out.println("Attempts used: " + attempts);
                    System.out.println("Round score: " + score);

                    break;

                } else if (guess < randomNumber) {

                    System.out.println("Too low! Try a higher number.");

                } else {

                    System.out.println("Too high! Try a lower number.");
                }

                int remaining = maxAttempts - attempts;

                if (remaining > 0) {
                    System.out.println(
                            "Attempts remaining: " + remaining);
                }
            }

            if (!guessedCorrectly) {

                System.out.println("\nRound Over!");
                System.out.println(
                        "You used all " + maxAttempts + " attempts.");
                System.out.println(
                        "The correct number was: " + randomNumber);
            }

            System.out.println("\n=================================");
            System.out.println("             SCOREBOARD            ");
            System.out.println("=================================");
            System.out.println("Rounds played : " + totalRounds);
            System.out.println("Rounds won    : " + roundsWon);
            System.out.println("Total attempts: " + totalAttempts);

            System.out.print("\nDo you want to play another round? (yes/no): ");

            String answer = scanner.next();

            if (!answer.equalsIgnoreCase("yes")
                    && !answer.equalsIgnoreCase("y")) {

                playAgain = false;
            }
        }

        System.out.println("\n=================================");
        System.out.println("        THANK YOU FOR PLAYING     ");
        System.out.println("=================================");
        System.out.println("Final rounds played : " + totalRounds);
        System.out.println("Final rounds won    : " + roundsWon);
        System.out.println("Total attempts      : " + totalAttempts);

        scanner.close();
    }
}