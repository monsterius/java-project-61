package hexlet.code.games;

import hexlet.code.Engine;

public class Calculator {
    private static final int RANDOMBOUNDBIG = 50;
    private static final int RANDOMBOUNDSMALL = 25;

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
            default -> {
                System.out.println("");
            }
        }
        return result;
    }
    public static void calculatorGame() {
        // Передача данных в движок
        String[][] gameData = new String[Engine.ROUNDS][2];
        var randomValue1 = Engine.RANDOM_NUM_GENERATOR.nextInt(RANDOMBOUNDBIG) + 1;
        var randomValue2 = Engine.RANDOM_NUM_GENERATOR.nextInt(RANDOMBOUNDSMALL) + 1;
        String[] actionList = {" + ", " - ", " * "};
        var actionIndex = Engine.RANDOM_NUM_GENERATOR.nextInt(actionList.length) + 1;
        for (int i = 0; i < Engine.ROUNDS; i++) {
            var randAction = actionList[actionIndex - 1];
            int result = calculateResult(randomValue1, randomValue2, randAction);
            gameData[i][0] = "" + randomValue1 + randAction + randomValue2;
            gameData[i][1] = result + "";
            randomValue1 = Engine.RANDOM_NUM_GENERATOR.nextInt(RANDOMBOUNDBIG) + 1;
            randomValue2 = Engine.RANDOM_NUM_GENERATOR.nextInt(RANDOMBOUNDSMALL) + 1;
            actionIndex = Engine.RANDOM_NUM_GENERATOR.nextInt(actionList.length) + 1;
        }
        // Начало игры
        var question = "What is the result of the expression?";
        Engine.startGame(question, gameData);
    }
}
