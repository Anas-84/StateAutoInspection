package ru.yakup.carnumber.model;

import lombok.*;

import javax.persistence.*;
import java.text.DecimalFormat;
import java.util.Objects;

@Entity
@Table(name = "car_numbers")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CarNumber {

    private static final String CAR_NUMBER_END = " 116RUS";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int count;
    private char firstChar;
    private int number;
    private char secondChar;
    private char lastChar;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarNumber carNumber = (CarNumber) o;
        return firstChar == carNumber.firstChar &&
                number == carNumber.number &&
                secondChar == carNumber.secondChar &&
                lastChar == carNumber.lastChar;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstChar, number, secondChar, lastChar);
    }

    @Override
    public String toString() {
        return firstChar + new DecimalFormat("000").format(number) + secondChar + lastChar + CAR_NUMBER_END;
    }
}