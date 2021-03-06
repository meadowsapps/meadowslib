package com.meadowsapps.meadowslib.util.thread;

/**
 * Created by Dylan on 9/13/16.
 */
public class ContinuousThread extends AbstractContinuousThread {

    private Executable executable;

    public ContinuousThread(Executable executable) {
        this.executable = executable;
    }

    @Override
    public void execute() {
        if (executable != null) {
            executable.execute();
        }
    }

}
