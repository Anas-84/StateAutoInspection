package ru.yakup.carnumber.utils;

import org.junit.jupiter.api.Test;
import ru.yakup.carnumber.model.CarNumber;
import ru.yakup.carnumber.exception.CarNumbersAreOverException;

import static org.junit.jupiter.api.Assertions.*;
import static ru.yakup.carnumber.prototype.CarNumberPrototype.testFirstCarNumber;
import static ru.yakup.carnumber.prototype.CarNumberPrototype.testSecondCatNumber;

class NextCarNumberTest {

    @Test
    void testNextCarNumber() throws CarNumbersAreOverException {
        CarNumber actualCarNumber = NextCarNumber.nextCarNumber(testFirstCarNumber());
        assertNotNull(actualCarNumber);
        assertNotEquals(testFirstCarNumber(), actualCarNumber);
        assertEquals(testSecondCatNumber(), actualCarNumber);
    }

    @Test
    void testComplexCarNumber() {
        assertEquals(NextCarNumber.nextCarNumber(CarNumber.builder()
                        .firstChar('A')
                        .number(1)
                        .secondChar('A')
                        .lastChar('A')
                        .build()),
                CarNumber.builder().
                        firstChar('A')
                        .number(2)
                        .secondChar('A')
                        .lastChar('A')
                        .build());

        assertEquals(NextCarNumber.nextCarNumber(CarNumber.builder()
                        .firstChar('A')
                        .number(999)
                        .secondChar('A')
                        .lastChar('A')
                        .build()),
                CarNumber.builder().
                        firstChar('A')
                        .number(1)
                        .secondChar('A')
                        .lastChar('B')
                        .build());

        assertEquals(NextCarNumber.nextCarNumber(CarNumber.builder()
                        .firstChar('A')
                        .number(999)
                        .secondChar('A')
                        .lastChar('X')
                        .build()),
                CarNumber.builder().
                        firstChar('A')
                        .number(1)
                        .secondChar('B')
                        .lastChar('X')
                        .build());

        assertEquals(NextCarNumber.nextCarNumber(CarNumber.builder()
                        .firstChar('A')
                        .number(998)
                        .secondChar('B')
                        .lastChar('X')
                        .build()),
                CarNumber.builder().
                        firstChar('A')
                        .number(999)
                        .secondChar('B')
                        .lastChar('X')
                        .build());

        assertEquals(NextCarNumber.nextCarNumber(CarNumber.builder()
                        .firstChar('A')
                        .number(999)
                        .secondChar('X')
                        .lastChar('X')
                        .build()),
                CarNumber.builder().
                        firstChar('B')
                        .number(1)
                        .secondChar('X')
                        .lastChar('X')
                        .build());

        assertEquals(NextCarNumber.nextCarNumber(CarNumber.builder()
                        .firstChar('A')
                        .number(1)
                        .secondChar('X')
                        .lastChar('X')
                        .build()),
                CarNumber.builder().
                        firstChar('A')
                        .number(2)
                        .secondChar('X')
                        .lastChar('X')
                        .build());

        assertEquals(NextCarNumber.nextCarNumber(CarNumber.builder()
                        .firstChar('B')
                        .number(999)
                        .secondChar('X')
                        .lastChar('X')
                        .build()),
                CarNumber.builder().
                        firstChar('E')
                        .number(1)
                        .secondChar('X')
                        .lastChar('X')
                        .build());
    }
}