package hexlet.code.games;

import hexlet.code.Engine;

public class Gcd {
    private static final int ROUNDS_TODO = 3;
    private static final int RANDOMBOUNDBIG = 50;
    public static void gCDGame() {
        // Передача данных в движок
        int numberA;
        int numberB;
        int tempVar;
        int gCD;
        for (int i = 0; i < Engine.GAME_DATA_BASE.length; i++) {
            numberA = Engine.RANDOM_NUM_GENERATOR.nextInt(RANDOMBOUNDBIG) + 1;
            numberB = Engine.RANDOM_NUM_GENERATOR.nextInt(RANDOMBOUNDBIG) + 1;
            Engine.GAME_DATA_BASE[i][0] = numberA + " " + numberB;
            while (numberB != 0) {
                tempVar = numberA % numberB;
                numberA = numberB;
                numberB = tempVar;
            }
            gCD = numberA;
            Engine.GAME_DATA_BASE[i][1] = "" + gCD;
        }
        // Начало игры
        Engine.startGame("Find the greatest common divisor of given numbers.");
        while (!Engine.getGameOverStatus() && Engine.getCurrentGameStage() < ROUNDS_TODO) {
            Engine.questionIs();
            var userInput = Engine.getUserInput();
            Engine.checkAnswer(userInput, Engine.GAME_DATA_BASE[Engine.getCurrentGameStage()][1]);
        }
        if (!Engine.getGameOverStatus()) {
            Engine.printCongratMsg();
        }
    }
}
