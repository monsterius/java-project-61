package hexlet.code;

import java.util.Arrays;

public class Game {
    // Игра в четное.
    public static void even() {
        Engine.dispGreetAndInit(1);

        int number = Engine.generator.nextInt(15) + 1; // Случайное число с генератора, от 1 до 16.
        var wrongA = "'yes' is wrong answer ;(. Correct answer was 'no'.\nYou have failed, ";
        var wrongB = "'no' is wrong answer ;(. Correct answer was 'yes'.\nYou have failed, ";

        while (Engine.counter < 3 && !Engine.gameOver) {
            System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.\nQuestion: " + number);
            Engine.input = Engine.scanner.nextLine();
            // Проверки на правильность ответа.
            if (number % 2 != 0 && Engine.input.equals("yes")) {
                System.out.println(wrongA + Engine.name);
                Engine.gameOver = true;
            } else if (number % 2 == 0 && Engine.input.equals("no")) {
                System.out.println(wrongB + Engine.name);
                Engine.gameOver = true;
            } else if (number % 2 == 0 && Engine.input.equals("yes")) {
                System.out.println(Engine.correctInput);
                Engine.counter++;
            } else if (number % 2 != 0 && Engine.input.equals("no")) {
                System.out.println(Engine.correctInput);
                Engine.counter++;
            } else {
                System.out.println(Engine.error);
                Engine.gameOver = true;
            }
            number = Engine.generator.nextInt(10) + 1;
        }
        if (Engine.counter == 3) {
            System.out.println("Congratulations, " + Engine.name + "!");
        }
    }
    // Игра Калькулятор.
    public static void calculator() {
        Engine.dispGreetAndInit(2);

        Integer numberA = Engine.generator.nextInt(5) + 1;
        Integer numberB = Engine.generator.nextInt(5) + 1;
        int operationIndex = Engine.generator.nextInt(3) + 1;
        var wrongA = " is wrong answer ;(. Correct answer was ";
        var wrongB = "\nLet's try again, " + Engine.name;
        var wrong = "Your answer: ";
        while (Engine.counter < 3 && !Engine.gameOver) {
            switch (operationIndex) {
                case 1 -> { // sum
                    System.out.println("Question: " + numberA + " + " + numberB);
                    try {
                        Engine.input = Engine.scanner.nextLine();
                        int number = Integer.parseInt(Engine.input);
                        if (number == numberA + numberB) {
                            System.out.println(Engine.correctInput);
                            Engine.counter++;
                            operationIndex = Engine.generator.nextInt(3) + 1;
                            numberA = Engine.generator.nextInt(5) + 1;
                            numberB = Engine.generator.nextInt(5) + 1;
                        } else {
                            var result = Engine.encloseInt(numberA + numberB);
                            System.out.println(wrong + Engine.input);
                            System.out.println(Engine.encloseStr(Engine.input) + wrongA + result + wrongB);
                            Engine.gameOver = true;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println(Engine.error);
                        Engine.gameOver = true;
                    }
                }
                case 2 -> { // product
                    System.out.println("Question: " + numberA + " * " + numberB);
                    try {
                        Engine.input = Engine.scanner.nextLine();
                        int number = Integer.parseInt(Engine.input);
                        if (number == numberA * numberB) {
                            System.out.println(Engine.correctInput);
                            Engine.counter++;
                            operationIndex = Engine.generator.nextInt(3) + 1;
                            numberA = Engine.generator.nextInt(5) + 1;
                            numberB = Engine.generator.nextInt(5) + 1;
                        } else {
                            var result = Engine.encloseInt(numberA * numberB);
                            System.out.println(wrong + Engine.input);
                            System.out.println(Engine.encloseStr(Engine.input) + wrongA + result + wrongB);
                            Engine.gameOver = true;
                        }
                    }  catch (NumberFormatException e) {
                        System.out.println(Engine.error);
                        Engine.gameOver = true;
                    }
                }
                case 3 -> { // substraction
                    System.out.println("Question: " + numberA + " - " + numberB);
                    try {
                        Engine.input = Engine.scanner.nextLine();
                        int number = Integer.parseInt(Engine.input);
                        if (number == numberA - numberB) {
                            System.out.println(Engine.correctInput);
                            Engine.counter++;
                            operationIndex = Engine.generator.nextInt(3) + 1;
                            numberA = Engine.generator.nextInt(5) + 1;
                            numberB = Engine.generator.nextInt(5) + 1;
                        } else {
                            var result = Engine.encloseInt(numberA - numberB);
                            System.out.println(wrong + Engine.input);
                            System.out.println(Engine.encloseStr(Engine.input) + wrongA + result + wrongB);
                            Engine.gameOver = true;
                        }
                    }  catch (NumberFormatException e) {
                        System.out.println(Engine.error);
                        Engine.gameOver = true;
                    }
                }
            }
        }
        if (!Engine.gameOver) {
            System.out.println("Congratulations, " + Engine.name + "!");
        }
    }
    // Игра НОД.
    public static void greatestCommonDivisor() {
        Engine.dispGreetAndInit(3);

        var numberA = Engine.generator.nextInt(99) + 1;
        var numberB = Engine.generator.nextInt(99) + 1;
        var wrongA = " is wrong answer ;(. Correct answer was ";
        var wrongB = "\nLet's try again, " + Engine.name;
        int tempVar = numberB;
        Integer gCD;
        while (Engine.counter < 3 && !Engine.gameOver) {
            System.out.println("Question: " + numberA + " " + numberB);
            Engine.input = Engine.scanner.nextLine();
            try {
                Integer.parseInt(Engine.input);
            } catch (NumberFormatException e) {
                System.out.println(Engine.error);
                Engine.gameOver = true;
                break;
            }
            while (numberB != 0) { // Определение НОД
                tempVar = numberA % numberB;
                numberA = numberB;
                numberB = tempVar;
            }
            gCD = numberA;

            if (Engine.input.equals(gCD.toString())) {
                System.out.println(Engine.correctInput);
                Engine.counter++;
                numberA = Engine.generator.nextInt(99) + 1;
                numberB = Engine.generator.nextInt(99) + 1;
            } else if (!Engine.input.equals(gCD.toString())) {
                var result = Engine.encloseInt(gCD);
                System.out.println(Engine.encloseStr(Engine.input) + wrongA + result + wrongB);
                Engine.gameOver = true;
            }
        }
        if (!Engine.gameOver) {
            System.out.println("Congratulations, " + Engine.name + "!");
        }
    }
    // Игра Прогрессия.
    public static void progression() {
        Engine.dispGreetAndInit(4);

        String lostNumber;
        var index = Engine.generator.nextInt(8) + 1;
        var wrongA = " is wrong answer ;(. Correct answer was ";
        var wrongB = "\nLet's try again, " + Engine.name;
        while (Engine.counter < 3 && !Engine.gameOver) {
            String[] array = Engine.generateList();
            lostNumber = array[index];
            array[index] = "..";
            var formatedProg = Arrays.toString(array).replace("[", "").replace("]", "").replace(",", "");
            System.out.println("Question: " + formatedProg);
            Engine.input = Engine.scanner.nextLine();
            try  {
                Integer.parseInt(Engine.input);
            } catch (NumberFormatException e) {
                System.out.println(Engine.error);
                Engine.gameOver = true;
                break;
            }
            if (Engine.input.equals(lostNumber)) {
                System.out.println(Engine.correctInput);
                Engine.counter++;
            } else if (!Engine.input.equals(lostNumber)) {
                var result = Engine.encloseStr(lostNumber);
                System.out.println(Engine.encloseStr(Engine.input) + wrongA + result + wrongB);
                Engine.gameOver = true;
            }
        }
        if (!Engine.gameOver) {
            System.out.println("Congratulations, " + Engine.name + "!");
        }
    }
    public static void prime() {
        Engine.dispGreetAndInit(5);

        var number = Engine.generator.nextInt(120) + 1;
        var wrongA = "'yes' is wrong answer ;(. Correct answer was 'no'.\nYou have failed, ";
        var wrongB = "'no' is wrong answer ;(. Correct answer was 'yes'.\nYou have failed, ";
        while (Engine.counter < 3 && !Engine.gameOver) {
            System.out.println("Question: " + number);
            Engine.input = Engine.scanner.nextLine();
            if (Engine.input.equals("yes") && Engine.isPrime(number)) {
                System.out.println(Engine.correctInput);
                Engine.counter++;
                number = Engine.generator.nextInt(499) + 1;
            } else if (Engine.input.equals("no") && !Engine.isPrime(number)) {
                System.out.println(Engine.correctInput);
                Engine.counter++;
                number = Engine.generator.nextInt(499) + 1;
            } else if (Engine.input.equals("no") && Engine.isPrime(number)) {
                System.out.println(wrongB + Engine.name);
                Engine.gameOver = true;
            } else if (Engine.input.equals("yes") && !Engine.isPrime(number)) {
                System.out.println(wrongA + Engine.name);
                Engine.gameOver = true;
            } else {
                System.out.println(Engine.error);
                Engine.gameOver = true;
            }
        }
        if (!Engine.gameOver) {
            System.out.println("Congratulations, " + Engine.name + "!");
        }
    }
}