package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    private static final int RANDOMBOUNDBIG = 50;

    public static boolean IsEven(int number) {
        return number % 2 == 0;
    }
    public static void evenGame() {
        // Передача данных в движок
        int randomValue;
        String[][] gameData = new String[Engine.ROUNDS][2];
        for (int i = 0; i < Engine.ROUNDS; i++) {
            randomValue = Utils.getRandomNumber(RANDOMBOUNDBIG);
            gameData[i][0] = randomValue + "";
            if (IsEven(randomValue)) {
                gameData[i][1] = "yes";
            } else {
                gameData[i][1] = "no";
            }
        }
        // Начало игры
        var question = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        Engine.startGame(question, gameData);
    }
}
