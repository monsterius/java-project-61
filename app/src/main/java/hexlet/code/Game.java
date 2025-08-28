package hexlet.code;

import java.util.Arrays;
import java.util.Random;

public class Game {
    // Игра в четное.
    public static void even() {
        Engine.counter = 0;
        Engine.currentRound = 0;
        // Передача данных в движок
        int randomValue;
        var even = "yes";
        var odd = "no";
        for (int i = 0; i < 3; i++) {
            randomValue = Engine.generator.nextInt(50) + 1;
            Engine.gameData[i][1] = randomValue + "";
            if (randomValue % 2 == 0) {
                Engine.gameData[i][1] = even;
            } else {
                Engine.gameData[i][1] = odd;
            }
        }
        // Начало игры
        Engine.startGame("Answer 'yes' if the number is even, otherwise answer 'no'.");
        while (!Engine.gameOver && Engine.counter < 3) {
            Engine.questionIs();
            var answer = Engine.scanner.nextLine();
            Engine.checkAnswer(answer, Engine.gameData[Engine.currentRound][1]);
        }
    }
}
