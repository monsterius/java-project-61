package hexlet.code;

import java.util.Random;

public class Utils {

    public static int getRandomNumber(int min, int max) {
        final Random randomNumGenerator = new Random();
        return randomNumGenerator.nextInt(max - min + 1) + min;
    }
}
