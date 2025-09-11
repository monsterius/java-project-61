package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    public static boolean isPrime(int number) {
        final int index = 3;
        if (number <= 1) {
            return false;
        } else if (number == 2) {
            return true;
        } else if (number % 2 == 0) {
            return false;
        }
        int sqrtN = (int) Math.sqrt(number);
        for (int i = index; i <= sqrtN; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void primeGame() {
        // Передача данных в движок
        String[][] gameData = new String[Engine.ROUNDS][2];
        final int randomNumMin = 1;
        final int randomNumMax = 50;
        for (int i = 0; i < Engine.ROUNDS; i++) {
            int randomNumber = Utils.getRandomNumber(randomNumMin, randomNumMax);
            if (isPrime(randomNumber)) {
                gameData[i][0] = "" + randomNumber;
                gameData[i][1] = "yes";
            } else {
                gameData[i][0] = "" + randomNumber;
                gameData[i][1] = "no";
            }
        }
        // Начало игры
        var question = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        Engine.startGame(question, gameData);
    }
}
