package hexlet.code;

import java.util.Random;

public class Utils {
    private static final Random RANDOM_NUM_GENERATOR = new Random();

    public static int getRandomNumber(int min, int max) {
        return RANDOM_NUM_GENERATOR.nextInt(max - min + 1) + min;
    }
}
