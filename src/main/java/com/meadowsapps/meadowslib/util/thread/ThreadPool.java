package com.meadowsapps.meadowslib.util.thread;

import com.meadowsapps.meadowslib.util.Logger;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by dmeadows on 9/9/16.
 */
public class ThreadPool {

    /**
     * The queue of Executable objects to execute
     */
    private BlockingQueue<Executable> queue;

    /**
     * An array of workers to execute Executables as they are
     * submitted to the queue
     */
    private ThreadPoolWorker[] workers;

    /**
     * Creates a new ThreadPool instance with the specified size
     *
     * @param size the number of Threads to create
     */
    public ThreadPool(int size) {
        if (size > 0) {
            queue = new LinkedBlockingQueue<Executable>();
            workers = new ThreadPoolWorker[size];
            for (int i = 0; i < size; i++) {
                workers[i] = new ThreadPoolWorker();
            }
        } else {
            IllegalArgumentException e = new IllegalArgumentException("Size must be greater than 0");
            throw new RuntimeException(e);
        }
    }

    /**
     * Starts all of the thread workers
     */
    public void start() {
        for (ThreadPoolWorker worker : workers) {
            worker.start();
        }
    }

    /**
     * Stops all of the thread workers
     */
    public void stop() {
        for (ThreadPoolWorker worker : workers) {
            worker.stop();
        }
    }

    /**
     * Submits the Executable instance to the queue to be executed
     * by the threads
     *
     * @param executable a task for the workers to execute
     */
    public void submit(Executable executable) {
        queue.offer(executable);
    }

    /**
     * Retrieves and removes an Executable from the head of the queue.
     * This method will wait until the head is not null or until it is
     * interrupted
     *
     * @return the head of the queue
     * @throws InterruptedException if this method is interrupted while waiting for an Executable
     */
    private Executable retrieve() throws InterruptedException {
        return queue.take();
    }

    /**
     * Thread worker implementation that executes tasks as it receives them
     * while running continuously
     */
    class ThreadPoolWorker extends AbstractContinuousThread {
        /**
         * Defines the ThreadPoolWorker's behavior
         */
        @Override
        public void execute() {
            try {
                Executable executable = retrieve();
                executable.execute();
            } catch (InterruptedException e) {
                Logger.getLogger().warn(e);
            }
        }
    }

}
