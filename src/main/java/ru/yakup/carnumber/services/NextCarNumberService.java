package ru.yakup.carnumber.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.yakup.carnumber.model.CarNumber;
import ru.yakup.carnumber.utils.NextCarNumber;

@Slf4j
@Service
public class NextCarNumberService {

    private final CarNumberService carNumberService;

    public NextCarNumberService(CarNumberService carNumberService) {
        this.carNumberService = carNumberService;
    }

    public CarNumber nextCarNumber() {
        log.debug("Start NextCarNumberService");

        CarNumber nextCarNumber = null;
        CarNumber firstCarNumber = carNumberService.findCarNumber('A', 1, 'A', 'A');
        if (firstCarNumber == null) {
            nextCarNumber = CarNumber.builder()
                    .count(1)
                    .firstChar('A')
                    .number(1)
                    .secondChar('A')
                    .lastChar('A')
                    .build();
            carNumberService.save(nextCarNumber);
        } else {
            if (carNumberService.maxCount() == 0) {
                firstCarNumber.setCount(1);
                carNumberService.update(firstCarNumber);
            }
            do {
                CarNumber carNumber = carNumberService.findCarNumberWithMaxCount();
                nextCarNumber = NextCarNumber.nextCarNumber(carNumber);
                CarNumber checkCarNumber = carNumberService.findCarNumber(nextCarNumber.getFirstChar(),
                        nextCarNumber.getNumber(),
                        nextCarNumber.getSecondChar(),
                        nextCarNumber.getLastChar());
                if (nextCarNumber.equals(checkCarNumber)) {
                    checkCarNumber.setCount(carNumber.getCount() + 1);
                    carNumberService.update(checkCarNumber);
                } else {
                    nextCarNumber.setCount(carNumber.getCount() + 1);
                }
            } while (!carNumberService.save(nextCarNumber));
        }

        log.debug("NextCarNumberService SUCCESS");
        log.debug("NextCarNumberService SUCCESS, carNumber = {}", nextCarNumber);
        return nextCarNumber;
    }
}