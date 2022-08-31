package ru.yakup.carnumber.services;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import ru.yakup.carnumber.model.CarNumber;
import ru.yakup.carnumber.repositories.CarNumberRepository;

import java.util.List;

@Service
public class CarNumberServiceImp implements CarNumberService {

    private final CarNumberRepository carNumberRepository;

    public CarNumberServiceImp(CarNumberRepository carNumberRepository) {
        this.carNumberRepository = carNumberRepository;
    }

    @Override
    public CarNumber findCarNumber(char firstChar, int number, char secondChar, char lastChar) {
        return carNumberRepository.findCarNumber(firstChar, number, secondChar, lastChar);
    }

    @Override
    public CarNumber findCarNumberWithMaxCount() {
        List<CarNumber> carNumbers = carNumberRepository.findCarNumberWithMaxCount();
        return ObjectUtils.isEmpty(carNumbers) ? null : carNumbers.get(0);
    }

    @Override
    public int maxCount() {
        return carNumberRepository.maxCount();
    }

    @Override
    public int amount() {
        return carNumberRepository.amount();
    }

    @Override
    public boolean existsCarNumber(char firstChar, int number, char secondChar, char lastChar) {
        return carNumberRepository.existsCarNumber(firstChar, number, secondChar, lastChar);
    }

    @Override
    public synchronized boolean save(CarNumber carNumber) {
        if (existsCarNumber(carNumber.getFirstChar(),
                carNumber.getNumber(),
                carNumber.getSecondChar(),
                carNumber.getLastChar())) {
            return false;
        } else {
            carNumberRepository.saveAndFlush(carNumber);
            return true;
        }
    }

    @Override
    public synchronized void update(CarNumber carNumber) {
        carNumberRepository.saveAndFlush(carNumber);
    }

    @Override
    public List<CarNumber> findAll() {
        return carNumberRepository.findAll();
    }
}