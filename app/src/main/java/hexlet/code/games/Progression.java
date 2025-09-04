package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

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
        var lostNumber = Utils.getRandomNumber(array.length);
        var firstNumber = Utils.getRandomNumber(RANDOMBOUNDSMALL);;
        var step = Utils.getRandomNumber(STEP_BOUND);
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
        String[][] gameData = new String[Engine.ROUNDS][2];
        for (int i = 0; i < Engine.ROUNDS; i++) {
            var dataToTransfer = calculateProgression();
            gameData[i][0] = dataToTransfer[0];
            gameData[i][1] = dataToTransfer[1];
        }
        // Начало игры
        var question = "What number is missing in the progression?";
        Engine.startGame(question, gameData);
    }
}
