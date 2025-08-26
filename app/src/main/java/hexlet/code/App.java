package hexlet.code;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        boolean goodbye = false;
        while (!goodbye) {
            System.out.println("Please enter the game number and press Enter.");
            System.out.println("6 - Prime\n5 - Progression\n4 - GCD\n3 - Calculator\n2 - Even\n1 - Greet\n0 - Exit");
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
                    Engine.gameOver = false;
                }
                case "3" -> {
                    Game.calculator();
                    Engine.gameOver = false;
                }
                case "4" -> {
                    Game.greatestCommonDivisor();
                    Engine.gameOver = false;
                }
                case "5" -> {
                    Game.progression();
                    Engine.gameOver = false;
                }
                case "6" -> {
                    Game.prime();
                    Engine.gameOver = false;
                }
                default -> System.out.println("Invalid input!");
            }
        }
    }
}