package ru.yakup.carnumber.repositories;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.yakup.carnumber.entities.CarNumber;
import static ru.yakup.carnumber.prototype.CarNumberPrototype.testFirstCarNumber;
import static ru.yakup.carnumber.prototype.CarNumberPrototype.testSecondCatNumber;

@RunWith(SpringRunner.class)
@DataJpaTest
class CarNumberRepositoryTest {

    @Autowired
    private CarNumberRepository carNumberRepositoryH2;

    @Test
    void existsCarNumberByFirstCharAndNumberAndSecondCharAndLastChar() {
        carNumberRepositoryH2.saveAndFlush(testFirstCarNumber());
        Boolean result = carNumberRepositoryH2
                .existsCarNumberByFirstCharAndNumberAndSecondCharAndLastChar(testFirstCarNumber().getFirstChar(), testFirstCarNumber().getNumber(), testFirstCarNumber().getSecondChar(), testFirstCarNumber().getLastChar());
        Assert.assertEquals(result, true);
    }

    @Test
    void findCarNumberByFirstCharAndNumberAndSecondCharAndLastChar() {
        carNumberRepositoryH2.saveAndFlush(testFirstCarNumber());
        CarNumber actualСarNumber = carNumberRepositoryH2
                .findCarNumberByFirstCharAndNumberAndSecondCharAndLastChar(testFirstCarNumber().getFirstChar(), testFirstCarNumber().getNumber(), testFirstCarNumber().getSecondChar(), testFirstCarNumber().getLastChar());
        Assert.assertEquals(actualСarNumber, testFirstCarNumber());
    }

    @Test
    void findCarNumberWithMaxCount() {
        carNumberRepositoryH2.saveAndFlush(testFirstCarNumber());
        carNumberRepositoryH2.saveAndFlush(testSecondCatNumber());
        CarNumber actualСarNumber = carNumberRepositoryH2.findCarNumberWithMaxCount();
        Assert.assertEquals(actualСarNumber, testSecondCatNumber());
    }

    @Test
    void maxCount() {
        carNumberRepositoryH2.saveAndFlush(testFirstCarNumber());
        int maxCount = carNumberRepositoryH2.maxCount();
        Assert.assertEquals(maxCount, 1);
        carNumberRepositoryH2.saveAndFlush(testSecondCatNumber());
        maxCount = carNumberRepositoryH2.maxCount();
        Assert.assertEquals(maxCount, 2);
    }

    @Test
    void amount() {
        int amount = carNumberRepositoryH2.amount();
        Assert.assertEquals(amount, 0);
        carNumberRepositoryH2.saveAndFlush(testFirstCarNumber());
        carNumberRepositoryH2.saveAndFlush(testSecondCatNumber());
        amount = carNumberRepositoryH2.amount();
        Assert.assertEquals(amount, 2);
    }
}