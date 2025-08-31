package hexlet.code.games;

import hexlet.code.Engine;

public class Even {
    private static final int ROUNDS_TODO = 3;
    private static final int RANDOMBOUNDBIG = 50;
    // Игра в четное.
    public static void evenGame() {
        // Передача данных в движок
        int randomValue;
        var even = "yes";
        var odd = "no";
        for (int i = 0; i < Engine.GAME_DATA_BASE.length; i++) {
            randomValue = Engine.RANDOM_NUM_GENERATOR.nextInt(RANDOMBOUNDBIG) + 1;
            Engine.GAME_DATA_BASE[i][0] = randomValue + "";
            if (randomValue % 2 == 0) {
                Engine.GAME_DATA_BASE[i][1] = even;
            } else {
                Engine.GAME_DATA_BASE[i][1] = odd;
            }
        }
        // Начало игры
        Engine.startGame("Answer 'yes' if the number is even, otherwise answer 'no'.");
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
