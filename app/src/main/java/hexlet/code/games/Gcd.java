package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Gcd {
    public static int calculateGcd(int num1, int num2) {
        int temp;
        int result;
        while (num2 != 0) {
            temp = num1 % num2;
            num1 = num2;
            num2 = temp;
        }
        result = num1;
        return result;
    }
    public static void gCDGame() {
        // Передача данных в движок
        final int randomNumMin = 1;
        final int randomNumMax = 25;
        String[][] gameData = new String[Engine.ROUNDS][2];
        for (int i = 0; i < Engine.ROUNDS; i++) {
            int numberA = Utils.getRandomNumber(randomNumMin, randomNumMax);
            int numberB = Utils.getRandomNumber(randomNumMin, randomNumMax);
            int gCD = calculateGcd(numberA, numberB);
            gameData[i][0] = numberA + " " + numberB;
            gameData[i][1] = gCD + "";
        }
        // Начало игры
        var question = "Find the greatest common divisor of given numbers.";
        Engine.startGame(question, gameData);
    }
}
