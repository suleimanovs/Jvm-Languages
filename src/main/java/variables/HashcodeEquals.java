package variables;

import java.util.Objects;

/**
 * Created by Osman on 11:29 AM
 */
public class HashcodeEquals {
    private String brand;
    private int number;

    public HashcodeEquals(String brand, int number) {
        this.brand = brand;
        this.number = number;
    }

    public String getBrand() {
        return brand;
    }

    public int getNumber() {
        return number;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    /**
     * Правила для методов equals и hashcode:
     * 1.Переопределил equals - переопредели и hashcode
     * 2.Если хэш-коды двух обьектов разные, то и обьекты точно разные.
     * 3.Если хэш-коды двух обьетов одинаковы, то это не значит что и обьекты тоже равные,
     * хэш-коды могут просто совпасть(коллизия).
     */


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashcodeEquals car = (HashcodeEquals) o;
        return number == car.number && Objects.equals(brand, car.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, number);
    }
}
