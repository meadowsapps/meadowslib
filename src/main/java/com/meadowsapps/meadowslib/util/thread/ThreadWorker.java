package com.meadowsapps.meadowslib.util.thread;

import com.meadowsapps.meadowslib.util.Logger;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by dmeadows on 9/12/16.
 */
public class ThreadWorker extends AbstractContinuousThread {

    /**
     * The worker's queue of executables to execute
     */
    private BlockingQueue<Executable> executables;

    /**
     * Creates a new ThreadWorker instance
     */
    public ThreadWorker() {
        executables = new LinkedBlockingQueue<Executable>();
    }

    /**
     * Defines the ThreadWorker's behavior
     */
    @Override
    public void execute() {
        try {
            Executable executable = executables.take();
            executable.execute();
        } catch (InterruptedException e) {
            Logger.getLogger().warn(e);
        }
    }

    /**
     * Submits a new executable for the worker to execute
     *
     * @param executable a task for the worker to execute
     */
    public void submit(Executable executable) {
        executables.offer(executable);
    }

}
