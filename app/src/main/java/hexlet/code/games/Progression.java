package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Arrays;

public class Progression {
    private static final int RANDOMBOUNDSMALL = 25;
    private static final int STEP_BOUND = 6;
    private static final int PROGRESSION_SIZE = 10;

    public static String[] calculateProgression() {
        String[] array = new String[PROGRESSION_SIZE];
        String progression;
        String[] result = new String[2];
        String numToLook;
        var lostNumber = Engine.RANDOM_NUM_GENERATOR.nextInt(array.length);
        var firstNumber = Engine.RANDOM_NUM_GENERATOR.nextInt(RANDOMBOUNDSMALL);
        var step = Engine.RANDOM_NUM_GENERATOR.nextInt(STEP_BOUND) + 1;
        array[0] = firstNumber + "";
        for (int i = 1; i < array.length; i++) {
            array[i] = Integer.parseInt(array[i - 1]) + step + "";
        }
        numToLook = array[lostNumber];
        array[lostNumber] = "..";
        progression = Arrays.toString(array).replace("[", "").replace("]", "").replace(",", "");
        result[0] = progression;
        result[1] = numToLook;
        return result;
    }
    public static void progressionGame() {
        // Передача данных в движок
        for (int i = 0; i < Engine.ROUNDS; i++) {
            var dataToTransfer = calculateProgression();
            Engine.GAME_DATA_BASE[i][0] = dataToTransfer[0];
            Engine.GAME_DATA_BASE[i][1] = dataToTransfer[1];
        }
        // Начало игры
        var question = "What number is missing in the progression?";
        Engine.startGame(question);
    }
}
