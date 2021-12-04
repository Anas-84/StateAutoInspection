package ru.yakup.carnumber.services;

import ru.yakup.carnumber.entities.CarNumber;

import java.util.List;

public interface CarNumberService {

    CarNumber findCarNumber(Character firstChar, Integer number, Character secondChar, Character lastChar);

    CarNumber findCarNumberWithMaxCount();

    int maxCount();

    int amount();

    boolean existsCarNumber(Character firstChar, Integer number, Character secondChar, Character lastChar);

    void save(CarNumber carNumber);

    void update(CarNumber carNumber);

    List<CarNumber> findAll();

}
