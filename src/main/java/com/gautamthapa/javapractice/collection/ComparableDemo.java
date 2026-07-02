package com.gautamthapa.javapractice.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Employee implements Comparable<Employee>{
    private String name;
    private double salary;

    public Employee() {
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee employee) {
        if (this.salary < employee.salary){
            return -1;
        }else if(this.salary > employee.salary){
            return +1;
        }else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class ComparableDemo {
    public static void main(String[] args) {
        List<Employee> list=new ArrayList<>();
        list.add(new Employee("Gautam", 50000));
        list.add(new Employee("Sanjeev", 45000));
        list.add(new Employee("Depti", 40000));
        list.add(new Employee("Gaurav", 100000));

        Collections.sort(list);
        list.stream().forEach(System.out::println);
    }
}
