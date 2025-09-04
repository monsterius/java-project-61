package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calculator {
    private static final int RANDOM_NUM_MIN = 1;
    private static final int RANDOM_NUM_MAX = 50;

    public static int calculateResult(int num1, int num2, String action) {
        int result = 0;
        switch (action) {
            case " + " -> result =  num1 + num2;
            case  " - " -> result =  num1 - num2;
            case " * " -> result =  num1 * num2;
            default -> System.out.println("");
        }
        return result;
    }
    public static void calculatorGame() {
        // Передача данных в движок
        String[][] gameData = new String[Engine.ROUNDS][2];
        var randomValue1 = Utils.getRandomNumber(RANDOM_NUM_MIN,  RANDOM_NUM_MAX);
        var randomValue2 = Utils.getRandomNumber(RANDOM_NUM_MIN,  RANDOM_NUM_MAX);
        String[] actionList = {" + ", " - ", " * "};
        var actionIndex = Utils.getRandomNumber(RANDOM_NUM_MIN, actionList.length);
        for (int i = 0; i < Engine.ROUNDS; i++) {
            var randAction = actionList[actionIndex - 1];
            int result = calculateResult(randomValue1, randomValue2, randAction);
            gameData[i][0] = "" + randomValue1 + randAction + randomValue2;
            gameData[i][1] = result + "";
            randomValue1 = Utils.getRandomNumber(RANDOM_NUM_MIN,  RANDOM_NUM_MAX);
            randomValue2 = Utils.getRandomNumber(RANDOM_NUM_MIN,  RANDOM_NUM_MAX);
            actionIndex = Utils.getRandomNumber(RANDOM_NUM_MIN, actionList.length);
        }
        // Начало игры
        var question = "What is the result of the expression?";
        Engine.startGame(question, gameData);
    }
}
