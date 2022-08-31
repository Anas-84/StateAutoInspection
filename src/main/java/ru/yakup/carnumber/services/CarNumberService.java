package ru.yakup.carnumber.services;

import ru.yakup.carnumber.model.CarNumber;

import java.util.List;

public interface CarNumberService {

    CarNumber findCarNumber(char firstChar, int number, char secondChar, char lastChar);

    CarNumber findCarNumberWithMaxCount();

    int maxCount();

    int amount();

    boolean existsCarNumber(char firstChar, int number, char secondChar, char lastChar);

    boolean save(CarNumber carNumber);

    void update(CarNumber carNumber);

    List<CarNumber> findAll();
}