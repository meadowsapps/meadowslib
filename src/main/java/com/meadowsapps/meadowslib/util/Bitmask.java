package com.meadowsapps.meadowslib.util;

/**
 * Created by dmeadows on 9/12/16.
 */
public class Bitmask {

    /**
     * The collection of boolean values
     */
    private boolean[] map;

    /**
     * Creates a new Bitmask instance with the specified size
     *
     * @param size the size of the bitmask
     */
    public Bitmask(int size) {
        this.map = new boolean[size];
    }

    /**
     * Sets the bit at the specified index to the new value
     *
     * @param index the index to set
     * @param value the value to set
     */
    public void set(int index, boolean value) {
        map[index] = value;
    }

    /**
     * Sets the bits from the start index to the stop index
     * to the new value
     *
     * @param start the start index
     * @param stop  the stop index
     * @param value the value to set
     */
    public void set(int start, int stop, boolean value) {
        for (int index = start; index < stop; index++) {
            map[index] = value;
        }
    }

    /**
     * Sets all bits to the specified value
     *
     * @param value the value to set
     */
    public void setAll(boolean value) {
        int index = 0;
        while (index < map.length) {
            if (map[index] != value) {
                map[index] = value;
            }
            index++;
        }
    }

    /**
     * Gets the value of the bit at the specified index
     *
     * @param index the index of the bit to get the value from
     * @return the value of the bit
     */
    public boolean get(int index) {
        return map[index];
    }

    /**
     * Flips the bit at the specified index
     *
     * @param index the index of the bit to flip
     */
    public void flip(int index) {
        map[index] = !map[index];
    }

    /**
     * Gets the integer value representation of the bitmask
     *
     * @return the integer value of the bitmask
     */
    public int getValue() {
        int value = 0;

        int index = 0;
        for (boolean bit : map) {
            if (bit) {
                value += (int) Math.pow(2, index);
            }
            index++;
        }

        return value;
    }

    /**
     * Sets the bitmask to represent the specified value
     *
     * @param value the new value of the bitmask
     */
    public void setValue(int value) {
        for (boolean bit : map) {
            bit = false;
        }

        StringBuilder builder = new StringBuilder(Integer.toBinaryString(value));
        String rBinary = builder.reverse().toString();
        for (int i = 0; i < rBinary.length(); i++) {
            map[i] = rBinary.charAt(i) - '0' == 1;
        }
    }

    /**
     * Gets the size of the bitmask
     *
     * @return the size of the bitmask
     */
    public int getSize() {
        return map.length;
    }

}
