package hexlet.code.games;

import hexlet.code.Engine;

public class Gcd {
    private static final int RANDOMBOUNDBIG = 50;

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
        String[][] gameData = new String[Engine.ROUNDS][2];
        int numberA;
        int numberB;
        int gCD;
        for (int i = 0; i < Engine.ROUNDS; i++) {
            numberA = Engine.RANDOM_NUM_GENERATOR.nextInt(RANDOMBOUNDBIG) + 1;
            numberB = Engine.RANDOM_NUM_GENERATOR.nextInt(RANDOMBOUNDBIG) + 1;
            gCD = calculateGcd(numberA, numberB);
            gameData[i][0] = numberA + " " + numberB;
            gameData[i][1] = gCD + "";
        }
        // Начало игры
        var question = "Find the greatest common divisor of given numbers.";
        Engine.startGame(question, gameData);
    }
}
