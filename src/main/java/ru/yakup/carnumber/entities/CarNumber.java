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
    private Character firstChar;
    private Integer number;
    private Character secondChar;
    private Character lastChar;
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
        String strNumber = number.toString();
        int length = strNumber.length();
        if (length == 1) {
            return firstChar + "00" + strNumber + secondChar + lastChar + end;
        }
        else if (length == 2) {
            return firstChar + "0" +  strNumber + secondChar + lastChar + end;
        }
        else {
            return firstChar + strNumber + secondChar + lastChar + end;
        }
    }
}

