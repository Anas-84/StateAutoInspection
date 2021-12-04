package ru.yakup.carnumber.controllers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yakup.carnumber.entities.CarNumber;
import ru.yakup.carnumber.exception.AutoNumbersAreOverException;
import ru.yakup.carnumber.services.CarNumberService;
import ru.yakup.carnumber.services.NextCarNumberService;
import ru.yakup.carnumber.services.RandomCarNumberService;
import java.util.List;

@RestController
@RequestMapping("/number")
@NoArgsConstructor
@AllArgsConstructor
public class CarNumberController {

    @Autowired
    private CarNumberService carNumberService;
    @Autowired
    private RandomCarNumberService randomService;
    @Autowired
    private NextCarNumberService nextService;

    @GetMapping("")
    public List<CarNumber> showCarNumbers() {
        return carNumberService.findAll();
    }

    @GetMapping("/random")
    public String randomCarNumber() {
        try {
            return randomService.randomCarNumber().toString();
        } catch (AutoNumbersAreOverException e) {
            return e.getMessage();
        }
    }

    @GetMapping("/next")
    public String nextCarNumber() {
        try {
            return nextService.nextCarNumber().toString();
        } catch (AutoNumbersAreOverException e) {
            return e.getMessage();
        }
    }
}
