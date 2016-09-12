package com.meadowsapps.meadowslib.util;

/**
 * Created by dmeadows on 9/12/16.
 */
public class KeyValuePair<K, V> {

    /**
     * The key
     */
    private K key;

    /**
     * The value
     */
    private V value;

    /**
     * Creates an empty, new KeyValuePair instance
     */
    public KeyValuePair() {
    }

    /**
     * Creates a new KeyValuePair instance with the specified
     * key and value
     *
     * @param key   the desired key
     * @param value the desire value
     */
    public KeyValuePair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Gets the key
     *
     * @return the key
     */
    public K getKey() {
        return key;
    }

    /**
     * Sets the key to the specified value
     *
     * @param key the new key value
     */
    public void setKey(K key) {
        this.key = key;
    }

    /**
     * Gets the value
     *
     * @return the value
     */
    public V getValue() {
        return value;
    }

    /**
     * Sets the value to the specified value
     *
     * @param value the new value
     */
    public void setValue(V value) {
        this.value = value;
    }
}
