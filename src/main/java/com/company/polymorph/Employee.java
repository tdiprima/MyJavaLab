package com.company.polymorph;

/**
 * Abstract base class representing a generic Employee.
 */
public abstract class Employee {

    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    // Abstract method to be implemented by subclasses
    public abstract void work();

    @Override
    public String toString() {
        return "Employee ID: " + id + ", Name: " + name;
    }
}
