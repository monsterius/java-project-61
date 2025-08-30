package hexlet.code;
import java.util.Scanner;
import hexlet.code.games.Even;
import hexlet.code.games.Calculator;
import hexlet.code.games.Gcd;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

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
                    goodbye = true;
                }
                case "0" -> {
                    goodbye = true;
                    System.out.println("Goodbye!");
                }
                case "2" ->  {
                    Even.evenGame();
                    goodbye = true;
                }
                case "3" ->  {
                    Calculator.calculatorGame();
                    goodbye = true;
                }
                case "4" ->  {
                    Gcd.gCDGame();
                    goodbye = true;
                }
                case "5" ->  {
                    Progression.progressionGame();
                    goodbye = true;
                }
                case "6" ->  {
                    Prime.primeGame();
                    goodbye = true;
                }
                default -> System.out.println("Error");
            }
        }
    }
}
