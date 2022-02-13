package collections.list;

import collections.model.Car;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Osman on 7:26 AM
 */
public class CarListTest {
    private  CarList<Car> carList;

    @Before
    public void setUp() throws Exception {
        carList = new CarLinkedList<>();
        for (int i = 0; i < 100; i++) {
            carList.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void whenAdd100ElementsThenSizeMustBe100() {
        assertEquals(100, carList.size());
    }


    @Test
    public void whenElementRemoveByIndexThenSizeMustBeDecreased() {
        assertTrue(carList.removeAt(0));
        assertEquals(99, carList.size());
    }


    @Test
    public void whenElementRemovedThenSizeMustBeDecreased() {
        Car car = new Car("Mercedes", 15);
        carList.add(car);
        assertEquals(101, carList.size());
        assertTrue(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test
    public void whenNonExistentElementRemovedThenReturnFalse() {
        Car car = new Car("Toyota", 15);
        assertFalse(carList.remove(car));
        assertEquals(100, carList.size());

    }

    @Test
    public void whenListClearedThenSizeMustBe0() {
        carList.clear();
        assertEquals(0, carList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIndexOutOfBoundsThenThrownException() {
        carList.get(100);
    }

    @Test
    public void methodGetReturnedRightValue() {
        Car car = carList.get(0);
        assertEquals("Brand0", car.getBrand());

    }

    @Test
    public void insertInToMiddle() {
        Car car = new Car("BMV", 23);
        carList.add(car, 50);
        assertEquals(car.getBrand(), carList.get(50).getBrand());
    }


    @Test
    public void insertInToFirstPosition() {
        Car car = new Car("BMV", 23);
        carList.add(car, 0);
        assertEquals(car.getBrand(), carList.get(0).getBrand());
    }

    @Test
    public void insertInToLastPosition() {
        Car car = new Car("BMV", 23);
        carList.add(car, 100);
        assertEquals(car.getBrand(), carList.get(100).getBrand());
    }

    @Test
    public void contains() {
        assertFalse(carList.contains(new Car("Brand444", 444)));
        assertTrue(carList.contains(new Car("Brand3", 3)));
    }


}