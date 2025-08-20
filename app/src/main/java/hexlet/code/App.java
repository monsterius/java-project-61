package hexlet.code;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        boolean goodbye = false;
        while (!goodbye) {
            System.out.println("Please enter the game number and press Enter.\n3 - Calculator\n2 - Even\n1 - Greet\n0 - Exit");
            Scanner sc = new Scanner(System.in);
            String game = sc.nextLine();
            switch (game) {
                case "1" -> {
                    System.out.println("Welcome to the Brain Games!");
                    Cli.welcome();
                }
                case "0" -> {
                    goodbye = true;
                    System.out.println("Goodbye!");
                }
                case "2" -> Game.even();
                case "3" -> Game.calculator();
                default -> System.out.println("Invalid input!");
            }
        }
    }
}