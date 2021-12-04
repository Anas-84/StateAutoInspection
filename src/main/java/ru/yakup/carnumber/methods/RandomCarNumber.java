package ru.yakup.carnumber.methods;

import ru.yakup.carnumber.entities.CarNumber;
import java.util.concurrent.ThreadLocalRandom;

public class RandomCarNumber {
    private static final int LENGTH = Chars.chars.length;

    private RandomCarNumber() {
    }

    private static Character charRandom() {
        int index = ThreadLocalRandom.current().nextInt(LENGTH);
        return Chars.chars[index];
    }

    private static Integer numberRandom() {
        return ThreadLocalRandom.current().nextInt(1000);
    }

    public static CarNumber carNumberRandom() {
        CarNumber carNumber = new CarNumber();
        carNumber.setFirstChar(charRandom());
        carNumber.setNumber(numberRandom());
        carNumber.setSecondChar(charRandom());
        carNumber.setLastChar(charRandom());
        return carNumber;
    }
}

