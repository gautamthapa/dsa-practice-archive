package com.gautamthapa.util;

import java.util.List;

public class Util {
    public static List<Employee> getEmployees() {
        return List.of(
                new Employee(1L, "John", "Doe", 50000.0, "IT", "Developer"),
                new Employee(2L, "Jane", "Smith", 60000.0, "HR", "Manager"),
                new Employee(3L, "Alice", "Johnson", 55000.0, "IT", "Developer"),
                new Employee(4L, "Bob", "Brown", 45000.0, "Finance", "Analyst"),
                new Employee(5L, "Charlie", "Davis", 70000.0, "IT", "Team Lead")
        );
    }


}
