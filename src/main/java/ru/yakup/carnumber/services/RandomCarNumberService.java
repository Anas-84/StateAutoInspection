package ru.yakup.carnumber.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.yakup.carnumber.model.CarNumber;
import ru.yakup.carnumber.exception.CarNumbersAreOverException;
import ru.yakup.carnumber.utils.RandomCarNumber;

@Slf4j
@Service
public class RandomCarNumberService {

    private final CarNumberService carNumberService;

    public RandomCarNumberService(CarNumberService carNumberService) {
        this.carNumberService = carNumberService;
    }

    public CarNumber randomCarNumber() {
        log.debug("Start RandomCarNumberService");

        if (carNumberService.amount() == 12 * 10 * 10 * 10 * 12 * 12) {
            log.error("Auto numbers are over");
            throw new CarNumbersAreOverException();
        }

        CarNumber carNumber = null;
        do {
            carNumber = RandomCarNumber.carNumberRandom();
        } while (!carNumberService.save(carNumber));

        log.info("RandomCarNumberService SUCCESS!");
        log.debug("RandomCarNumberService SUCCESS, carNumber = {}", carNumber);
        return carNumber;
    }
}