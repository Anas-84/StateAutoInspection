package ru.yakup.carnumber.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.yakup.carnumber.entities.CarNumber;

public interface CarNumberRepository extends JpaRepository<CarNumber, Integer> {

    Boolean existsCarNumberByFirstCharAndNumberAndSecondCharAndLastChar(String firstChar, String number, String secondChar, String lastChar);

    CarNumber findCarNumberByFirstCharAndNumberAndSecondCharAndLastChar(String firstChar, String number, String secondChar, String lastChar);

    @Query("SELECT cn FROM CarNumber cn WHERE cn.count = (SELECT MAX(cn.count) FROM cn)")
    CarNumber findCarNumberWithMaxCount();

    @Query("SELECT MAX(cn.count) FROM CarNumber cn")
    int maxCount();

    @Query("SELECT COUNT(cn) FROM CarNumber cn")
    int amount();
}
