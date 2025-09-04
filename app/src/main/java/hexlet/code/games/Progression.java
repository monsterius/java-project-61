package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Arrays;

public class Progression {
    private static final int RANDOM_NUM_MIN = 1;
    private static final int RANDOM_NUM_MAX = 40;
    private static final int STEP_RANGE = 10;
    private static final int PROGRESSION_LENGTH = 10;

    public static String[] createProgression(int firstNum, int step, int length) {
        String[] array = new String[length];
        String progression;
        String[] result = new String[2];
        String numToLook;
        var lostNumber = Utils.getRandomNumber(RANDOM_NUM_MIN, array.length);
        array[0] = firstNum + "";
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
        String[][] gameData = new String[Engine.ROUNDS][2];
        int step = Utils.getRandomNumber(RANDOM_NUM_MIN, STEP_RANGE);
        int firstNum = Utils.getRandomNumber(RANDOM_NUM_MIN, RANDOM_NUM_MAX);
        for (int i = 0; i < Engine.ROUNDS; i++) {
            var dataToTransfer = createProgression(firstNum, step, PROGRESSION_LENGTH);
            gameData[i][0] = dataToTransfer[0];
            gameData[i][1] = dataToTransfer[1];
            step = Utils.getRandomNumber(RANDOM_NUM_MIN, STEP_RANGE);
            firstNum = Utils.getRandomNumber(RANDOM_NUM_MIN, RANDOM_NUM_MAX);
        }
        // Начало игры
        var question = "What number is missing in the progression?";
        Engine.startGame(question, gameData);
    }
}
