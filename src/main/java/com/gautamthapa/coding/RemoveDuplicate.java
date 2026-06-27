package com.gautamthapa.coding;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicate {
    static void main() {
        int[] inputArr = {2, 4, 6, 4, 2, 6};

        // Via Normal
        removeDuplicatesNormal(inputArr);

        // Via Collection
        removeDuplicatesCollection(inputArr);

        // Via Stream
        List<Integer> uniques = removeDuplicates(inputArr);
        System.out.println("uniques : " + uniques);
    }

    private static void removeDuplicatesCollection(int[] inputArr) {
        System.out.println("removeDuplicatesCollection **");
        Set<Integer> result=new HashSet<>();
        for (int num: inputArr){
            result.add(num);
        }
        result.forEach(System.out::println);
    }

    private static void removeDuplicatesNormal(int[] inputArr) {
        System.out.println("removeDuplicatesNormal **");
        int[] result = new int[inputArr.length];
        int index = 0;
        for (int i = 0; i < inputArr.length; i++) {

            boolean duplicate = false;
            for (int j = 0; j < i; j++) {
                if (inputArr[i] == inputArr[j]) {
                    duplicate = true;
                    break;
                }
            }

            if (!duplicate) {
                result[index++] = inputArr[i];
            }
        }

        for (int i = 0; i < index; i++) {
            System.out.println(result[i]);
        }
    }

    private static List<Integer> removeDuplicates(int[] inputArr) {
        System.out.println("removeDuplicates Stream");
        return Arrays.stream(inputArr).boxed().distinct().collect(Collectors.toList());
    }
}
