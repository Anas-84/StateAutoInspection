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
    public Boolean existsCarNumberByFirstCharAndNumberAndSecondCharAndLastChar(String firstChar, String number, String secondChar, String lastChar) {
        Boolean result = carNumberRepository.existsCarNumberByFirstCharAndNumberAndSecondCharAndLastChar(firstChar, number, secondChar, lastChar);
        return result;
    }

    @Override
    public CarNumber findCarNumberByFirstCharAndNumberAndSecondCharAndLastChar(String firstChar, String number, String secondChar, String lastChar) {
        CarNumber carNumber = carNumberRepository.findCarNumberByFirstCharAndNumberAndSecondCharAndLastChar(firstChar, number, secondChar, lastChar);
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
    public void save(CarNumber carNumber) {
        if (!existsCarNumberByFirstCharAndNumberAndSecondCharAndLastChar(carNumber.getFirstChar(),carNumber.getNumber(),carNumber.getSecondChar(),carNumber.getLastChar())){
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
