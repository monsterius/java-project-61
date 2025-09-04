package hexlet.code;
import java.util.Scanner;

public class Engine {
    // Общие переменные
    private static final Scanner SCANNER = new Scanner(System.in); // Сканер
    private static int counter = 0; // Счетчик успешных решений
    private static boolean gameOver = false; // Индикатор победы/поражения
    private static String name = ""; // Имя пользователя
    public static final int ROUNDS = 3;
    // Начало игры
    public static void startGame(String question, String[][] gameData) { // Приветствие и ввод имени
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
            System.out.println("Question: " + gameData[counter][0]);
            var userInput = SCANNER.nextLine();
            var result = gameData[counter][1];
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
            gameOver = true;
        }
    }
    public static String encloseStr(String str) {
        return "'" + str + "'";
    }
    public static boolean getGameOverStatus() {
        return gameOver;
    }
}
