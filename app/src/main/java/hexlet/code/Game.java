package hexlet.code;
import java.util.Random;

public class Game {
    // Игра в четное.
    public static void even() {
        Engine.dispGreetAndInit(1);
        Random generator = new Random();
        int number = generator.nextInt(15) + 1; // Случайное число с генератора, от 1 до 16.
        var counter = 0; // Счетчик правильных ответов.
        var wrongA = "'yes' is wrong answer ;(. Correct answer was 'no'.\nYou have failed, ";
        var wrongB = "'no' is wrong answer ;(. Correct answer was 'yes'.\nYou have failed, ";

        while (counter < 3 && !Engine.gameOver) {
            System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.\nQuestion: " + number);
            String answer = Engine.scanner.nextLine();
            // Проверки на правильность ответа.
            if (number % 2 != 0 && answer.equals("yes")) {
                System.out.println(wrongA + Engine.name);
                Engine.gameOver = true;
            } else if (number % 2 == 0 && answer.equals("no")) {
                System.out.println(wrongB + Engine.name);
                Engine.gameOver = true;
            } else if ((number % 2 == 0 && answer.equals("yes")) || (number % 2 != 0 && answer.equals("no"))) {
                System.out.println("Correct!");
                counter++;
            } else {
                System.out.println("Incorrect input!");
                Engine.gameOver = true;
            }
            number = generator.nextInt(10) + 1;
        }
        if (counter == 3) {
            System.out.println("Congratulations, " + Engine.name + "!");
        }
    }
    public static void calculator() {
        Engine.dispGreetAndInit(1);

        Integer numberA = Engine.generator.nextInt(5) + 1;
        Integer numberB = Engine.generator.nextInt(5) + 1;
        int operationIndex = Engine.generator.nextInt(3) + 1;
        var wrongA = " is wrong answer ;(. Correct answer was ";
        var wrongB = "\nLet's try again, ";

        while (Engine.counter < 3 && !Engine.gameOver) {
            switch (operationIndex) {
                case 1 -> { // sum
                    System.out.println("Question: " + numberA + " + " + numberB);
                    try {
                        String input = Engine.scanner.nextLine();
                        int number = Integer.parseInt(input);
                        if (number == numberA + numberB) {
                            System.out.println("Correct!");
                            Engine.counter++;
                            operationIndex = Engine.generator.nextInt(3) + 1;
                            numberA = Engine.generator.nextInt(5) + 1;
                            numberB = Engine.generator.nextInt(5) + 1;
                        } else {
                            System.out.println(input + wrongA + (numberA * numberB) + wrongB + Engine.name);
                            Engine.gameOver = true;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Incorrect input!");
                        Engine.gameOver = true;
                    }
                }
                case 2 -> { // product
                    System.out.println("Question: " + numberA + " * " + numberB);
                    try {
                        String input = Engine.scanner.nextLine();
                        int number = Integer.parseInt(input);
                        if (number == numberA * numberB) {
                            System.out.println("Correct!");
                            Engine.counter++;
                            operationIndex = Engine.generator.nextInt(3) + 1;
                            numberA = Engine.generator.nextInt(5) + 1;
                            numberB = Engine.generator.nextInt(5) + 1;
                        } else {
                            System.out.println(input + wrongA + (numberA * numberB) + wrongB + Engine.name);
                            Engine.gameOver = true;
                        }
                    }  catch (NumberFormatException e) {
                        System.out.println("Incorrect input!");
                        Engine.gameOver = true;
                    }
                }
                case 3 -> { // substraction
                    System.out.println("Question: " + numberA + " - " + numberB);
                    try {
                        String input = Engine.scanner.nextLine();
                        int number = Integer.parseInt(input);
                        if (number == numberA - numberB) {
                            System.out.println("Correct!");
                            Engine.counter++;
                            operationIndex = Engine.generator.nextInt(3) + 1;
                            numberA = Engine.generator.nextInt(5) + 1;
                            numberB = Engine.generator.nextInt(5) + 1;
                        } else {
                            System.out.println(input + wrongA + (numberA - numberB) + wrongB + Engine.name);
                            Engine.gameOver = true;
                        }
                    }  catch (NumberFormatException e) {
                        System.out.println("Incorrect input!");
                        Engine.gameOver = true;
                    }
                }
            }
        }
        if (!Engine.gameOver) {
            System.out.println("Congratulations, " + Engine.name + "!");
        }
    }
}