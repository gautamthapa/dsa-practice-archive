package com.gautamthapa.coding;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MovingZeroRightSide {
    static void main() {
        List<Integer> numbers = List.of(1, 0, -3, 0, 5, -2, 0, 8, 0, -4);
        List<Integer> output = Stream.concat(numbers.stream().filter(num -> num != 0), numbers.stream().filter(num -> num == 0))
                .collect(Collectors.toList());
        System.out.println("output : " + output);
    }
}
