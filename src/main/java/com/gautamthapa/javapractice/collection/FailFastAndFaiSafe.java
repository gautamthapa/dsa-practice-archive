package com.gautamthapa.javapractice.collection;

import com.gautamthapa.util.Employee;
import com.gautamthapa.util.Util;

import java.util.ArrayList;
import java.util.List;

public class FailFastAndFaiSafe {
    static void main() {
        List<Employee> employees= new ArrayList<>(Util.getEmployees());
        for (Employee e: employees){
            employees.add(e);
        }

    }
}
