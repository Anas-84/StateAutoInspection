package ru.yakup.carnumber.methods;

import ru.yakup.carnumber.entities.CarNumber;
import ru.yakup.carnumber.exception.AutoNumbersAreOverException;

public class NextCarNumber {
    private static int count = 0;
    private static final int LENGTH = Chars.chars.length;

    private NextCarNumber() {
    }

    private static Integer nextNumber(int numb) {
        if (numb == 999) {
            return 0;
        }
        else {
            return ++numb;
        }
    }

    private static Character nextChar (char ch) {
        int index = 0;

        for (int ind = 0; ind < LENGTH; ind++) {
            if(Chars.chars[ind] == ch) {
                index = ind;
                break;
            }
        }
        if (index == LENGTH- 1) {
            return ch;
        }
        else {
            return Chars.chars[++index];
        }
    }

    public static CarNumber nextCarNumber(CarNumber carNumber) throws AutoNumbersAreOverException {
        CarNumber nextCarNumber = new CarNumber();
        nextCarNumber.setCount(++count);
        int numb = carNumber.getNumber();

        if (numb != 999) {
            nextCarNumber.setFirstChar(carNumber.getFirstChar());
            nextCarNumber.setNumber(nextNumber(numb));
            nextCarNumber.setSecondChar(carNumber.getSecondChar());
            nextCarNumber.setLastChar(carNumber.getLastChar());
        }
        else if (!carNumber.getLastChar().equals(Chars.chars[LENGTH-1])) {
            nextCarNumber.setFirstChar(carNumber.getFirstChar());
            nextCarNumber.setNumber(nextNumber(numb));
            nextCarNumber.setSecondChar(carNumber.getSecondChar());
            nextCarNumber.setLastChar(nextChar(carNumber.getLastChar()));
        }
        else if (!carNumber.getSecondChar().equals(Chars.chars[LENGTH-1])) {
            nextCarNumber.setFirstChar(carNumber.getFirstChar());
            nextCarNumber.setNumber(nextNumber(numb));
            nextCarNumber.setSecondChar(nextChar(carNumber.getSecondChar()));
            nextCarNumber.setLastChar(carNumber.getLastChar());
        }
        else if (!carNumber.getFirstChar().equals(Chars.chars[LENGTH-1])) {
            nextCarNumber.setFirstChar(nextChar(carNumber.getFirstChar()));
            nextCarNumber.setNumber(nextNumber(numb));
            nextCarNumber.setSecondChar(carNumber.getSecondChar());
            nextCarNumber.setLastChar(carNumber.getLastChar());
        }
        else {
            throw new AutoNumbersAreOverException("Auto numbers are over");
        }
        return nextCarNumber;
    }
}
