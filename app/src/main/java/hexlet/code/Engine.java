package hexlet.code;
import java.util.Random;
import java.util.Scanner;

public class Engine {
    // Общие переменные
    private static final Scanner SCANNER = new Scanner(System.in); // Сканер
    private static int counter = 0; // Счетчик успешных решений
    private static boolean gameOver = false; // Индикатор победы/поражения
    public static final  Random RANDOM_NUM_GENERATOR = new Random(); // Генератор рандомных чисел
    private static String name = "";// Имя пользователя
    private static final int DATA_BASE_LENGTH = 3;
    public static final  String[][] GAME_DATA_BASE = new String[DATA_BASE_LENGTH][2]; // База
    // Метод приветствия и запроса имени
    public static void startGame(String question) { // Приветствие и ввод имени
        counter = 0;
        var nameReq = "May I have your name?";
        var greet = "Hello, ";
        System.out.println(nameReq);
        name = SCANNER.nextLine();
        System.out.println(greet + name + "!\n" + question);
    }
    // Метод вывода вопроса
    public static void questionIs() {
        System.out.println("Question: " + GAME_DATA_BASE[counter][0]);
    }
    // Метод сравнения результата с правильным ответом
    public static void checkAnswer(String answer, String result) {
        var partA = " is wrong answer ;(. Correct answer was ";
        var partB =  "\nLet's try again, ";
        String correctInput = "Correct!";
        if (answer.equals(GAME_DATA_BASE[counter][1])) {
            System.out.println(correctInput);
            counter++;
        } else {
            System.out.println(encloseStr(answer) + partA + encloseStr(result) + "." + partB + name + "!");
            gameOver = true;
        }
    }
    // Вывод поздравления
    public static void printCongratMsg() {
        System.out.println("Congratulations, " + name + "!");
    }
    // Методы возврата инпута String в нужном формате
    public static String encloseStr(String str) {
        return "'" + str + "'";
    }
    public static String getUserInput() {
        return Engine.SCANNER.nextLine();
    }
    public static int getCurrentGameStage() {
        return counter;
    }
    public static boolean getGameOverStatus() {
        return gameOver;
    }
    public static void setGameOverStatus(boolean status) {
        if  (status) {
            Engine.gameOver = true;
        } else {
            Engine.gameOver = false;
        }
    }
}
