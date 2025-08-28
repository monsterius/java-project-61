package hexlet.code;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        boolean goodbye = false;
        while (!goodbye) {
            System.out.println("Please enter the game number and press Enter.");
            System.out.println("1 - Greet\n2 - Even\n3 - Calculator\n4 - GCD\n5 - Progression\n6 - Prime\n0 - Exit");
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
                case "2" ->  {
                    Game.even();
                }
                case "3" -> {
                    Game.calculator();
                }
                case "4" -> {
                    Game.greatestCommonDivisor();
                }
                case "5" -> {
                    Game.progression();
                }
                case "6" -> {
                    Game.prime();
                }
                default -> System.out.println("Error");
            }
        }
    }
}
