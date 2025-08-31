package hexlet.code.games;

import hexlet.code.Engine;

public class Calculator {
    private static final int ROUNDS_TODO = 3;
    private static final int RANDOMBOUNDBIG = 50;
    private static final int RANDOMBOUNDSMALL = 25;
    private static final int RANDOM_ACTION_INDEX = 3;
    public static void calculatorGame() {
        // Передача данных в движок
        var randomValue1 = Engine.RANDOM_NUM_GENERATOR.nextInt(RANDOMBOUNDBIG) + 1;
        var randomValue2 = Engine.RANDOM_NUM_GENERATOR.nextInt(RANDOMBOUNDSMALL) + 1;
        int randomAction;
        var action = "";
        int result;
        for (int i = 0; i < Engine.GAME_DATA_BASE.length; i++) {
            randomAction = Engine.RANDOM_NUM_GENERATOR.nextInt(RANDOM_ACTION_INDEX) + 1;
            if (randomAction == RANDOM_ACTION_INDEX - 2) {
                action = "+";
            } else if (randomAction == RANDOM_ACTION_INDEX - 1) {
                action = "-";
            } else if (randomAction == RANDOM_ACTION_INDEX) {
                action = "*";
            }
            switch (action) {
                case "+" -> {
                    Engine.GAME_DATA_BASE[i][0] = randomValue1 + " " + action + " " + randomValue2;

                    result = randomValue1 + randomValue2;
                    Engine.GAME_DATA_BASE[i][1] = "" + result;
                }
                case "-" -> {
                    Engine.GAME_DATA_BASE[i][0] = randomValue1 + " " + action + " " + randomValue2;
                    result = randomValue1 - randomValue2;
                    Engine.GAME_DATA_BASE[i][1] = "" + result;
                }
                case "*" -> {
                    Engine.GAME_DATA_BASE[i][0] = randomValue1 + " " + action + " " + randomValue2;
                    result = randomValue1 * randomValue2;
                    Engine.GAME_DATA_BASE[i][1] = "" + result;
                }
                default -> System.out.println("");
            }
            randomValue1 = Engine.RANDOM_NUM_GENERATOR.nextInt(RANDOMBOUNDBIG) + 1;
            randomValue2 = Engine.RANDOM_NUM_GENERATOR.nextInt(RANDOMBOUNDSMALL) + 1;
        }
        // Начало игры
        Engine.startGame("What is the result of the expression?");
        while (!Engine.getGameOverStatus() && Engine.getCurrentGameStage() < ROUNDS_TODO) {
            Engine.askQuestion();
            var userInput = Engine.getUserInput();
            Engine.checkAnswer(userInput, Engine.GAME_DATA_BASE[Engine.getCurrentGameStage()][1]);
        }
        if (!Engine.getGameOverStatus()) {
            Engine.printCongratMsg();
        }
    }
}
