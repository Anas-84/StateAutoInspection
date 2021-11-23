package ru.yakup.carnumber.methods;

import ru.yakup.carnumber.entities.CarNumber;
import ru.yakup.carnumber.entities.CharCarNumber;
import ru.yakup.carnumber.exception.AutoNumbersAreOverException;

public class NextCarNumber {

    private static int count = 0;
    private static final Character[] chars = CharCarNumber.valueOf();
    private static final int LENGTH = chars.length;

    private NextCarNumber() {
    }

    private static String nextNumber(int numb) {
        if (numb == 999) {
            return "000";
        }
        else {
            String str = Integer.toString(++numb);
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
    }

    private static Character nextChar (char ch) {
        int index = 0;

        for (int ind = 0; ind < LENGTH; ind++) {
            if(chars[ind] == ch) {
                index = ind;
                break;
            }
        }
        if (index == LENGTH- 1) {
            return ch;
        }
        else {
            return chars[++index];
        }
    }

    public static CarNumber nextCarNumber(CarNumber carNumber) throws AutoNumbersAreOverException {
        CarNumber nextCarNumber = new CarNumber();
        nextCarNumber.setCount(++count);
        int numb = Integer.parseInt(carNumber.getNumber());

        if (numb != 999) {
            nextCarNumber.setFirstChar(carNumber.getFirstChar());
            nextCarNumber.setNumber(nextNumber(numb));
            nextCarNumber.setSecondChar(carNumber.getSecondChar());
            nextCarNumber.setLastChar(carNumber.getLastChar());
        }
        else if (!carNumber.getFirstChar().equals(chars[LENGTH-1].toString())) {
            nextCarNumber.setFirstChar(nextChar(carNumber.getFirstChar().charAt(0)).toString());
            nextCarNumber.setNumber(nextNumber(numb));
            nextCarNumber.setSecondChar(carNumber.getSecondChar());
            nextCarNumber.setLastChar(carNumber.getLastChar());
        }
        else if (!carNumber.getSecondChar().equals(chars[LENGTH-1].toString())) {
            nextCarNumber.setFirstChar(carNumber.getFirstChar());
            nextCarNumber.setNumber(nextNumber(numb));
            nextCarNumber.setSecondChar(nextChar(carNumber.getSecondChar().charAt(0)).toString());
            nextCarNumber.setLastChar(carNumber.getLastChar());
        }
        else if (!carNumber.getLastChar().equals(chars[LENGTH-1].toString())) {
            nextCarNumber.setFirstChar(carNumber.getFirstChar());
            nextCarNumber.setNumber(nextNumber(numb));
            nextCarNumber.setSecondChar(carNumber.getSecondChar());
            nextCarNumber.setLastChar(nextChar(carNumber.getLastChar().charAt(0)).toString());
        }
        else {
            throw new AutoNumbersAreOverException("Auto numbers are over");
        }
        return nextCarNumber;
    }
}
