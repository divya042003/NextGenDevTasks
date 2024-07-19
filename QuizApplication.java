import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication {
    private static final int TIME_LIMIT = 30; // seconds
    private static boolean timeUp = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] questions = {
            "What is the capital of France?",
            "What is 9 + 10?",
            "Who wrote 'To Kill a Mockingbird'?"
        };
        String[][] options = {
            {"1) Berlin", "2) Madrid", "3) Paris", "4) Rome"},
            {"1) 18", "2) 19", "3) 20", "4) 21"},
            {"1) Harper Lee", "2) Mark Twain", "3) J.K. Rowling", "4) Jane Austen"}
        };
        int[] answers = {3, 2, 1}; // Correct answers

        int score = 0;

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                timeUp = true;
            }
        }, TIME_LIMIT * 1000);

        System.out.println("Welcome to the Quiz! You have " + TIME_LIMIT + " seconds to complete.");

        for (int i = 0; i < questions.length; i++) {
            if (timeUp) {
                System.out.println("\nTime's up!");
                break;
            }

            System.out.println("\n" + (i + 1) + ". " + questions[i]);
            for (String option : options[i]) {
                System.out.println(option);
            }
            System.out.print("Your answer: ");

            int userAnswer = scanner.nextInt();

            if (userAnswer == answers[i]) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Wrong!");
            }
        }

        timer.cancel();
        System.out.println("\nQuiz over! Your score: " + score + " out of " + questions.length);
        scanner.close();
    }
}
