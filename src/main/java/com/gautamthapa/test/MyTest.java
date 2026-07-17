package com.gautamthapa.test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MyTest {
    static void main() {
//        String input="java eight stream api";
//        String str1 = Arrays.stream(input.split(" "))
//                .map(str-> String.valueOf(str.charAt(0)).toUpperCase()+str.substring(1,str.length()))
//                .collect(Collectors.joining(" "));
//
//        System.out.println(str1);


        String input1 = "ttssaabbcddeff";

        Map<Character, Long> map = input1.chars()
                .mapToObj(value -> (char) value)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        Character chr = input1.chars()
                .mapToObj(value -> (char) value)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream().filter(characterLongEntry -> characterLongEntry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst().orElse(null);

        System.out.println("chr: " + chr);

        for (Character ch : map.keySet()) {
            if (map.get(ch) == 1) {
                System.out.println("First non repeating character " + ch);
                break;
            }
        }
    }
}
