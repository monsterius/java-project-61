package hexlet.code;

import java.util.Random;

public class Utils {

    public static int getRandomNumber(int min, int max) {
        final Random RANDOM_NUM_GENERATOR = new Random();
        return RANDOM_NUM_GENERATOR.nextInt(max - min + 1) + min;
    }
}
