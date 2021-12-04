package ru.yakup.carnumber.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yakup.carnumber.entities.CarNumber;
import ru.yakup.carnumber.repositories.CarNumberRepository;
import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class CarNumberServiceImp implements CarNumberService {

    @Autowired
    CarNumberRepository carNumberRepository;

    @Override
    public CarNumber findCarNumber(Character firstChar, Integer number, Character secondChar, Character lastChar) {
        CarNumber carNumber = carNumberRepository.findCarNumber(firstChar, number, secondChar, lastChar);
        return carNumber;
    }

    @Override
    public CarNumber findCarNumberWithMaxCount() {
        CarNumber carNumber = carNumberRepository.findCarNumberWithMaxCount();
        return carNumber;
    }

    @Override
    public int maxCount() {
        int count = carNumberRepository.maxCount();
        return count;
    }

    @Override
    public int amount() {
        int amount = carNumberRepository.amount();
        return amount;
    }

    @Override
    public boolean existsCarNumber(Character firstChar, Integer number, Character secondChar, Character lastChar) {
        return carNumberRepository.existsCarNumber(firstChar, number, secondChar, lastChar);
    }

    @Override
    public void save(CarNumber carNumber) {
        if (!existsCarNumber(carNumber.getFirstChar(),carNumber.getNumber(),carNumber.getSecondChar(),carNumber.getLastChar())){
            carNumberRepository.saveAndFlush(carNumber);
        }
    }

    @Override
    public void update(CarNumber carNumber) {
        carNumberRepository.saveAndFlush(carNumber);
    }

    @Override
    public List<CarNumber> findAll() {
        List<CarNumber> carNumbers = carNumberRepository.findAll();
        return carNumbers;
    }
}
