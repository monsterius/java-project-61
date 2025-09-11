package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
    public static void evenGame() {
        // Передача данных в движок
        final int randomNumMin = 1;
        final int randomNumMax = 50;
        String[][] gameData = new String[Engine.ROUNDS][2];
        for (int i = 0; i < Engine.ROUNDS; i++) {
            int randomValue = Utils.getRandomNumber(randomNumMin, randomNumMax);
            gameData[i][0] = randomValue + "";
            var correctAnswer = isEven(randomValue) ? "yes" : "no";
            gameData[i][1] = correctAnswer;
        }
        // Начало игры
        var question = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        Engine.startGame(question, gameData);
    }
}
