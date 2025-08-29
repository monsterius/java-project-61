package hexlet.code;

import java.util.Arrays;

public class Game {
    private static final int ROUNDS_TODO = 3;
    private static final int RANDOMBOUNDBIG = 50;
    private static final int RANDOMBOUNDSMALL = 25;
    private static final int RANDOM_ACTION_INDEX = 3;
    private static final int STEP_BOUND = 6;
    private static final int PROGRESSION_SIZE = 9;
    // Игра в четное.
    public static void even() {
        Engine.counter = 0;
        // Передача данных в движок
        int randomValue;
        var even = "yes";
        var odd = "no";
        for (int i = 0; i < Engine.gameDataLength; i++) {
            randomValue = Engine.generator.nextInt(RANDOMBOUNDBIG) + 1;
            Engine.gameData[i][0] = randomValue + "";
            if (randomValue % 2 == 0) {
                Engine.gameData[i][1] = even;
            } else {
                Engine.gameData[i][1] = odd;
            }
        }
        // Начало игры
        Engine.startGame("Answer 'yes' if the number is even, otherwise answer 'no'.");
        while (!Engine.gameOver && Engine.counter < ROUNDS_TODO) {
            Engine.questionIs();
            var userAnswer = Engine.scanner.nextLine();
            Engine.checkAnswer(userAnswer, Engine.gameData[Engine.counter][1]);
        }
        if (!Engine.gameOver) {
            Engine.printCongratMsg();
        }
    }

    public static void calculator() {
        Engine.counter = 0;
        // Передача данных в движок
        var randomValue1 = Engine.generator.nextInt(RANDOMBOUNDBIG) + 1;
        var randomValue2 = Engine.generator.nextInt(RANDOMBOUNDSMALL) + 1;
        int randomAction;
        var action = "";
        int result;
        for (int i = 0; i < Engine.gameDataLength; i++) {
            randomAction = Engine.generator.nextInt(RANDOM_ACTION_INDEX) + 1;
            if (randomAction == 1) {
                action = "+";
            } else if (randomAction == 2) {
                action = "-";
            } else if (randomAction == 3) {
                action = "*";
            }
            switch (action) {
                case "+" -> {
                    Engine.gameData[i][0] = randomValue1 + " " + action + " " + randomValue2;

                    result = randomValue1 + randomValue2;
                    Engine.gameData[i][1] = "" + result;
                }
                case "-" -> {
                    Engine.gameData[i][0] = randomValue1 + " " + action + " " + randomValue2;
                    result = randomValue1 - randomValue2;
                    Engine.gameData[i][1] = "" + result;
                }
                case "*" -> {
                    Engine.gameData[i][0] = randomValue1 + " " + action + " " + randomValue2;
                    result = randomValue1 * randomValue2;
                    Engine.gameData[i][1] = "" + result;
                }
                default -> System.out.println("");
            }
            randomValue1 = Engine.generator.nextInt(RANDOMBOUNDBIG) + 1;
            randomValue2 = Engine.generator.nextInt(RANDOMBOUNDSMALL) + 1;
        }
        // Начало игры
        Engine.startGame("What is the result of the expression?");
        while (!Engine.gameOver && Engine.counter < ROUNDS_TODO) {
            Engine.questionIs();
            var userAnswer = Engine.scanner.nextLine();
            Engine.checkAnswer(userAnswer, Engine.gameData[Engine.counter][1]);
        }
        if (!Engine.gameOver) {
            Engine.printCongratMsg();
        }
    }
    public static void gCD() {
        Engine.counter = 0;
        // Передача данных в движок
        int numberA;
        int numberB;
        int tempVar;
        int gCD;
        for (int i = 0; i < Engine.gameDataLength; i++) {
            numberA = Engine.generator.nextInt(RANDOMBOUNDBIG) + 1;
            numberB = Engine.generator.nextInt(RANDOMBOUNDBIG) + 1;
            Engine.gameData[i][0] = numberA + " " + numberB;
            while (numberB != 0) {
                tempVar = numberA % numberB;
                numberA = numberB;
                numberB = tempVar;
            }
            gCD = numberA;
            Engine.gameData[i][1] = "" + gCD;
        }
        // Начало игры
        Engine.startGame("Find the greatest common divisor of given numbers.");
        while (!Engine.gameOver && Engine.counter < ROUNDS_TODO) {
            Engine.questionIs();
            var userAnswer = Engine.scanner.nextLine();
            Engine.checkAnswer(userAnswer, Engine.gameData[Engine.counter][1]);
        }
        if (!Engine.gameOver) {
            Engine.printCongratMsg();
        }
    }
    public static void progression() {
        Engine.counter = 0;
        // Передача данных в движок
        for (int i = 0; i < Engine.gameDataLength; i++) {
            String[] list = new String[PROGRESSION_SIZE];
            var lostNumber = Engine.generator.nextInt(list.length);
            var firstNumber = Engine.generator.nextInt(RANDOMBOUNDSMALL);
            var step = Engine.generator.nextInt(STEP_BOUND) + 1;
            list[0] = firstNumber + "";
            for (int b = 1; b < list.length; b++) {
                list[b] = Integer.parseInt(list[b - 1]) + step + "";
            }
            Engine.gameData[i][1] = list[lostNumber];
            var stringArray = Arrays.toString(list).replace(list[lostNumber], "..");
            stringArray = stringArray.replace("[", "").replace("]", "");
            Engine.gameData[i][0] =  stringArray.replace(",", "");
        }
        // Начало игры
        Engine.startGame("What number is missing in the progression?");
        while (!Engine.gameOver && Engine.counter < ROUNDS_TODO) {
            Engine.questionIs();
            var userAnswer = Engine.scanner.nextLine();
            Engine.checkAnswer(userAnswer, Engine.gameData[Engine.counter][1]);
        }
        if (!Engine.gameOver) {
            Engine.printCongratMsg();
        }
    }
    public static void prime() {
        Engine.counter = 0;
        // Передача данных в движок
        int randomNumber;
        for (int i = 0; i < Engine.gameDataLength; i++) {
            randomNumber = Engine.generator.nextInt(RANDOMBOUNDBIG) + 1;
            boolean numIsPrime = Misc.isPrime(randomNumber);
            if (numIsPrime) {
                Engine.gameData[i][0] = "" + randomNumber;
                Engine.gameData[i][1] = "yes";
            } else {
                Engine.gameData[i][0] = "" + randomNumber;
                Engine.gameData[i][1] = "no";
            }
        }
        // Начало игры
        Engine.startGame("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        while (!Engine.gameOver && Engine.counter < ROUNDS_TODO) {
            Engine.questionIs();
            var userAnswer = Engine.scanner.nextLine();
            Engine.checkAnswer(userAnswer, Engine.gameData[Engine.counter][1]);
        }
        if (!Engine.gameOver) {
            Engine.printCongratMsg();
        }
    }
}
