package hexlet.code;
import java.util.Scanner;

public class Engine {
    public static Scanner scanner = new Scanner(System.in);
    public static String name = "";
    public static int counter = 0;
    public static void dispGreetAndInit(int variation) {
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
    }   }
}