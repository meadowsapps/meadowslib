package com.meadowsapps.meadowslib.util.thread;

/**
 * Created by dmeadows on 9/12/16.
 */
public interface ContinuousThreadI extends ThreadI {

    /**
     * Stops the thread
     */
    void stop();

    /**
     * Gets if the thread is running
     *
     * @return if the thread is running
     */
    boolean isRunning();
}
