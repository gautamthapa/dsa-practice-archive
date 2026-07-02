package com.gautamthapa.javapractice.array;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveDuplicateNumber {

    public static void main(String[] args) {
        int[] a = {2, 3, 1, 2, 3, 5, 6};
        int length = a.length;
        removeDuplicateWithoutCollection(a, length);
        removeDuplicateWithCollection(a);
    }

    private static void removeDuplicateWithCollection(int[] a) {
        System.out.println("***removeDuplicateWithCollection***");
        List<Integer> integerList1 = Arrays.stream(a).boxed().collect(Collectors.toList());
        LinkedHashSet<Integer> s=new LinkedHashSet<>(integerList1);
        s.forEach(System.out::println);
    }

    private static void removeDuplicateWithoutCollection(int[] a, int length) {
        System.out.println("***removeDuplicateWithoutCollection***");
        Arrays.sort(a);
        int index = 0;
        for (int i = 0; i < length - 1; i++) {
            if (a[i] != a[i + 1]) {
                a[index++] = a[i];
            }
        }
        a[index++] = a[length - 1];
        for (int i = 0; i < index; i++) {
            System.out.println(a[i]);
        }
    }
}
