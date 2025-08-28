package hexlet.code;

import java.util.Arrays;

public class Game {
    // Игра в четное.
    public static void even() {
        Engine.counter = 0;
        // Передача данных в движок
        int randomValue;
        var even = "yes";
        var odd = "no";
        for (int i = 0; i < 3; i++) {
            randomValue = Engine.generator.nextInt(50) + 1;
            Engine.gameData[i][0] = randomValue + "";
            if (randomValue % 2 == 0) {
                Engine.gameData[i][1] = even;
            } else {
                Engine.gameData[i][1] = odd;
            }
        }
        // Начало игры
        Engine.startGame("Answer 'yes' if the number is even, otherwise answer 'no'.");
        while (!Engine.gameOver && Engine.counter < 3) {
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
        var randomValue1 = Engine.generator.nextInt(25) + 1;
        var randomValue2 = Engine.generator.nextInt(10) + 1;
        int randomAction;
        var action = "";
        int result;
        for (int i = 0; i < 3; i++) {
            randomAction = Engine.generator.nextInt(3) + 1;
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
            randomValue1 = Engine.generator.nextInt(25) + 1;
            randomValue2 = Engine.generator.nextInt(10) + 1;
        }
        // Начало игры
        Engine.startGame("What is the result of the expression?");
        while (!Engine.gameOver && Engine.counter < 3) {
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
        for (int i = 0; i < 3; i++) {
            numberA = Engine.generator.nextInt(40) + 1;
            numberB = Engine.generator.nextInt(40) + 1;
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
        while (!Engine.gameOver && Engine.counter < 3) {
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
        for (int i = 0; i < 3; i++) {
            String[] list = new String[9];
            var lostNumber = Engine.generator.nextInt(list.length);
            var firstNumber = Engine.generator.nextInt(15);
            var step = Engine.generator.nextInt(6) + 1;
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
        while (!Engine.gameOver && Engine.counter < 3) {
            Engine.questionIs();
            var userAnswer = Engine.scanner.nextLine();
            Engine.checkAnswer(userAnswer, Engine.gameData[Engine.counter][1]);
        }
        if (!Engine.gameOver) {
            Engine.printCongratMsg();
        }
    }
}
