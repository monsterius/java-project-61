package hexlet.code.games;

import hexlet.code.Engine;

public class Calculator {
    private static final int RANDOMBOUNDBIG = 50;
    private static final int RANDOMBOUNDSMALL = 25;

    public static String[] calculateResult(int num1, int num2, String action) {
        String[] result = new  String[2];
        switch (action) {
            case "+" -> {
                result[0] = num1 + " + " + num2;
                result[1] = num1 + num2 + "";
            }
            case  "-" -> {
                result[0] = num1 + " - " + num2;
                result[1] = num1 - num2 + "";
            }
            case "*" -> {
                result[0] = num1 + " * " + num2;
                result[1] = num1 * num2 + "";
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
        String[] actionList = {"+", "-", "*"};
        var action = Engine.RANDOM_NUM_GENERATOR.nextInt(actionList.length) + 1;
        for (int i = 0; i < Engine.ROUNDS; i++) {
            String[] result = calculateResult(randomValue1, randomValue2, actionList[action - 1]);
            gameData[i][0] = result[0];
            gameData[i][1] = result[1];
            randomValue1 = Engine.RANDOM_NUM_GENERATOR.nextInt(RANDOMBOUNDBIG) + 1;
            randomValue2 = Engine.RANDOM_NUM_GENERATOR.nextInt(RANDOMBOUNDSMALL) + 1;
            action = Engine.RANDOM_NUM_GENERATOR.nextInt(actionList.length) + 1;
        }
        // Начало игры
        var question = "What is the result of the expression?";
        Engine.startGame(question, gameData);
    }
}
