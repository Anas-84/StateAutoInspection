package ru.yakup.carnumber.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.yakup.carnumber.model.CarNumber;
import static ru.yakup.carnumber.prototype.CarNumberPrototype.testFirstCarNumber;
import static ru.yakup.carnumber.prototype.CarNumberPrototype.testSecondCatNumber;

@RunWith(SpringRunner.class)
@DataJpaTest
class CarNumberRepositoryTest {

    @Autowired
    private CarNumberRepository carNumberRepositoryH2;

    @Test
    void testFindCarNumber() {
        carNumberRepositoryH2.saveAndFlush(testFirstCarNumber());
        CarNumber actualСarNumber = carNumberRepositoryH2.findCarNumber(testFirstCarNumber().getFirstChar(),
                testFirstCarNumber().getNumber(),
                testFirstCarNumber().getSecondChar(),
                testFirstCarNumber().getLastChar());
        Assertions.assertEquals(actualСarNumber, testFirstCarNumber());
    }

    @Test
    void testFindCarNumberWithMaxCount() {
        carNumberRepositoryH2.saveAndFlush(testFirstCarNumber());
        carNumberRepositoryH2.saveAndFlush(testSecondCatNumber());
        CarNumber actualСarNumber = carNumberRepositoryH2.findCarNumberWithMaxCount().get(0);
        Assertions.assertEquals(actualСarNumber, testSecondCatNumber());
    }

    @Test
    void testMaxCount() {
        carNumberRepositoryH2.saveAndFlush(testFirstCarNumber());
        int maxCount = carNumberRepositoryH2.maxCount();
        Assertions.assertEquals(maxCount, 1);
        carNumberRepositoryH2.saveAndFlush(testSecondCatNumber());
        maxCount = carNumberRepositoryH2.maxCount();
        Assertions.assertEquals(maxCount, 2);
    }

    @Test
    void testAmount() {
        int amount = carNumberRepositoryH2.amount();
        Assertions.assertEquals(amount, 0);
        carNumberRepositoryH2.saveAndFlush(testFirstCarNumber());
        carNumberRepositoryH2.saveAndFlush(testSecondCatNumber());
        amount = carNumberRepositoryH2.amount();
        Assertions.assertEquals(amount, 2);
    }
}