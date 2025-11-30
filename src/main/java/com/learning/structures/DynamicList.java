package com.learning.structures;

import java.util.Arrays;

@SuppressWarnings("unchecked")
public class DynamicList<E> {
    private Object[] backingArray;
    private int size;

    public DynamicList() {
        backingArray = new Object[10];
    }
    
    public DynamicList(int initialCapacity) {
        if (initialCapacity < 0) throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        backingArray = new Object[initialCapacity];
    }
    
    public DynamicList(E[] array) {
        backingArray = new Object[array.length];
        System.arraycopy(array, 0, backingArray, 0, array.length);
        size = backingArray.length;
    }

    private void resize(int newCapacity) {
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(backingArray, 0, newArray, 0, size);
        backingArray = newArray;
    }

    private boolean isFull() {
        return size == backingArray.length;
    }

    private void checkIndexForAccess(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "The given index " + index + " is out of bounds, the array size is " + size
            );
        }
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(
                    "The given index " + index + " is out of bounds, the array size is " + size
            );
        }
    }

    public void add(E e) {
        if (isFull()) {
            int newCapacity = backingArray.length == 0 ? 10 : backingArray.length * 2;
            resize(newCapacity);
        }
       backingArray[size++] = e;
    }

    public void add(int index, E element) {
        checkIndexForAdd(index);
        if (isFull()) {
            int newCapacity = backingArray.length == 0 ? 10 : backingArray.length * 2;
            resize(newCapacity);
        }
        System.arraycopy(backingArray, index, backingArray, index + 1, size - index);
        backingArray[index] = element;
        size++;
    }

    public E get(int index) {
        checkIndexForAccess(index);
        return (E) backingArray[index];
    }

    public E set(int index, E element) {
        checkIndexForAccess(index);
        E oldValue = (E) backingArray[index];
        backingArray[index] = element;
        return oldValue;
    }

    public E remove(int index) {
        checkIndexForAccess(index);
        E oldValue = (E) backingArray[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(backingArray, index + 1, backingArray, index, numMoved);
        }
        backingArray[--size] = null;
        return oldValue;
    }

    public boolean remove(Object element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (backingArray[i] == null) {
                    remove(i);
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(backingArray[i])) {
                    remove(i);
                    return true;
                }
            }
        }
        return false;
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            backingArray[i] = null;
        }
        size = 0;
    }

    public boolean contains(Object element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (backingArray[i] == null) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(backingArray[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    public int indexOf(Object element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (backingArray[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(backingArray[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int lastIndexOf(E element) {
        if (element == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (backingArray[i] == null) return i;
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (element.equals(backingArray[i])) return i;
            }
        }
        return -1;
    }

    public String toString() {
        Object[] printArray = new Object[size];
        System.arraycopy(backingArray, 0, printArray, 0, size);
        return Arrays.toString(printArray);
    }
}
