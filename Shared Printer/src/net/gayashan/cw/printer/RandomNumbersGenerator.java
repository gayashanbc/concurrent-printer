/*
 * @author Gayashan Bombuwala | 2015047 | W1582950
 * https://gayashan.net | gayashan@gayashan.net
 */
package net.gayashan.cw.printer;

import java.util.Optional;
import java.util.Random;

public class RandomNumbersGenerator {
    private static Optional<Random> instance = Optional.empty();

    private RandomNumbersGenerator() {
    }

    public synchronized static Random getInstance() {
        if (!instance.isPresent()) {
            instance = Optional.of(new Random());
        }
        return instance.get();
    }

    public static int getOneInt(int lowerLimit, int upperLimit) {
        return getInstance().ints(lowerLimit, upperLimit).findFirst().getAsInt();
    }
}
