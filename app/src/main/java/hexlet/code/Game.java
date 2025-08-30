package hexlet.code;

import java.util.Arrays;

public class Game {
    private static final int ROUNDS_TODO = 3;
    private static final int RANDOMBOUNDBIG = 50;
    private static final int RANDOMBOUNDSMALL = 25;
    private static final int RANDOM_ACTION_INDEX = 3;
    private static final int STEP_BOUND = 6;
    private static final int PROGRESSION_SIZE = 9;
    // Игра в четное.
    public static void even() {
        // Передача данных в движок
        int randomValue;
        var even = "yes";
        var odd = "no";
        for (int i = 0; i < Engine.GAME_DATA_BASE.length; i++) {
            randomValue = Engine.RANDOM_NUM_GENERATOR.nextInt(RANDOMBOUNDBIG) + 1;
            Engine.GAME_DATA_BASE[i][0] = randomValue + "";
            if (randomValue % 2 == 0) {
                Engine.GAME_DATA_BASE[i][1] = even;
            } else {
                Engine.GAME_DATA_BASE[i][1] = odd;
            }
        }
        // Начало игры
        Engine.startGame("Answer 'yes' if the number is even, otherwise answer 'no'.");
        while (!Engine.getGameOverStatus() && Engine.getCurrentGameStage() < ROUNDS_TODO) {
            Engine.questionIs();
            var userInput = Engine.getUserInput();
            Engine.checkAnswer(userInput, Engine.GAME_DATA_BASE[Engine.getCurrentGameStage()][1]);
        }
        if (!Engine.getGameOverStatus()) {
            Engine.printCongratMsg();
        }
    }

    public static void calculator() {
        // Передача данных в движок
        var randomValue1 = Engine.RANDOM_NUM_GENERATOR.nextInt(RANDOMBOUNDBIG) + 1;
        var randomValue2 = Engine.RANDOM_NUM_GENERATOR.nextInt(RANDOMBOUNDSMALL) + 1;
        int randomAction;
        var action = "";
        int result;
        for (int i = 0; i < Engine.GAME_DATA_BASE.length; i++) {
            randomAction = Engine.RANDOM_NUM_GENERATOR.nextInt(RANDOM_ACTION_INDEX) + 1;
            if (randomAction == RANDOM_ACTION_INDEX - 2) {
                action = "+";
            } else if (randomAction == RANDOM_ACTION_INDEX - 1) {
                action = "-";
            } else if (randomAction == RANDOM_ACTION_INDEX) {
                action = "*";
            }
            switch (action) {
                case "+" -> {
                    Engine.GAME_DATA_BASE[i][0] = randomValue1 + " " + action + " " + randomValue2;

                    result = randomValue1 + randomValue2;
                    Engine.GAME_DATA_BASE[i][1] = "" + result;
                }
                case "-" -> {
                    Engine.GAME_DATA_BASE[i][0] = randomValue1 + " " + action + " " + randomValue2;
                    result = randomValue1 - randomValue2;
                    Engine.GAME_DATA_BASE[i][1] = "" + result;
                }
                case "*" -> {
                    Engine.GAME_DATA_BASE[i][0] = randomValue1 + " " + action + " " + randomValue2;
                    result = randomValue1 * randomValue2;
                    Engine.GAME_DATA_BASE[i][1] = "" + result;
                }
                default -> System.out.println("");
            }
            randomValue1 = Engine.RANDOM_NUM_GENERATOR.nextInt(RANDOMBOUNDBIG) + 1;
            randomValue2 = Engine.RANDOM_NUM_GENERATOR.nextInt(RANDOMBOUNDSMALL) + 1;
        }
        // Начало игры
        Engine.startGame("What is the result of the expression?");
        while (!Engine.getGameOverStatus() && Engine.getCurrentGameStage() < ROUNDS_TODO) {
            Engine.questionIs();
            var userInput = Engine.getUserInput();
            Engine.checkAnswer(userInput, Engine.GAME_DATA_BASE[Engine.getCurrentGameStage()][1]);
        }
        if (!Engine.getGameOverStatus()) {
            Engine.printCongratMsg();
        }
    }
    public static void gCD() {
        // Передача данных в движок
        int numberA;
        int numberB;
        int tempVar;
        int gCD;
        for (int i = 0; i < Engine.GAME_DATA_BASE.length; i++) {
            numberA = Engine.RANDOM_NUM_GENERATOR.nextInt(RANDOMBOUNDBIG) + 1;
            numberB = Engine.RANDOM_NUM_GENERATOR.nextInt(RANDOMBOUNDBIG) + 1;
            Engine.GAME_DATA_BASE[i][0] = numberA + " " + numberB;
            while (numberB != 0) {
                tempVar = numberA % numberB;
                numberA = numberB;
                numberB = tempVar;
            }
            gCD = numberA;
            Engine.GAME_DATA_BASE[i][1] = "" + gCD;
        }
        // Начало игры
        Engine.startGame("Find the greatest common divisor of given numbers.");
        while (!Engine.getGameOverStatus() && Engine.getCurrentGameStage() < ROUNDS_TODO) {
            Engine.questionIs();
            var userInput = Engine.getUserInput();
            Engine.checkAnswer(userInput, Engine.GAME_DATA_BASE[Engine.getCurrentGameStage()][1]);
        }
        if (!Engine.getGameOverStatus()) {
            Engine.printCongratMsg();
        }
    }
    public static void progression() {
        // Передача данных в движок
        for (int i = 0; i < Engine.GAME_DATA_BASE.length; i++) {
            String[] list = new String[PROGRESSION_SIZE];
            var lostNumber = Engine.RANDOM_NUM_GENERATOR.nextInt(list.length);
            var firstNumber = Engine.RANDOM_NUM_GENERATOR.nextInt(RANDOMBOUNDSMALL);
            var step = Engine.RANDOM_NUM_GENERATOR.nextInt(STEP_BOUND) + 1;
            list[0] = firstNumber + "";
            for (int b = 1; b < list.length; b++) {
                list[b] = Integer.parseInt(list[b - 1]) + step + "";
            }
            Engine.GAME_DATA_BASE[i][1] = list[lostNumber];
            list[lostNumber] = "..";
            var progression = Arrays.toString(list);
            progression = progression.replace("[", "").replace("]", "");
            Engine.GAME_DATA_BASE[i][0] =  progression.replace(",", "");
        }
        // Начало игры
        Engine.startGame("What number is missing in the progression?");
        while (!Engine.getGameOverStatus() && Engine.getCurrentGameStage() < ROUNDS_TODO) {
            Engine.questionIs();
            var userInput = Engine.getUserInput();
            Engine.checkAnswer(userInput, Engine.GAME_DATA_BASE[Engine.getCurrentGameStage()][1]);
        }
        if (!Engine.getGameOverStatus()) {
            Engine.printCongratMsg();
        }
    }
    public static void prime() {
        // Передача данных в движок
        int randomNumber;
        for (int i = 0; i < Engine.GAME_DATA_BASE.length; i++) {
            randomNumber = Engine.RANDOM_NUM_GENERATOR.nextInt(RANDOMBOUNDBIG) + 1;
            boolean numIsPrime = Misc.isPrime(randomNumber);
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
            Engine.questionIs();
            var userInput = Engine.getUserInput();
            Engine.checkAnswer(userInput, Engine.GAME_DATA_BASE[Engine.getCurrentGameStage()][1]);
        }
        if (!Engine.getGameOverStatus()) {
            Engine.printCongratMsg();
        }
    }
}
