package ru.yakup.carnumber.methods;

import org.junit.jupiter.api.Test;
import ru.yakup.carnumber.entities.CarNumber;
import ru.yakup.carnumber.exception.AutoNumbersAreOverException;
import static org.junit.jupiter.api.Assertions.*;
import static ru.yakup.carnumber.prototype.CarNumberPrototype.testFirstCarNumber;
import static ru.yakup.carnumber.prototype.CarNumberPrototype.testSecondCatNumber;

class NextCarNumberTest {

    @Test
    void nextCarNumber() throws AutoNumbersAreOverException {
        CarNumber actualCarNumber = NextCarNumber.nextCarNumber(testFirstCarNumber());
        assertNotNull(actualCarNumber);
        assertNotEquals(testFirstCarNumber(), actualCarNumber);
        assertEquals(testSecondCatNumber(), actualCarNumber);
    }
}