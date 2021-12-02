package ru.yakup.carnumber.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "car_numbers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CarNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int count;
    private  String firstChar;
    private String number;
    private String secondChar;
    private String lastChar;
    private final String end = " 116 RUS";

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarNumber carNumber = (CarNumber) o;
        return Objects.equals(firstChar, carNumber.firstChar) && Objects.equals(number, carNumber.number) && Objects.equals(secondChar, carNumber.secondChar) && Objects.equals(lastChar, carNumber.lastChar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstChar, number, secondChar, lastChar);
    }

    @Override
    public String toString() {
        return firstChar + number + secondChar + lastChar + end;
    }
}

