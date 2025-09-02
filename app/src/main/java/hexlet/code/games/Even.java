package hexlet.code.games;

import hexlet.code.Engine;

public class Even {
    private static final int RANDOMBOUNDBIG = 50;

    public static boolean calcIsEven(int number) {
        return number % 2 == 0;
    }
    public static void evenGame() {
        // Передача данных в движок
        int randomValue;
        for (int i = 0; i < Engine.ROUNDS; i++) {
            randomValue = Engine.RANDOM_NUM_GENERATOR.nextInt(RANDOMBOUNDBIG) + 1;
            Engine.GAME_DATA_BASE[i][0] = randomValue + "";
            if (calcIsEven(randomValue)) {
                Engine.GAME_DATA_BASE[i][1] = "yes";
            } else {
                Engine.GAME_DATA_BASE[i][1] = "no";
            }
        }
        // Начало игры
        var question = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        Engine.startGame(question);
    }
}
