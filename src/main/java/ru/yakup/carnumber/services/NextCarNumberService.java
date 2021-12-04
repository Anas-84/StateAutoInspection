package ru.yakup.carnumber.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yakup.carnumber.entities.CarNumber;
import ru.yakup.carnumber.exception.AutoNumbersAreOverException;
import ru.yakup.carnumber.methods.NextCarNumber;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class NextCarNumberService {
    @Autowired
    private CarNumberService carNumberService;

    public synchronized CarNumber nextCarNumber() throws AutoNumbersAreOverException {
        CarNumber firstCarNumber = carNumberService.findCarNumber('А', 0, 'А', 'А');
        CarNumber nextCarNumber = null;
        if (carNumberService.amount() == 0) {
            nextCarNumber = new CarNumber(0, 1, 'А', 0, 'А', 'А');
        }
        else {
            if (carNumberService.maxCount() == 0 && firstCarNumber != null) {
                firstCarNumber.setCount(1);
                carNumberService.update(firstCarNumber);
            }
            do {
                CarNumber carNumber = carNumberService.findCarNumberWithMaxCount();
                nextCarNumber = NextCarNumber.nextCarNumber(carNumber);
                CarNumber checkCarNumber = carNumberService.findCarNumber(nextCarNumber.getFirstChar(), nextCarNumber.getNumber(), nextCarNumber.getSecondChar(), nextCarNumber.getLastChar());
                if (nextCarNumber.equals(checkCarNumber)) {
                    checkCarNumber.setCount(carNumber.getCount() + 1);
                    carNumberService.update(checkCarNumber);
                } else {
                    nextCarNumber.setCount(carNumber.getCount() + 1);
                }
            } while (carNumberService.existsCarNumber(nextCarNumber.getFirstChar(), nextCarNumber.getNumber(), nextCarNumber.getSecondChar(), nextCarNumber.getLastChar()));
        }
        carNumberService.save(nextCarNumber);
        return nextCarNumber;
    }
}
