package collections.list;

import collections.model.Car;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Osman on 7:26 AM
 */
public class MyListTest {
    private MyList<Car> myList;

    @Before
    public void setUp() throws Exception {
        myList = new MyLinkedList<>();
        for (int i = 0; i < 100; i++) {
            myList.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void whenAdd100ElementsThenSizeMustBe100() {
        assertEquals(100, myList.size());
    }


    @Test
    public void whenElementRemoveByIndexThenSizeMustBeDecreased() {
        assertTrue(myList.removeAt(0));
        assertEquals(99, myList.size());
    }


    @Test
    public void whenElementRemovedThenSizeMustBeDecreased() {
        Car car = new Car("Mercedes", 15);
        myList.add(car);
        assertEquals(101, myList.size());
        assertTrue(myList.remove(car));
        assertEquals(100, myList.size());
    }

    @Test
    public void whenNonExistentElementRemovedThenReturnFalse() {
        Car car = new Car("Toyota", 15);
        assertFalse(myList.remove(car));
        assertEquals(100, myList.size());

    }

    @Test
    public void whenListClearedThenSizeMustBe0() {
        myList.clear();
        assertEquals(0, myList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIndexOutOfBoundsThenThrownException() {
        myList.get(100);
    }

    @Test
    public void methodGetReturnedRightValue() {
        Car car = myList.get(0);
        assertEquals("Brand0", car.getBrand());

    }

    @Test
    public void insertInToMiddle() {
        Car car = new Car("BMV", 23);
        myList.add(car, 50);
        assertEquals(car.getBrand(), myList.get(50).getBrand());
    }


    @Test
    public void insertInToFirstPosition() {
        Car car = new Car("BMV", 23);
        myList.add(car, 0);
        assertEquals(car.getBrand(), myList.get(0).getBrand());
    }

    @Test
    public void insertInToLastPosition() {
        Car car = new Car("BMV", 23);
        myList.add(car, 100);
        assertEquals(car.getBrand(), myList.get(100).getBrand());
    }

    @Test
    public void contains() {
        assertFalse(myList.contains(new Car("Brand444", 444)));
        assertTrue(myList.contains(new Car("Brand3", 3)));
    }


}