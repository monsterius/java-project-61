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
    public static String input = ""; // Ввод
    public static String error = "Error"; // Ошибка формата ввода
    public static String correctInput = "Correct!"; // Удачная попытка
    public static String errA = " is wrong answer ;(. Correct answer was ";
    public static String errB = "\nLet's try again, ";
    public static String[][] gameData = new String[3][2];
    public static int currentRound = 0;
    // Метод приветствия и запроса имени
    public static void startGame(String question) { // Приветствие и ввод имени
        counter = 0;
        var nameReq = "May I have your name?";
        var greet = "Hello, ";
        System.out.println(nameReq);
        name = scanner.nextLine();
        System.out.println(greet + name + "!\n" + question);
    }
    // Метод сравнения результата с правильным ответом
    public static boolean checkAnswer(String answer) {
        return answer.equals(gameData[currentRound][1]);
    }
    // Метод вывода в случае ошибки
    public static void wrongAnswer(String answer, String result) {
        var partA = " is wrong answer ;(. Correct answer was ";
        var partB =  "\nLet's try again, ";
        System.out.println(answer + partA + result + partB + "!");
    }
    // Методы возврата инпута String или int в требуемом формате
    public static String encloseStr(String str) {
        return "'" + str + "'";
    }
    public static String encloseInt(int integer) {
        return "'" + integer + "'";
    }
}
