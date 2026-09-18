import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication {

    static class Question {
        String question;
        String[] options;
        int correctAnswer;

        Question(String question, String[] options, int correctAnswer) {
            this.question = question;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }
    }

    private static final int TIME_LIMIT_SECONDS = 30;

    private static final Question[] questions = {

        new Question(
                "Which language is primarily used for Android development?",
                new String[]{
                        "Python",
                        "Java",
                        "HTML",
                        "SQL"
                },
                2
        ),

        new Question(
                "Which keyword is used to inherit a class in Java?",
                new String[]{
                        "implements",
                        "extends",
                        "inherits",
                        "super"
                },
                2
        ),

        new Question(
                "Which collection does not allow duplicate elements?",
                new String[]{
                        "List",
                        "ArrayList",
                        "Set",
                        "LinkedList"
                },
                3
        ),

        new Question(
                "Which method is the entry point of a Java application?",
                new String[]{
                        "start()",
                        "run()",
                        "main()",
                        "execute()"
                },
                3
        ),

        new Question(
                "Which SQL command is used to retrieve data?",
                new String[]{
                        "INSERT",
                        "SELECT",
                        "UPDATE",
                        "DELETE"
                },
                2
        )
    };

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int score = 0;

        System.out.println("======================================");
        System.out.println("          QUIZ APPLICATION            ");
        System.out.println("======================================");

        System.out.println("\nInstructions:");
        System.out.println("- Each question has 4 options.");
        System.out.println("- Enter 1, 2, 3, or 4.");
        System.out.println("- You have " + TIME_LIMIT_SECONDS
                + " seconds for each question.");
        System.out.println("- Correct answer = 1 point.");

        System.out.println("\nPress ENTER to start the quiz...");

        scanner.nextLine();

        for (int i = 0; i < questions.length; i++) {

            System.out.println("\n--------------------------------------");
            System.out.println("Question " + (i + 1)
                    + " of " + questions.length);
            System.out.println("--------------------------------------");

            Question q = questions[i];

            System.out.println(q.question);

            for (int j = 0; j < q.options.length; j++) {
                System.out.println(
                        (j + 1) + ". " + q.options[j]
                );
            }

            int answer = getAnswerWithTimer();

            if (answer == q.correctAnswer) {
                System.out.println("Correct!");
                score++;
            } else if (answer == -1) {
                System.out.println("Time's up!");
                System.out.println(
                        "Correct answer: "
                                + q.correctAnswer
                                + ". "
                                + q.options[q.correctAnswer - 1]
                );
            } else {
                System.out.println("Incorrect.");

                System.out.println(
                        "Correct answer: "
                                + q.correctAnswer
                                + ". "
                                + q.options[q.correctAnswer - 1]
                );
            }
        }

        displayResult(score);
    }

    private static int getAnswerWithTimer() {

        final int[] answer = {-1};

        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                System.out.println("\nTime limit reached!");

                answer[0] = -1;

                System.exit(0);
            }
        };

        timer.schedule(task, TIME_LIMIT_SECONDS * 1000L);

        while (true) {

            System.out.print("Your answer: ");

            if (scanner.hasNextInt()) {

                int input = scanner.nextInt();

                if (input >= 1 && input <= 4) {

                    answer[0] = input;

                    timer.cancel();

                    return answer[0];
                }

                System.out.println(
                        "Please enter a number between 1 and 4."
                );

            } else {

                System.out.println(
                        "Please enter a valid number."
                );

                scanner.next();
            }
        }
    }

    private static void displayResult(int score) {

        int total = questions.length;

        double percentage =
                ((double) score / total) * 100;

        System.out.println("\n======================================");
        System.out.println("             QUIZ RESULT              ");
        System.out.println("======================================");

        System.out.println("Total Questions : " + total);
        System.out.println("Correct Answers : " + score);
        System.out.println("Wrong Answers   : " + (total - score));

        System.out.printf(
                "Percentage      : %.2f%%%n",
                percentage
        );

        System.out.println("--------------------------------------");

        if (percentage >= 80) {
            System.out.println("Performance     : Excellent!");
        } else if (percentage >= 60) {
            System.out.println("Performance     : Good!");
        } else if (percentage >= 40) {
            System.out.println("Performance     : Average");
        } else {
            System.out.println("Performance     : Needs Improvement");
        }

        System.out.println("======================================");

        scanner.close();
    }
}