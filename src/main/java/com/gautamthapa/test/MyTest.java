package com.gautamthapa.test;

import java.util.*;
import java.util.stream.Collectors;

public class MyTest {
    static void main() {
        String input="java eight stream api";
        String str1 = Arrays.stream(input.split(" "))
                .map(str-> String.valueOf(str.charAt(0)).toUpperCase()+str.substring(1,str.length()))
                .collect(Collectors.joining(" "));

        System.out.println(str1);
    }
}
