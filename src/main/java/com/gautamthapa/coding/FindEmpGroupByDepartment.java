package com.gautamthapa.coding;

import com.gautamthapa.util.Employee;
import com.gautamthapa.util.Util;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindEmpGroupByDepartment {
    static void main() {
        List<Employee> employees = Util.getEmployees();

        // Emp Group by dept
        Map<String, List<Employee>> empByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println("Emp Group by dept : " + empByDept);

        // Emp Count by dept
        Map<String, Long> empCountByDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println("Emp Count by dept : " + empCountByDept);

        // Group By Department
        List<String> depts = employees.stream()
                .map(Employee::getDepartment)
                .distinct().toList();
        System.out.println("Dept : " + depts);

        // Get Employees Descending Salary
        List<Employee> employeesSalariesDesc = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed()).toList();
        System.out.println("employeesSalariesDesc : " + employeesSalariesDesc);

        // Get Employee Max Salary
        Employee employeeMaxSalary = employees.stream()
                .max(Comparator.comparing(Employee::getSalary)).orElse(null);
        System.out.println("employeeMaxSalary : " + employeeMaxSalary);

        // Get Second Largest Salary
        Employee employeeSecondLargestSalary = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .skip(1)
                .findFirst().orElse(null);
        System.out.println("employeeSecondLargestSalary : " + employeeSecondLargestSalary);


        // Employee with highest salary in each depart
        Map<String, Employee> highestSalary = employees.stream()
                .collect(Collectors.toMap(Employee::getDepartment, Function.identity(), BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary))));
        System.out.println("highestSalary : " + highestSalary);
    }
}
