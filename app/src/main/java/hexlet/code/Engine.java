package hexlet.code;
import java.util.Random;
import java.util.Scanner;

public class Engine {
    // Общие переменные
    public static final Scanner scanner = new Scanner(System.in); // Сканер
    public static int counter = 0; // Счетчик успешных решений
    public static boolean gameOver = false; // Индикатор победы/поражения
    public static Random generator = new Random(); // Генератор рандомных чисел
    public static String name = ""; // Имя пользователя
    public static String input = ""; // Ввод
    public static String error = "Invalid Input"; // Ошибка формата ввода
    public static String correctInput = "Correct!"; // Удачная попытка
    // Метод приветствия и запроса имени
    public static void dispGreetAndInit(int variation) { // Приветствие и ввод имени
        counter = 0;
        switch (variation) {
            case 1 -> { // Even
                System.out.println("May I have your name?");
                name = scanner.nextLine();
                System.out.println("Hello, " + name + "!");
            }
            case 2 -> { // Calculator
                System.out.println("May I have your name?");
                name = scanner.nextLine();
                System.out.println("Hello, " + name + "!\nWhat is the result of the expression?");
            }
        }
    }
    // Методы возврата инпута String или int в требуемом формате
    public static String encloseStr(String str) {
        return "'" + str + "'";
    }
    public static String encloseInt(int integer) {
        return "'" + integer + "'";
    }
}