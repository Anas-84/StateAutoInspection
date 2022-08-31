package ru.yakup.carnumber.utils;

import lombok.experimental.UtilityClass;
import ru.yakup.carnumber.model.CarNumber;

import java.util.concurrent.ThreadLocalRandom;

import static ru.yakup.carnumber.utils.Chars.*;

@UtilityClass
public final class RandomCarNumber {

    public CarNumber carNumberRandom() {
        return CarNumber.builder()
                .firstChar(charRandom())
                .number(numberRandom())
                .secondChar(charRandom())
                .lastChar(charRandom())
                .build();
    }

    private char charRandom() {
        return getCharFromCharsByIndex(ThreadLocalRandom.current()
                .nextInt(getCharsSize()));
    }

    private int numberRandom() {
        return ThreadLocalRandom.current()
                .nextInt(1000);
    }
}