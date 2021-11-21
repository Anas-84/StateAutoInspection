package ru.yakup.carnumber.controllers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yakup.carnumber.entities.CarNumber;
import ru.yakup.carnumber.exception.AutoNumbersAreOverException;
import ru.yakup.carnumber.methods.NextCarNumber;
import ru.yakup.carnumber.methods.RandomCarNumber;
import ru.yakup.carnumber.services.CarNumberService;

import java.util.List;

@RestController
@RequestMapping("/number")
@NoArgsConstructor
@AllArgsConstructor
public class CarNumberController {

    @Autowired
    private CarNumberService carNumberService;

    @GetMapping("")
    public List<CarNumber> showCarNumbers() {
        List<CarNumber> carNumbers = carNumberService.findAll();
        return carNumbers;
    }

    @GetMapping("/random")
    public String randomCarNumber() {
        CarNumber carNumber = null;
        do {
            carNumber = RandomCarNumber.carNumberRandom();
        } while (carNumberService.existsCarNumberByFirstCharAndNumberAndSecondCharAndLastChar(carNumber.getFirstChar(), carNumber.getNumber(), carNumber.getSecondChar(), carNumber.getLastChar()));
        carNumberService.save(carNumber);
        return carNumber.toString();
    }

    @GetMapping("/next")
    public String nextCarNumber() {
        CarNumber nextCarNumber = null;
        if (carNumberService.amount() == 0 || carNumberService.maxCount() == 0) {
            nextCarNumber = new CarNumber(0,1,"А", "000", "А", "А");
        }
        else {
            CarNumber carNumber = null;
            CarNumber checkCarNumber = null;
            do {
                carNumber = carNumberService.findCarNumberWithMaxCount();
                try {
                    nextCarNumber = NextCarNumber.nextCarNumber(carNumber);
                } catch (AutoNumbersAreOverException e) {
                    return e.getMessage();
                }
                checkCarNumber = carNumberService.findCarNumberByFirstCharAndNumberAndSecondCharAndLastChar(nextCarNumber.getFirstChar(), nextCarNumber.getNumber(), nextCarNumber.getSecondChar(), nextCarNumber.getLastChar());
                if(nextCarNumber.equals(checkCarNumber)) {
                    checkCarNumber.setCount(carNumber.getCount() + 1);
                    carNumberService.update(checkCarNumber);
                }
                else {
                    nextCarNumber.setCount(carNumber.getCount() + 1);
                }
            } while (carNumberService.existsCarNumberByFirstCharAndNumberAndSecondCharAndLastChar(nextCarNumber.getFirstChar(), nextCarNumber.getNumber(), nextCarNumber.getSecondChar(), nextCarNumber.getLastChar()));
        }
        carNumberService.save(nextCarNumber);
        return nextCarNumber.toString();
    }
}
