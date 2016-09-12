package com.meadowsapps.meadowslib.util.thread;

/**
 * Created by dmeadows on 9/12/16.
 */
public interface ThreadI extends Executable {

    /**
     * Starts the thread
     */
    void start();

    /**
     * Gets the name of the thread
     *
     * @return the thread's name
     */
    String getName();

    /**
     * Sets the name of the thread
     *
     * @param name the thread's new name
     */
    void setName(String name);

    /**
     * Gets the priority of the thread
     *
     * @return the thread's priority
     */
    int getPriority();

    /**
     * Sets the priority of the thread
     *
     * @param priority the thread's new priority
     */
    void setPriority(int priority);

    /**
     * Gets if the thread is a daemon thread
     *
     * @return if the thread is a daemon thread
     */
    boolean isDaemon();

    /**
     * Sets whether the thread is a daemon thread or not
     *
     * @param daemon the thread's new daemon status
     */
    void setDaemon(boolean daemon);

}
