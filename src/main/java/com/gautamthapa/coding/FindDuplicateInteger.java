package com.gautamthapa.coding;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicateInteger {
    static void main() {
        int[] inputArr = {2, 4, 6, 4, 2, 6};

        // Via Normal
        findDuplicateIntegerViaNormal(inputArr);
        findDuplicateIntegerViaNormal2(inputArr);

        // Via HashMap
        findDuplicateIntegerViaMap(inputArr);

        // Via Stream
        List<Integer> duplicates = findDuplicateInteger(inputArr);

        // Via Stream
        List<Integer> duplicateNums = findDuplicateIntegerStreamAnotherWay(inputArr);

        System.out.println("duplicates : " + duplicateNums);
    }

    private static List<Integer> findDuplicateIntegerStreamAnotherWay(int[] duplicates) {
        return Arrays.stream(duplicates).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(key -> key.getValue() > 1)
                .map(n -> n.getKey())
                .collect(Collectors.toList());
    }

    private static void findDuplicateIntegerViaNormal2(int[] inputArr) {
        Arrays.sort(inputArr);

        for (int i = 1; i < inputArr.length; i++) {
            if (inputArr[i] == inputArr[i - 1]) {
                System.out.println("Duplicate : " + inputArr[i]);
            }
        }

    }

    private static void findDuplicateIntegerViaNormal(int[] inputArr) {
        int[] outputArr = new int[inputArr.length];
        for (int i = 0; i < inputArr.length; i++) {
            for (int j = i + 1; j < inputArr.length; j++) {
                if (inputArr[i] == inputArr[j]) {
                    outputArr[i] = inputArr[i];
                    break;
                }
            }
        }
        Arrays.stream(outputArr).forEach(System.out::println);
    }

    private static void findDuplicateIntegerViaMap(int[] inputArr) {
        Map<Integer, Integer> integerCount = new HashMap<>();

        for (int j : inputArr) {
            integerCount.put(j, integerCount.getOrDefault(j, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for (Integer key : integerCount.keySet()) {
            if (integerCount.get(key) > 1) {
                result.add(key);
            }
        }

        System.out.println("integerCount : " + result);
    }

    private static List<Integer> findDuplicateInteger(int[] inputArr) {
        if (inputArr == null || inputArr.length == 0)
            throw new IllegalArgumentException("Array must have at least 1 element");

        Set<Integer> seenInputs = new HashSet<>();
        return Arrays.stream(inputArr)
                .filter(value -> !seenInputs.add(value))
                .mapToObj(value -> (Integer) value)
                .toList();
    }
}
