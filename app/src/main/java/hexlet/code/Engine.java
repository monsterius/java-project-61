package hexlet.code;
import java.util.Random;
import java.util.Scanner;

public class Engine {
    // Общие переменные
    public static Scanner scanner = new Scanner(System.in); // Сканер
    public static int counter = 0; // Счетчик успешных решений
    public static boolean gameOver = false; // Индикатор победы/поражения
    public static Random generator = new Random(); // Генератор рандомных чисел
    public static String name = ""; // Имя пользователя
    public final static int gameDataLength = 3;
    public final static String[][] gameData = new String[gameDataLength][2]; // База
    // Метод приветствия и запроса имени
    public static void startGame(String question) { // Приветствие и ввод имени
        counter = 0;
        var nameReq = "May I have your name?";
        var greet = "Hello, ";
        System.out.println(nameReq);
        name = scanner.nextLine();
        System.out.println(greet + name + "!\n" + question);
    }
    // Метод вывода вопроса
    public static void questionIs() {
        System.out.println("Question: " + gameData[counter][0]);
    }
    // Метод сравнения результата с правильным ответом
    public static void checkAnswer(String answer, String result) {
        var partA = " is wrong answer ;(. Correct answer was ";
        var partB =  "\nLet's try again, ";
        String correctInput = "Correct!";
        if (answer.equals(gameData[counter][1])) {
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
}
