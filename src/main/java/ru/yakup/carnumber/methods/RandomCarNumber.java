package ru.yakup.carnumber.methods;

import ru.yakup.carnumber.entities.CarNumber;
import java.util.concurrent.ThreadLocalRandom;

public class RandomCarNumber {
    private static final Character[] chars = {'А', 'Е', 'Т', 'О', 'Р', 'Н', 'У', 'К', 'Х', 'С', 'В', 'М'};
    private static final int LENGTH = chars.length;

    private RandomCarNumber() {
    }

    private static Character charRandom() {
        return chars[ThreadLocalRandom.current().nextInt(LENGTH)];
    }

    private static String numberRandom() {
        String str = Integer.toString(ThreadLocalRandom.current().nextInt(1000));
        int length = str.length();

        if (length == 1) {
            return "00" + str;
        }
        else if (length == 2) {
            return "0" + str;
        }
        else {
            return str;
        }
    }

    public static CarNumber carNumberRandom() {
        CarNumber carNumber = new CarNumber();
        carNumber.setFirstChar(charRandom().toString());
        carNumber.setNumber(numberRandom());
        carNumber.setSecondChar(charRandom().toString());
        carNumber.setLastChar(charRandom().toString());
        return carNumber;
    }
}

