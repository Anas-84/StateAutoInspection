package ru.yakup.carnumber.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yakup.carnumber.entities.CarNumber;
import ru.yakup.carnumber.exception.AutoNumbersAreOverException;
import ru.yakup.carnumber.methods.RandomCarNumber;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class RandomCarNumberService {
    @Autowired
    private CarNumberService carNumberService;

    public CarNumber randomCarNumber() throws AutoNumbersAreOverException {
        if (carNumberService.amount() == 12 * 10 * 10 * 10 * 12 * 12) {
            throw new AutoNumbersAreOverException("Auto numbers are over");
        }
        CarNumber carNumber = null;
        do {
            carNumber = RandomCarNumber.carNumberRandom();
        } while (carNumberService.existsCarNumber(carNumber.getFirstChar(), carNumber.getNumber(), carNumber.getSecondChar(), carNumber.getLastChar()));
        carNumberService.save(carNumber);
        return carNumber;
    }
}
