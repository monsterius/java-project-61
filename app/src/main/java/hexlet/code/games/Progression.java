package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Arrays;

public class Progression {
    private static final int ROUNDS_TODO = 3;
    private static final int RANDOMBOUNDSMALL = 25;
    private static final int STEP_BOUND = 6;
    private static final int PROGRESSION_SIZE = 9;
    public static void progressionGame() {
        // Передача данных в движок
        for (int i = 0; i < Engine.GAME_DATA_BASE.length; i++) {
            String[] list = new String[PROGRESSION_SIZE];
            var lostNumber = Engine.RANDOM_NUM_GENERATOR.nextInt(list.length);
            var firstNumber = Engine.RANDOM_NUM_GENERATOR.nextInt(RANDOMBOUNDSMALL);
            var step = Engine.RANDOM_NUM_GENERATOR.nextInt(STEP_BOUND) + 1;
            list[0] = firstNumber + "";
            for (int b = 1; b < list.length; b++) {
                list[b] = Integer.parseInt(list[b - 1]) + step + "";
            }
            Engine.GAME_DATA_BASE[i][1] = list[lostNumber];
            list[lostNumber] = "..";
            var progression = Arrays.toString(list);
            progression = progression.replace("[", "").replace("]", "");
            Engine.GAME_DATA_BASE[i][0] =  progression.replace(",", "");
        }
        // Начало игры
        Engine.startGame("What number is missing in the progression?");
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
