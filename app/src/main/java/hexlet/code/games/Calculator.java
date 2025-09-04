package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calculator {
    private static final int RANDOMBOUNDBIG = 50;
    private static final int RANDOMBOUNDSMALL = 25;

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
        var randomValue1 = Utils.getRandomNumber(RANDOMBOUNDBIG);
        var randomValue2 = Utils.getRandomNumber(RANDOMBOUNDSMALL);
        String[] actionList = {" + ", " - ", " * "};
        var actionIndex = Utils.getRandomNumber(actionList.length);
        for (int i = 0; i < Engine.ROUNDS; i++) {
            var randAction = actionList[actionIndex - 1];
            int result = calculateResult(randomValue1, randomValue2, randAction);
            gameData[i][0] = "" + randomValue1 + randAction + randomValue2;
            gameData[i][1] = result + "";
            randomValue1 = Utils.getRandomNumber(RANDOMBOUNDBIG);
            randomValue2 = Utils.getRandomNumber(RANDOMBOUNDSMALL);
            actionIndex = Utils.getRandomNumber(actionList.length);
        }
        // Начало игры
        var question = "What is the result of the expression?";
        Engine.startGame(question, gameData);
    }
}
