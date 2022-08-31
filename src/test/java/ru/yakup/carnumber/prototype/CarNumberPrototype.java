package ru.yakup.carnumber.prototype;

import ru.yakup.carnumber.model.CarNumber;

import java.util.List;

public class CarNumberPrototype {

    public static CarNumber testFirstCarNumber() {
        return CarNumber.builder()
                .count(1)
                .firstChar('A')
                .number(999)
                .secondChar('X')
                .lastChar('X')
                .build();
    }

    public static CarNumber testSecondCatNumber() {
        return CarNumber.builder()
                .count(2)
                .firstChar('B')
                .number(1)
                .secondChar('X')
                .lastChar('X')
                .build();
    }

    public static List<CarNumber> testListCarNumber() {
        return List.of(testFirstCarNumber(), testSecondCatNumber());
    }
}
