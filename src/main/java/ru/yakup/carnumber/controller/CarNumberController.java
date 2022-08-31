package ru.yakup.carnumber.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yakup.carnumber.model.CarNumber;
import ru.yakup.carnumber.services.CarNumberService;
import ru.yakup.carnumber.services.NextCarNumberService;
import ru.yakup.carnumber.services.RandomCarNumberService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/number")
public class CarNumberController {

    private final CarNumberService carNumberService;
    private final RandomCarNumberService randomService;
    private final NextCarNumberService nextService;

    public CarNumberController(CarNumberService carNumberService,
                               RandomCarNumberService randomService,
                               NextCarNumberService nextService) {
        this.carNumberService = carNumberService;
        this.randomService = randomService;
        this.nextService = nextService;
    }

    @GetMapping("")
    public List<CarNumber> showCarNumbers() {
        log.info("[REQUEST all carNumber]");
        var response = carNumberService.findAll();
        log.debug("[RESPONSE all carNumber {}]", response);
        log.info("[RESPONSE all carNumber SUCCESS]");
        return response;
    }

    @GetMapping("/random")
    public String randomCarNumber() {
        log.info("[REQUEST random carNumber]");
        var response = randomService.randomCarNumber().toString();
        log.debug("[RESPONSE random carNumber = {}]", response);
        log.info("[RESPONSE random carNumber SUCCESS]");
        return response;
    }

    @GetMapping("/next")
    public String nextCarNumber() {
        log.info("[REQUEST next carNumber]");
        var response = nextService.nextCarNumber().toString();
        log.debug("[RESPONSE next carNumber = {}]", response);
        log.info("[RESPONSE next carNumber SUCCESS]");
        return response;
    }
}