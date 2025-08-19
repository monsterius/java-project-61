package hexlet.code;
import java.util.Random;
import java.util.Scanner;

public class Game {
    // Игра в четное.
    public static void even() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("May I have your name?");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");

        Random generator = new Random();
        int number = generator.nextInt(15) + 1; // Случайное число с генератора, от 1 до 15.
        var counter = 0; // Счетчик правильных ответов.
        while (counter < 3) {
            System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.\nQuestion: " + number);
            String answer = scanner.nextLine();
            // Проверки на правильность ответа.
            if (number % 2 != 0 && answer.equals("yes")) {
                System.out.println("'yes' is wrong answer ;(. Correct answer was 'no'.\nLet's try again, " + name);
            } else if (number % 2 != 0 && answer.equals("no")) {
                System.out.println("Correct!");
                counter++;
            } else if (number % 2 == 0 && answer.equals("yes")) {
                System.out.println("Correct!");
                counter++;
            } else if (number % 2 == 0 && answer.equals("no")) {
                System.out.println("'no' is wrong answer ;(. Correct answer was 'yes'.\nLet's try again, " + name);
            } else {
                System.out.println("Incorrect input!");
            }
            number = generator.nextInt(10) + 1;
        }
        if (counter == 3) {
            System.out.println("Congratulations, " + name + "!");
        }
    }
}
