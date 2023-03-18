package collections.set;

import collections.model.Car;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Osman on 11:52 AM
 */
public class CarSetTest {

    private MySet<Car> carSet;

    @Before
    public void setUp()  {
         carSet= new MyHashSet<>();
        for (int i = 0; i < 20; i++) {
            carSet.add(new Car("Brand" + i, i));
        }
    }


    @Test
    public void whenClearedSetThenSizeMustBe0() {
        carSet.clear();
        assertEquals(0, carSet.size());
    }

    @Test
    public void whenAddElementThenSizeMustBe22() {
        assertTrue(carSet.add(new Car("BMW", 21)));
        assertEquals(21, carSet.size());
        assertTrue(carSet.add(new Car("BMW2", 22)));
        assertEquals(22, carSet.size());
    }

    @Test
    public void whenAddTheSameElementsReturnFalse() {
        assertEquals(20, carSet.size());
        assertFalse(carSet.add(new Car("Brand4", 4)));
        assertTrue(carSet.add(new Car("BMW", 21)));
        assertFalse(carSet.add(new Car("BMW", 21)));
        assertFalse(carSet.add(new Car("BMW", 21)));
        assertEquals(21, carSet.size());

    }

    @Test
    public void whenRemoveNotExistElementReturnFalse() {
        assertFalse(carSet.remove(new Car("Brand45", 45)));
        assertEquals(20, carSet.size());
    }

    @Test
    public void whenRemoveElementThenSizeBe19() {
        assertTrue(carSet.remove(new Car("Brand11", 11)));
        assertEquals(19, carSet.size());
    }

    @Test
    public void contains() {
        assertFalse(carSet.contains(new Car("Brand444", 444)));
        assertTrue(carSet.contains(new Car("Brand19", 19)));
    }

}