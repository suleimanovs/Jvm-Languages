package collections;

import collections.list.MyLinkedList;
import collections.model.Car;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Osman on 1:54 PM
 */
public class CarCollectionTest {

    private MyCollection<Car> myCollection;

    @Before
    public void setUp() throws Exception {
        myCollection = new MyLinkedList<>();
        for (int i = 0; i < 100; i++) {
            myCollection.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void contains() {
        assertTrue(myCollection.contains(new Car("Brand20", 20)));
        assertFalse(myCollection.contains(new Car("Brand200", 20)));
    }

    @Test
    public void testForeach() {
        int index = 0;
        for (Car car : myCollection) {
            index++;
        }
        assertEquals(100, index);
    }
}