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
            case 3 -> { // GCD
                System.out.println("May I have your name?");
                name = scanner.nextLine();
                System.out.println("Hello, " + name + "!\nFind the greatest common divisor of given numbers.");
            }
            case 4 -> { // Progression
                System.out.println("May I have your name?");
                name = scanner.nextLine();
                System.out.println("Hello, " + name + "!\nWhat number is missing in the progression?");
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
    // Генератор числовой последовательности
    public static String[] generateList() {
        String[] list = new String[9];
        var firstNumber = generator.nextInt(15);
        var step = generator.nextInt(6) + 1;
        list[0] = firstNumber + "";
        for (int i = 1; i < list.length; i++) {
            list[i] = Integer.parseInt(list[i - 1]) + step + "";
        }
        return list;
    }
}