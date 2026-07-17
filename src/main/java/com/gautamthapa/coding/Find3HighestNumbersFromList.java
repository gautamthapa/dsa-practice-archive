package com.gautamthapa.coding;

import java.util.Comparator;
import java.util.List;

public class Find3HighestNumbersFromList {
    static void main() {
        List<Integer> inputs = List.of(4, 6, 3, 1, 6, 8, 9);

        // Method 1
        List<Integer> results = inputs.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .toList();

        System.out.println(results);


        // Method 2
        results = inputs.stream().sorted((o1, o2) -> o2-o1).limit(3).toList();

        System.out.println(results);
    }
}
