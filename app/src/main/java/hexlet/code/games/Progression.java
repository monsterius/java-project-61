package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Arrays;

public class Progression {
    public static String[] createProgression(int firstNum, int step, int length) {
        String[] array = new String[length];
        array[0] = firstNum + "";
        for (int i = 1; i < array.length; i++) {
            array[i] = Integer.parseInt(array[i - 1]) + step + "";
        }
        return array;
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
            int hiddenNumIndex = Utils.getRandomNumber(randomNumMin, progressionLengthIndexMax);
            String[] progressionToProcess = createProgression(firstNum, step, progressionLength);
            String hiddenNum = progressionToProcess[hiddenNumIndex];
            progressionToProcess[hiddenNumIndex] = "..";
            String finalProgression = Arrays.toString(progressionToProcess);
            finalProgression = finalProgression.replace("[", "").replace("]", "").replace(",", "");
            gameData[i][0] = finalProgression;
            gameData[i][1] = hiddenNum;
        }
        // Начало игры
        var question = "What number is missing in the progression?";
        Engine.startGame(question, gameData);
    }
}
