package com.company.polymorph;

/**
 * Represents a Designer who creates visuals.
 */
public class Designer extends Employee {

    public Designer(String name, int id) {
        super(name, id);
    }

    @Override
    public void work() {
        System.out.println(getName() + " is designing user interfaces and graphics.");
    }
}
