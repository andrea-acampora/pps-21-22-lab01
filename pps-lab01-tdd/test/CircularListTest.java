import lab01.tdd.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList circularList;

    @BeforeEach
    public void setup() {
        this.circularList = new SimpleCircularList();
    }

    @Test
    public void testIsInitiallyEmpty() {
        assertTrue(this.circularList.isEmpty());
    }

    @Test
    public void testCanAddElements() {
        List<Integer> testElements = List.of(1,2,3);
        for ( Integer element : testElements ) {
            this.circularList.add(element);
        }
        assertEquals(this.circularList.size(), testElements.size() );
    }

    @Test
    public void testBasicNextElement() {
        List<Integer> testElements = List.of(1,2,3);
        for ( Integer element : testElements ) {
            this.circularList.add(element);
        }
        assertEquals(this.circularList.next().get(), testElements.get(0));
    }

    @Test
    public void testCircularNextElement() {
        List<Integer> testElements = List.of(1,2);
        for ( Integer element : testElements ) {
            this.circularList.add(element);
        }
        this.circularList.next();
        this.circularList.next();
        assertEquals(testElements.get(0), this.circularList.next().get());
    }

    @Test
    public void testPreviousElement() {
        List<Integer> testElements = List.of(1,2,3);
        for ( Integer element : testElements ) {
            this.circularList.add(element);
        }
        assertEquals(this.circularList.previous().get(), testElements.get(testElements.size() -1));
    }

    @Test
    public void testCircularPreviousElement() {

    }

    @Test
    public void testEvenStrategy() {
        List<Integer> testElements = List.of(1,2,3);
        for ( Integer element : testElements ) {
            this.circularList.add(element);
        }
        assertEquals(this.circularList.next( (int element) -> element % 2 == 0), Optional.of(2));
    }

    @Test
    public void testMultipleOfStrategy() {
        List<Integer> testElements = List.of(5,8,11,12);
        for ( Integer element : testElements ) {
            this.circularList.add(element);
        }
        assertEquals(Optional.of(8), this.circularList.next( new MultipleOfStrategy(4)));
    }


    @Test
    public void testEqualsStrategy() {
        List<Integer> testElements = List.of(1,2,3);
        for ( Integer element : testElements ) {
            this.circularList.add(element);
        }
        assertEquals(this.circularList.next( new EqualsStrategy(3)), Optional.of(3));
    }


}
