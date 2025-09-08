package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Arrays;

public class Progression {
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
        final int progressionLength = 10;
        final int progressionLengthIndexMax = 9;
        final int stepRange = 10;
        final int randomNumMax = 40;
        final int randomNumMin = 1;
        for (int i = 0; i < Engine.ROUNDS; i++) {
            int step = Utils.getRandomNumber(randomNumMin, stepRange);
            int firstNum = Utils.getRandomNumber(randomNumMin, randomNumMax);
            String progressionToProcess = createProgression(firstNum, step, progressionLength);
            String[] arrayProgression = progressionToProcess.split(" ");
            int index = Utils.getRandomNumber(randomNumMin, progressionLengthIndexMax);
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
