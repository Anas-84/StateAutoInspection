package ru.yakup.carnumber.services;

import ru.yakup.carnumber.entities.CarNumber;

import java.util.List;

public interface CarNumberService {

    Boolean existsCarNumberByFirstCharAndNumberAndSecondCharAndLastChar(String firstChar, String number, String secondChar, String lastChar);

    CarNumber findCarNumberByFirstCharAndNumberAndSecondCharAndLastChar(String firstChar, String number, String secondChar, String lastChar);

    CarNumber findCarNumberWithMaxCount();

    int maxCount();

    int amount();

    void save(CarNumber carNumber);

    void update(CarNumber carNumber);

    List<CarNumber> findAll();

}
