package com.tdiprima.polymorph;

/**
 * Represents a Manager who delegates tasks.
 */
public class Manager extends Employee {

    public Manager(String name, int id) {
        super(name, id);
    }

    @Override
    public void work() {
        System.out.println(getName() + " is holding meetings and delegating tasks.");
    }
}
