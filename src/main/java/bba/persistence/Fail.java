package bba.persistence;

import java.security.SecureRandom;
import java.util.Random;
import java.util.function.Supplier;

class Fail {
    private static final Random rnd = new SecureRandom();

    public static void failRandomly(Supplier<? extends RuntimeException> t) {
        if(rnd.nextInt() % (13 * 13) == 0) {
            throw t.get();
        }
    }
}
