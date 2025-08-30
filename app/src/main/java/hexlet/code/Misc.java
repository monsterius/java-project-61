package hexlet.code;

public class Misc {
    private static  int indexValue = 3;
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        } else if (number == 2) {
            return true;
        } else if (number % 2 == 0) {
            return false;
        }
        int sqrtN = (int) Math.sqrt(number);
        for (int i = indexValue; i <= sqrtN; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
