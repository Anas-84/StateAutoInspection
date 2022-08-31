package ru.yakup.carnumber.utils;

import lombok.experimental.UtilityClass;
import ru.yakup.carnumber.model.CarNumber;
import ru.yakup.carnumber.exception.CarNumbersAreOverException;

import static ru.yakup.carnumber.utils.Chars.*;

@UtilityClass
public final class NextCarNumber {

    private static int count = 0;

    public static CarNumber nextCarNumber(CarNumber carNumber) {
        char firstChar = carNumber.getFirstChar();
        int numb = carNumber.getNumber();
        char secondChar = carNumber.getSecondChar();
        char lastChar = carNumber.getLastChar();

        CarNumber nextCarNumber = CarNumber.builder()
                .count(++count)
                .firstChar(firstChar)
                .number(numb)
                .secondChar(secondChar)
                .lastChar(lastChar)
                .build();

        if (numb != 999) {
            nextCarNumber.setNumber(nextNumber(numb));
        } else if (lastChar != getLastCharFromChars()) {
            nextCarNumber.setNumber(nextNumber(numb));
            nextCarNumber.setLastChar(nextChar(lastChar));
        } else if (secondChar != getLastCharFromChars()) {
            nextCarNumber.setNumber(nextNumber(numb));
            nextCarNumber.setSecondChar(nextChar(secondChar));
        } else if (firstChar != getLastCharFromChars()) {
            nextCarNumber.setFirstChar(nextChar(firstChar));
            nextCarNumber.setNumber(nextNumber(numb));
        } else {
            throw new CarNumbersAreOverException();
        }
        return nextCarNumber;
    }

    private int nextNumber(int numb) {
        return numb == 999
                ? 1
                : ++numb;
    }

    private char nextChar(char ch) {
        int index = getIndexCharFromCarts(ch);
        return ch == getLastCharFromChars()
                ? ch
                : getCharFromCharsByIndex(++index);
    }
}