package com.tdiprima.polymorph;

/**
 * Represents a Developer who writes code.
 */
public class Developer extends Employee {

    public Developer(String name, int id) {
        super(name, id);
    }

    @Override
    public void work() {
        System.out.println(getName() + " is writing and debugging code.");
    }
}
