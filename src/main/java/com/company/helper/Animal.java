package com.company.helper;

/**
 * Created by tdiprima on 7/10/17.
 */
public abstract class Animal {
    public void eat() {
        // do something with food....
    }

    public void sleep(int hours) {
        try {
            // 1000 milliseconds * 60 seconds * 60 minutes * hours
            Thread.sleep(1000 * 60 * 60 * hours);
        } catch (InterruptedException ie) { /* ignore */ }
    }

    public abstract void makeNoise();
}
