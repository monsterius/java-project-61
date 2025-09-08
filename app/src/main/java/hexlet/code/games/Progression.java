package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Arrays;

public class Progression {
    private static final int RANDOM_NUM_MIN = 1;
    private static final int RANDOM_NUM_MAX = 40;
    private static final int STEP_RANGE = 10;
    private static final int PROGRESSION_LENGTH = 10;
    private static final int PROGRESSION_LENGTH_INDEX_MAX = 9;

    public static String createProgression(int firstNum, int step, int length) {
        String[] array = new String[length];
        String progression;
        String result;
        array[0] = firstNum + "";
        for (int i = 1; i < array.length; i++) {
            array[i] = Integer.parseInt(array[i - 1]) + step + "";
        }
        progression = Arrays.toString(array).replace("[", "").replace("]", "").replace(",", "");
        result = progression;
        return result;
    }
    public static void progressionGame() {
        // Передача данных в движок
        String[][] gameData = new String[Engine.ROUNDS][2];
        for (int i = 0; i < Engine.ROUNDS; i++) {
            int step = Utils.getRandomNumber(RANDOM_NUM_MIN, STEP_RANGE);
            int firstNum = Utils.getRandomNumber(RANDOM_NUM_MIN, RANDOM_NUM_MAX);
            String progressionToProcess = createProgression(firstNum, step, PROGRESSION_LENGTH);
            String[] arrayProgression = progressionToProcess.split(" ");
            int index = Utils.getRandomNumber(RANDOM_NUM_MIN, PROGRESSION_LENGTH_INDEX_MAX);
            String numToLook = arrayProgression[index];
            String finalProgression = progressionToProcess.replace(numToLook, "..");
            gameData[i][0] = finalProgression;
            gameData[i][1] = numToLook;
        }
        // Начало игры
        var question = "What number is missing in the progression?";
        Engine.startGame(question, gameData);
    }
}
