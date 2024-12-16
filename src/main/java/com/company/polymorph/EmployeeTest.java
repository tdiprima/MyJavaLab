package com.company.polymorph;

import java.util.ArrayList;
import java.util.List;

public class EmployeeTest {

    public static void main(String[] args) {
        // List to hold employees
        List<Employee> employees = new ArrayList<>();

        // Polymorphic behavior: all are treated as Employee
        employees.add(new Manager("Alice", 101));
        employees.add(new Developer("Bob", 102));
        employees.add(new Designer("Charlie", 103));

        // Iterate and invoke work() method
        for (Employee employee : employees) {
            System.out.println(employee);
            employee.work();
            System.out.println();
        }
    }
}
