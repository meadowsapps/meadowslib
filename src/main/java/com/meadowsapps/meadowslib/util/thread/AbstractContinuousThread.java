package com.meadowsapps.meadowslib.util.thread;

/**
 * Created by dmeadows on 9/12/16.
 */
public abstract class AbstractContinuousThread implements ContinuousThreadI {

    /**
     * Boolean flag that controls whether the delegate is
     * running or not
     */
    private boolean running;

    /**
     * The thread delegate for the AbstractContinuousThread class
     */
    private java.lang.Thread delegate;

    /**
     * Creates a new AbstractContinuousThread instance
     */
    public AbstractContinuousThread() {
        init();
    }

    /**
     * Initializes the
     */
    private void init() {
        delegate = new java.lang.Thread() {
            @Override
            public void run() {
                AbstractContinuousThread.this.run();
            }
        };
        running = false;
    }

    /**
     * Starts the thread
     */
    @Override
    public void start() {
        if (!isRunning()) {
            running = true;
            delegate.start();
        }
    }

    /**
     * Stops the thread
     */
    @Override
    public void stop() {
        if (isRunning()) {
            running = false;
        }
    }

    /**
     * Defines the thread's behavior
     */
    private void run() {
        while (isRunning()) {
            execute();
        }
    }

    /**
     * Gets if the thread is running
     *
     * @return if the thread is running
     */
    @Override
    public boolean isRunning() {
        return running;
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
