package com.codecool.dynamicarray;

import java.util.Arrays;

public class DynamicArray {
    private int[] array = new int[0];
    private int capacity;

    public DynamicArray(int capacity) {
        this.capacity = capacity;
    }

    public DynamicArray() {
        this(4);
    }

    public int getCapacity() {
        return capacity;
    }

    public int size() {
        return array.length;
    }

    public void add(int value) {
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = value;
    }

    public int get(int index) {
        return array[index];
    }

    public void remove(int indexToBeRemoved) {
        int[] copy = new int[array.length - 1];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (i != indexToBeRemoved) {
                copy[j++] = array[i];
            }
        }
        array = copy;
    }

    public void insert(int index, int newValue) {
        if (index < array.length) {
            array = Arrays.copyOf(array, array.length + 1);
            for (int i = array.length - 2; i > index; i--) {
                if (i > index) {
                    array[i] = array[i - 1];
                }
            }
            array[index] = newValue;
            if (array.length > capacity) {
                capacity *= 2;
            }
        }
        else {
            array = Arrays.copyOf(array, array.length + 1);
            array[array.length - 1] = newValue;
            if (array.length > capacity) {
                capacity *= 2;
            }
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < array.length; i++) {
            result += array[i];
            if (i != array.length - 1) {
                result += ", ";
            }
        }
        return array.length > 0 ? String.format("[%s]", result) : "[]";
    }
}
