package com.meadowsapps.meadowslib.util.thread;

/**
 * Created by dmeadows on 9/12/16.
 */
public abstract class AbstractThread implements ThreadI {

    /**
     * The thread delegate for the AbstractContinuousThread class
     */
    private Thread delegate;

    /**
     * Creates a new AbstractContinuousThread instance
     */
    public AbstractThread() {
        init();
    }

    /**
     * Initializes the
     */
    private void init() {
        delegate = new Thread() {
            @Override
            public void run() {
                AbstractThread.this.execute();
            }
        };
    }

    /**
     * Starts the thread
     */
    @Override
    public void start() {
        delegate.start();
    }

    /**
     * Gets the name of the thread
     *
     * @return the thread's name
     */
    @Override
    public String getName() {
        return delegate.getName();
    }

    /**
     * Sets the name of the thread
     *
     * @param name the thread's new name
     */
    @Override
    public void setName(String name) {
        delegate.setName(name);
    }

    /**
     * Gets the priority of the thread
     *
     * @return the thread's priority
     */
    @Override
    public int getPriority() {
        return delegate.getPriority();
    }

    /**
     * Sets the priority of the thread
     *
     * @param priority the thread's new priority
     */
    @Override
    public void setPriority(int priority) {
        delegate.setPriority(priority);
    }

    /**
     * Gets if the thread is a daemon thread
     *
     * @return if the thread is a daemon thread
     */
    @Override
    public boolean isDaemon() {
        return delegate.isDaemon();
    }

    /**
     * Sets whether the thread is a daemon thread or not
     *
     * @param daemon the thread's new daemon status
     */
    @Override
    public void setDaemon(boolean daemon) {
        delegate.setDaemon(daemon);
    }
}
