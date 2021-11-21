package ru.yakup.carnumber.prototype;

import ru.yakup.carnumber.entities.CarNumber;

import java.util.ArrayList;
import java.util.List;

public class CarNumberPrototype {

    public static CarNumber testFirstCarNumber() {
        CarNumber carNumber = new CarNumber();
        carNumber.setFirstChar("Х");
        carNumber.setNumber("999");
        carNumber.setSecondChar("Х");
        carNumber.setLastChar("А");
        carNumber.setCount(1);
        return carNumber;
    }

    public static CarNumber testSecondCatNumber() {
        CarNumber carNumber = new CarNumber();
        carNumber.setFirstChar("Х");
        carNumber.setNumber("000");
        carNumber.setSecondChar("Х");
        carNumber.setLastChar("В");
        carNumber.setCount(2);
        return carNumber;
    }

    public static List<CarNumber> testListCarNumber() {
        List<CarNumber> carNumbers = new ArrayList<>();
        carNumbers.add(testFirstCarNumber());
        carNumbers.add(testSecondCatNumber());
        return carNumbers;
    }
}
