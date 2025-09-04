package hexlet.code;

import java.util.Random;

public class Utils {
    private static final Random RANDOM_NUM_GENERATOR = new Random();

    public static int getRandomNumber(int range) {
        int randomInt = RANDOM_NUM_GENERATOR.nextInt(range) + 1;
        return randomInt;
    }
}
