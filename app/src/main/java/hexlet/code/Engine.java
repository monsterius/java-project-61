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
    // Метод приветствия и запроса имени
    public static void dispGreetAndInit(int variation) { // Приветствие и ввод имени
        counter = 0;
        var nameReq = "May I have your name?";
        var greet = "Hello, ";
        switch (variation) {
            case 1 -> { // Even
                System.out.println(nameReq);
                name = scanner.nextLine();
                System.out.println(greet + name + "!");
            }
            case 2 -> { // Calculator
                System.out.println(nameReq);
                name = scanner.nextLine();
                System.out.println(greet + name + "!\nWhat is the result of the expression?");
            }
            case 3 -> { // GCD
                System.out.println(nameReq);
                name = scanner.nextLine();
                System.out.println(greet + name + "!\nFind the greatest common divisor of given numbers.");
            }
            case 4 -> { // Progression
                System.out.println(nameReq);
                name = scanner.nextLine();
                System.out.println(greet + name + "!\nWhat number is missing in the progression?");
            }
            case 5 -> {
                System.out.println(nameReq);
                name = scanner.nextLine();
                System.out.println(greet + name + "!");
                System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
            }
            default -> System.out.println(error);
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
    // Метод определения простого числа
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        int sqrtN = (int) Math.sqrt(n);
        for (int i = 3; i <= sqrtN; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
