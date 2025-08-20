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
        int number = generator.nextInt(15) + 1; // Случайное число с генератора, от 1 до 16.
        var counter = 0; // Счетчик правильных ответов.
        boolean lost = false;

        while (counter < 3 && !lost) {
            System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.\nQuestion: " + number);
            String answer = scanner.nextLine();
            // Проверки на правильность ответа.
            if (number % 2 != 0 && answer.equals("yes")) {
                System.out.println("'yes' is wrong answer ;(. Correct answer was 'no'.\nYou have failed, " + name);
                lost = true;
            } else if (number % 2 == 0 && answer.equals("no")) {
                System.out.println("'no' is wrong answer ;(. Correct answer was 'yes'.\nYou have failed, " + name);
                lost = true;
            } else if ((number % 2 == 0 && answer.equals("yes")) || (number % 2 != 0 && answer.equals("no"))) {
                System.out.println("Correct!");
                counter++;
            } else {
                System.out.println("Incorrect input!");
                lost = true;
            }
            number = generator.nextInt(10) + 1;
        }
        if (counter == 3) {
            System.out.println("Congratulations, " + name + "!");
        }
    }
    public static void calculator() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("May I have your name?");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!\nWhat is the result of the expression?");

        Random generator = new Random();
        Integer numberA = generator.nextInt(5) + 1;
        Integer numberB = generator.nextInt(5) + 1;
        int operationIndex = generator.nextInt(3) + 1;
        int counter = 0;
        boolean lost = false;

        while (counter < 3 && !lost) {
            switch (operationIndex) {
                case 1 -> { // sum
                    System.out.println("Question: " + numberA + " + " + numberB);
                    try {
                        String input = scanner.nextLine();
                        int number = Integer.parseInt(input);
                        if (number == numberA + numberB) {
                            System.out.println("Correct!");
                            counter++;
                            operationIndex = generator.nextInt(3) + 1;
                            numberA = generator.nextInt(5) + 1;
                            numberB = generator.nextInt(5) + 1;
                        } else {
                            System.out.println(input + " is wrong answer ;(. Correct answer was " + (numberA * numberB) + "\nLet's try again, " + name);
                            lost = true;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Incorrect input!");
                        lost = true;
                    }
                }
                case 2 -> { // product
                    System.out.println("Question: " + numberA + " * " + numberB);
                    try {
                        String input = scanner.nextLine();
                        int number = Integer.parseInt(input);
                        if (number == numberA * numberB) {
                            System.out.println("Correct!");
                            counter++;
                            operationIndex = generator.nextInt(3) + 1;
                            numberA = generator.nextInt(5) + 1;
                            numberB = generator.nextInt(5) + 1;
                        } else {
                            System.out.println(input + " is wrong answer ;(. Correct answer was " + (numberA * numberB) + "\nLet's try again, " + name);
                            lost = true;
                        }
                    }  catch (NumberFormatException e) {
                        System.out.println("Incorrect input!");
                        lost = true;
                    }
                }
                case 3 -> { // substraction
                    System.out.println("Question: " + numberA + " - " + numberB);
                    try {
                        String input = scanner.nextLine();
                        int number = Integer.parseInt(input);
                        if (number == numberA - numberB) {
                            System.out.println("Correct!");
                            counter++;
                            operationIndex = generator.nextInt(3) + 1;
                            numberA = generator.nextInt(5) + 1;
                            numberB = generator.nextInt(5) + 1;
                        } else {
                            System.out.println(input + " is wrong answer ;(. Correct answer was " + (numberA - numberB) + "\nLet's try again, " + name);
                            lost = true;
                        }
                    }  catch (NumberFormatException e) {
                        System.out.println("Incorrect input!");
                        lost = true;
                    }
                }
            }
        }
        if (!lost) {
            System.out.println("Congratulations, " + name + "!");
        }
    }
}