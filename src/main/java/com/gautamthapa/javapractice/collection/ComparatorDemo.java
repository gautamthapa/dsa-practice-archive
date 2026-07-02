package com.gautamthapa.javapractice.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class MyEmployee implements Comparable<MyEmployee> {
    private String name;
    private double salary;

    public MyEmployee() {
    }

    public MyEmployee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int compareTo(MyEmployee employee) {
        if (this.salary < employee.salary) {
            return -1;
        } else if (this.salary > employee.salary) {
            return +1;
        } else {
            return 0;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

class EmployeeSalaryCompare implements Comparator<MyEmployee> {

    @Override
    public int compare(MyEmployee emp1, MyEmployee emp2) {
        if (emp1.getSalary() < emp1.getSalary()) {
            return -1;
        } else if (emp1.getSalary() > emp2.getSalary()) {
            return 1;
        } else {
            return 0;
        }
    }
}
class EmployeeNameCompare implements Comparator<MyEmployee> {

    @Override
    public int compare(MyEmployee emp1, MyEmployee emp2) {
        return emp1.getName().compareTo(emp2.getName());
    }
}


public class ComparatorDemo {
    public static void main(String[] args) {
        List<MyEmployee> list=new ArrayList<>();
        list.add(new MyEmployee("Gautam", 50000));
        list.add(new MyEmployee("Sanjeev", 45000));
        list.add(new MyEmployee("Depti", 40000));
        list.add(new MyEmployee("Gaurav", 100000));

        Collections.sort(list, new EmployeeSalaryCompare());
        System.out.println("Sorting by salary");
        list.stream().forEach(employee -> System.out.println(employee));

        Collections.sort(list, new EmployeeNameCompare());
        System.out.println("Sorting by name");
        list.stream().forEach(employee -> System.out.println(employee));
    }
}
