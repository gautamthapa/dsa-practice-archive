package com.gautamthapa.javapractice.array;

public class SortingNumber {
    public static void main(String[] args) {
        int[] array = {5, 2, 4, 0, 1, 3};
        sortWithoutSortMethodASC(array);
        sortWithoutSortMethodDESC(array);
    }

    private static void sortWithoutSortMethodDESC(int[] array) {
        int tem = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    tem = array[i];
                    array[i] = array[j];
                    array[j] = tem;
                }
            }
        }
        System.out.println("Sorting DESC without sort method");
        for (int i : array) {
            System.out.println(i);
        }
    }

    private static void sortWithoutSortMethodASC(int[] array) {
        int tem = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    tem = array[i];
                    array[i] = array[j];
                    array[j] = tem;
                }
            }
        }
        System.out.println("Sorting ASC without sort method");
        for (int i : array) {
            System.out.println(i);
        }
    }
}
