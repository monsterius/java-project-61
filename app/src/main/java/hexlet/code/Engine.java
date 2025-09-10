package hexlet.code;
import java.util.Scanner;

public class Engine {
    // Общие переменные
    private static final Scanner SCANNER = new Scanner(System.in); // Сканер
    private static boolean gameOver = false; // Индикатор победы/поражения
    public static final int ROUNDS = 3;
    // Начало игры
    public static void startGame(String question, String[][] gameData) { // Приветствие и ввод имени
        // Счетчик успешных решений
        int counter = 0;
        var nameReq = "May I have your name?";
        var greet = "Hello, ";
        var partA = " is wrong answer ;(. Correct answer was ";
        var partB =  "\nLet's try again, ";
        String correctInput = "Correct!";

        System.out.println(nameReq);
        String name = SCANNER.nextLine();
        System.out.println(greet + name + "!\n" + question);
        for (String[] data : gameData) {
            System.out.println("Question: " + gameData[counter][0]);
            var userInput = SCANNER.nextLine();
            var result = gameData[counter][1];
            if (userInput.equals(result)) {
                System.out.println(correctInput);
                counter++;
            } else {
                System.out.print("'" + userInput + "'"  + partA + "'" + result + "'.");
                System.out.print(partB + name + "!");
                gameOver = true;
            }
        }
        if (!gameOver) {
            System.out.println("Congratulations, " + name + "!");
            gameOver = true;
        }
    }
}
