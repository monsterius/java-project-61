package hexlet.code;

public class Game {
    // Игра в четное.
    public static void even() {
        Engine.counter = 0;
        // Передача данных в движок
        int randomValue;
        var even = "yes";
        var odd = "no";
        for (int i = 0; i < 3; i++) {
            randomValue = Engine.generator.nextInt(50) + 1;
            Engine.gameData[i][0] = randomValue + "";
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
            var userAnswer = Engine.scanner.nextLine();
            Engine.checkAnswer(userAnswer, Engine.gameData[Engine.counter][1]);
        }
        if (!Engine.gameOver) {
            Engine.printCongratMsg();
        }
    }

    public static void calculator() {
        Engine.counter = 0;
        // Передача данных в движок
        var randomValue1 = Engine.generator.nextInt(25) + 1;
        var randomValue2 = Engine.generator.nextInt(10) + 1;
        int randomAction;
        var action = "";
        int result;
        for (int i = 0; i < 3; i++) {
            randomAction = Engine.generator.nextInt(3) + 1;
            switch (randomAction) {
                case 1 -> action = "+";
                case 2 -> action = "-";
                case 3 -> action = "*";
            }
            switch (action) {
                case "+" -> {
                    Engine.gameData[i][0] = randomValue1 + " " + action + " " + randomValue2;

                    result = randomValue1 + randomValue2;
                    Engine.gameData[i][1] = "" + result;
                }
                case "-" -> {
                    Engine.gameData[i][0] = randomValue1 + " " + action + " " + randomValue2;
                    result = randomValue1 - randomValue2;
                    Engine.gameData[i][1] = "" + result;
                }
                case "*" -> {
                    Engine.gameData[i][0] = randomValue1 + " " + action + " " + randomValue2;
                    result = randomValue1 * randomValue2;
                    Engine.gameData[i][1] = "" + result;
                }
            }
            randomValue1 = Engine.generator.nextInt(25) + 1;
            randomValue2 = Engine.generator.nextInt(10) + 1;
        }
        // Начало игры
        Engine.startGame("What is the result of the expression?");
        while (!Engine.gameOver && Engine.counter < 3) {
            Engine.questionIs();
            var userAnswer = Engine.scanner.nextLine();
            Engine.checkAnswer(userAnswer, Engine.gameData[Engine.counter][1]);
        }
        if (!Engine.gameOver) {
            Engine.printCongratMsg();
        }
    }
}
