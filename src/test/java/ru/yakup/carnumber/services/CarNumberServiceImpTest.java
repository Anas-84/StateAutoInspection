package ru.yakup.carnumber.services;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.yakup.carnumber.entities.CarNumber;
import ru.yakup.carnumber.repositories.CarNumberRepository;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static ru.yakup.carnumber.prototype.CarNumberPrototype.*;

class CarNumberServiceImpTest {

    private CarNumberRepository carNumberRepository;
    private CarNumberService carNumberService;

    @BeforeEach
    void setUp() {
        carNumberRepository = mock(CarNumberRepository.class);
        carNumberService = new CarNumberServiceImp(carNumberRepository);
    }

    @Test
    void testFindCarNumber() {
        when(carNumberRepository.findCarNumber(testFirstCarNumber().getFirstChar(), testFirstCarNumber().getNumber(), testFirstCarNumber().getSecondChar(), testFirstCarNumber().getLastChar())).thenReturn(testFirstCarNumber());
        CarNumber carNumber = carNumberService.findCarNumber(testFirstCarNumber().getFirstChar(), testFirstCarNumber().getNumber(), testFirstCarNumber().getSecondChar(), testFirstCarNumber().getLastChar());
        Assert.assertEquals(carNumber,testFirstCarNumber());
    }

    @Test
    void testFindCarNumberWithMaxCount() {
        when(carNumberRepository.findCarNumberWithMaxCount()).thenReturn(testFirstCarNumber());
        CarNumber carNumber = carNumberService.findCarNumberWithMaxCount();
        Assert.assertEquals(carNumber, testFirstCarNumber());
    }

    @Test
    void testMaxCount() {
        when(carNumberRepository.maxCount()).thenReturn(1);
        int maxCount = carNumberService.maxCount();
        Assert.assertEquals(maxCount, 1);
    }

    @Test
    void testAmount() {
        when(carNumberRepository.amount()).thenReturn(0);
        int amount = carNumberService.amount();
        Assert.assertEquals(amount, 0);
    }

    @Test
    void testSave() {
        when(carNumberRepository.saveAndFlush(any())).thenReturn(testFirstCarNumber());
        carNumberService.save(testFirstCarNumber());
        Assert.assertNotNull(testFirstCarNumber());
    }

    @Test
    void testUpdate() {
        when(carNumberRepository.saveAndFlush(any())).thenReturn(testFirstCarNumber());
        carNumberService.update(testFirstCarNumber());
        Assert.assertNotNull(testFirstCarNumber());
    }

    @Test
    void testFindAll() {
        when(carNumberRepository.findAll()).thenReturn(testListCarNumber());
        List<CarNumber> carNumbers = carNumberService.findAll();
        Assert.assertNotNull(carNumbers);
        Assert.assertEquals(carNumbers, testListCarNumber());
    }
}