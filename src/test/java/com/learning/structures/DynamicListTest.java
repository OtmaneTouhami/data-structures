package com.learning.structures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DynamicListTest {
    private DynamicList<Integer> list;

    @BeforeEach
    void setup() {
        list = new DynamicList<>();
    }

    @Test
    void testAddAndGet() {
        list.add(10);
        list.add(20);
        list.add(30);

        assertEquals(3, list.size());
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
    }

    @Test
    void testAddAtIndex() {
        list.add(10);
        list.add(30);
        list.add(1, 20);

        assertEquals(3, list.size());
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
    }

    @Test
    void testAddAtInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, 5));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(1, 5));
    }

    @Test
    void testResize() {
        DynamicList<Integer> large = new DynamicList<>(1);
        large.add(1);
        large.add(2);
        large.add(3);

        assertEquals(3, large.size());
        assertEquals(1, large.get(0));
        assertEquals(2, large.get(1));
        assertEquals(3, large.get(2));
    }

    @Test
    void testSet() {
        list.add(10);
        list.add(20);

        int old = list.set(1, 99);

        assertEquals(20, old);
        assertEquals(99, list.get(1));
    }

    @Test
    void testSetInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(0, 10));
    }

    @Test
    void testRemoveByIndex() {
        list.add(10);
        list.add(20);
        list.add(30);

        int removed = list.remove(1);

        assertEquals(20, removed);
        assertEquals(2, list.size());
        assertEquals(10, list.get(0));
        assertEquals(30, list.get(1));
    }

    @Test
    void testRemoveByIndexInvalid() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    }

    @Test
    void testRemoveByElement() {
        list.add(10);
        list.add(20);
        list.add(30);

        assertTrue(list.remove(Integer.valueOf(20)));
        assertEquals(2, list.size());
        assertFalse(list.contains(20));
    }

    @Test
    void testRemoveByElementNotFound() {
        list.add(10);
        list.add(20);

        assertFalse(list.remove(Integer.valueOf(30)));
        assertEquals(2, list.size());
    }

    @Test
    void testRemoveNullElement() {
        DynamicList<String> l = new DynamicList<>();
        l.add(null);
        l.add("A");

        assertTrue(l.remove(null));
        assertEquals(1, l.size());
        assertFalse(l.contains(null));
    }

    @Test
    void testContains() {
        list.add(10);
        list.add(20);

        assertTrue(list.contains(10));
        assertTrue(list.contains(20));
        assertFalse(list.contains(30));
    }

    @Test
    void testContainsNull() {
        DynamicList<String> l = new DynamicList<>();
        l.add("A");
        l.add(null);

        assertTrue(l.contains(null));
    }

    @Test
    void testIndexOf() {
        list.add(10);
        list.add(20);
        list.add(20);

        assertEquals(1, list.indexOf(20));
        assertEquals(0, list.indexOf(10));
        assertEquals(-1, list.indexOf(30));
    }

    @Test
    void testIndexOfNull() {
        DynamicList<String> l = new DynamicList<>();
        l.add(null);
        l.add("A");

        assertEquals(0, l.indexOf(null));
    }

    @Test
    void testLastIndexOf() {
        list.add(5);
        list.add(10);
        list.add(10);
        list.add(20);

        assertEquals(2, list.lastIndexOf(10));
        assertEquals(0, list.lastIndexOf(5));
        assertEquals(-1, list.lastIndexOf(99));
    }

    @Test
    void testLastIndexOfNull() {
        DynamicList<String> l = new DynamicList<>();
        l.add("A");
        l.add(null);
        l.add("B");
        l.add(null);

        assertEquals(3, l.lastIndexOf(null));
    }

    @Test
    void testIsEmptyAndSize() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());

        list.add(5);

        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
    }

    @Test
    void testClear() {
        list.add(1);
        list.add(2);

        list.clear();

        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
        assertFalse(list.contains(1));
    }

    @Test
    void testConstructorFromArray() {
        Integer[] arr = {1, 2, 3};
        DynamicList<Integer> l = new DynamicList<>(arr);

        assertEquals(3, l.size());
        assertEquals(1, l.get(0));
        assertEquals(2, l.get(1));
        assertEquals(3, l.get(2));
    }

    @Test
    void testToStringFormat() {
        list.add(10);
        list.add(20);

        assertEquals("[10, 20]", list.toString());
    }

    @Test
    void testAddAtHeadAndTail() {
        list.add(0, 10); // Add to empty list at 0
        list.add(0, 5);  // Add to head (shift right)
        list.add(2, 20); // Add to tail (append)

        assertEquals(3, list.size());
        assertEquals(5, list.get(0));
        assertEquals(10, list.get(1));
        assertEquals(20, list.get(2));
    }

    @Test
    void testRemoveHeadAndTail() {
        list.add(10);
        list.add(20);
        list.add(30);

        assertEquals(30, list.remove(2));
        assertEquals(2, list.size());

        assertEquals(10, list.remove(0));
        assertEquals(1, list.size());
        assertEquals(20, list.get(0));
    }

    @Test
    void testZeroInitialCapacity() {
        DynamicList<Integer> zeroList = new DynamicList<>(0);
        assertTrue(zeroList.isEmpty());

        zeroList.add(1);

        assertEquals(1, zeroList.size());
        assertEquals(1, zeroList.get(0));
    }

    @Test
    void testNegativeCapacityConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new DynamicList<>(-5));
    }

    @Test
    void testLargeVolumeData() {
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        assertEquals(100, list.size());
        assertEquals(0, list.get(0));
        assertEquals(99, list.get(99));
    }
}
