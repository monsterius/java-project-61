package hexlet.code;
import java.util.Random;
import java.util.Scanner;

public class Engine {
    // Общие переменные
    private static final Scanner SCANNER = new Scanner(System.in); // Сканер
    private static int counter = 0; // Счетчик успешных решений
    private static boolean gameOver = false; // Индикатор победы/поражения
    public static final  Random RANDOM_NUM_GENERATOR = new Random(); // Генератор рандомных чисел
    private static String name = ""; // Имя пользователя
    public static final int ROUNDS = 3;
    public static final  String[][] GAME_DATA_BASE = new String[ROUNDS][2]; // База
    // Начало игры
    public static void startGame(String question) { // Приветствие и ввод имени
        counter = 0;
        var nameReq = "May I have your name?";
        var greet = "Hello, ";
        var partA = " is wrong answer ;(. Correct answer was ";
        var partB =  "\nLet's try again, ";
        String correctInput = "Correct!";

        System.out.println(nameReq);
        name = SCANNER.nextLine();
        System.out.println(greet + name + "!\n" + question);
        while (!gameOver && counter < ROUNDS) {
            System.out.println("Question: " + GAME_DATA_BASE[counter][0]);
            var userInput = SCANNER.nextLine();
            var result = GAME_DATA_BASE[counter][1];
            if (userInput.equals(result)) {
                System.out.println(correctInput);
                counter++;
            } else {
                System.out.println(encloseStr(userInput) + partA + encloseStr(result) + "." + partB + name + "!");
                gameOver = true;
            }
        }
        if (!gameOver) {
            System.out.println("Congratulations, " + name + "!");
        }
    }
    public static String encloseStr(String str) {
        return "'" + str + "'";
    }
    public static int getCurrentGameStage() {
        return counter;
    }
}
