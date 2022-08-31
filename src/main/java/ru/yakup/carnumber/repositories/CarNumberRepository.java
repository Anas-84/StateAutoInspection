package ru.yakup.carnumber.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.yakup.carnumber.model.CarNumber;

import java.util.List;

@Repository
public interface CarNumberRepository extends JpaRepository<CarNumber, Integer> {

    @Query("SELECT cn " +
            "FROM CarNumber cn " +
            "WHERE cn.firstChar = :firstChar " +
            "AND cn.number = :number " +
            "AND cn.secondChar = :secondChar " +
            "AND cn.lastChar = :lastChar")
    CarNumber findCarNumber(
            @Param("firstChar") Character firstChar,
            @Param("number") Integer number,
            @Param("secondChar") Character secondChar,
            @Param("lastChar") Character lastChar);

    @Query("SELECT (COUNT(cn) > 0) " +
            "FROM CarNumber cn " +
            "WHERE cn.firstChar = :firstChar " +
            "AND cn.number = :number " +
            "AND cn.secondChar = :secondChar " +
            "AND cn.lastChar = :lastChar")
    boolean existsCarNumber(
            @Param("firstChar") Character firstChar,
            @Param("number") Integer number,
            @Param("secondChar") Character secondChar,
            @Param("lastChar") Character lastChar);

    @Query("SELECT cn " +
            "FROM CarNumber cn " +
            "WHERE cn.count = " +
            "(SELECT MAX(cn.count) " +
            "FROM cn)")
    List<CarNumber> findCarNumberWithMaxCount();

    @Query("SELECT MAX(cn.count) " +
            "FROM CarNumber cn")
    int maxCount();

    @Query("SELECT COUNT(cn) " +
            "FROM CarNumber cn")
    int amount();
}