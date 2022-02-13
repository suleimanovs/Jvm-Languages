package collections.model;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Osman on 7:21 AM
 */
public class Car implements Comparable<Car>{
    private String brand;
    private int number;

    public Car(String brand, int number) {
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

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;
        return number == car.number && brand.equals(car.brand);
    }

    @Override
    public int hashCode() {
        return brand.hashCode() + number;
    }


    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", number=" + number +
                '}';
    }

    @Override
    public int compareTo(@NotNull Car o) {
       return brand.compareTo(o.brand);
    }
}
