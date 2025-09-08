package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calculator {
    public static int calculateResult(int num1, int num2, String action) {
        int result = 0;
        switch (action) {
            case " + " -> {
                result =  num1 + num2;
            }
            case  " - " -> {
                result =  num1 - num2;
            }
            case " * " -> {
                result =  num1 * num2;
            }
            default -> System.out.println("");
        }
        return result;
    }
    public static void calculatorGame() {
        // Передача данных в движок
        final int randomNumMin = 1;
        final int randomNumMax = 50;
        final int actionIndexMaxBound = 2;
        String[][] gameData = new String[Engine.ROUNDS][2];
        String[] actionList = {" + ", " - ", " * "};
        for (int i = 0; i < Engine.ROUNDS; i++) {
            var randomValue1 = Utils.getRandomNumber(randomNumMin, randomNumMax);
            var randomValue2 = Utils.getRandomNumber(randomNumMin, randomNumMax);
            var actionIndex = Utils.getRandomNumber(randomNumMin, actionIndexMaxBound);
            var randAction = actionList[actionIndex];
            int result = calculateResult(randomValue1, randomValue2, randAction);
            gameData[i][0] = "" + randomValue1 + randAction + randomValue2;
            gameData[i][1] = result + "";
        }
        // Начало игры
        var question = "What is the result of the expression?";
        Engine.startGame(question, gameData);
    }
}
