package hexlet.code;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        boolean isValidInput = false;
        while (!isValidInput) {
            System.out.println("Please enter the game number and press Enter.\n2 - Even\n1 - Greet\n0 - Exit");
            Scanner sc = new Scanner(System.in);
            String game = sc.nextLine();
            if (game.equals("1")) {
                isValidInput = true;
                System.out.println("Welcome to the Brain Games!");
                Cli.welcome();
            } else if (game.equals("0")) {
                isValidInput = true;
                System.out.println("Goodbye!");
            } else if (game.equals("2")) {
                Game.even();
            } else {
                System.out.println("Invalid input!");
            }
        }
    }
}
