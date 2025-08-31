package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {
    private static final int ROUNDS_TODO = 3;
    private static final int RANDOMBOUNDBIG = 50;
    private static final  int INDEX = 3;

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        } else if (number == 2) {
            return true;
        } else if (number % 2 == 0) {
            return false;
        }
        int sqrtN = (int) Math.sqrt(number);
        for (int i = INDEX; i <= sqrtN; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void primeGame() {
        // Передача данных в движок
        int randomNumber;
        for (int i = 0; i < Engine.GAME_DATA_BASE.length; i++) {
            randomNumber = Engine.RANDOM_NUM_GENERATOR.nextInt(RANDOMBOUNDBIG) + 1;
            boolean numIsPrime = isPrime(randomNumber);
            if (numIsPrime) {
                Engine.GAME_DATA_BASE[i][0] = "" + randomNumber;
                Engine.GAME_DATA_BASE[i][1] = "yes";
            } else {
                Engine.GAME_DATA_BASE[i][0] = "" + randomNumber;
                Engine.GAME_DATA_BASE[i][1] = "no";
            }
        }
        // Начало игры
        Engine.startGame("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        while (!Engine.getGameOverStatus() && Engine.getCurrentGameStage() < ROUNDS_TODO) {
            Engine.askQuestion();
            var userInput = Engine.getUserInput();
            Engine.checkAnswer(userInput, Engine.GAME_DATA_BASE[Engine.getCurrentGameStage()][1]);
        }
        if (!Engine.getGameOverStatus()) {
            Engine.printCongratMsg();
        }
    }
}
