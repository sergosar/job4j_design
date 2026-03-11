package ru.job4j.sort;

import java.util.Arrays;

public class Merge {

    public static int[] mergesort(int[] array) {
        int[] result = array;
        int n = array.length;
        if (n > 1) {
            int[] left = mergesort(Arrays.copyOfRange(array, 0, n / 2));
            int[] right = mergesort(Arrays.copyOfRange(array, n / 2, n));
            result = merge(left, right);
        }
        return result;
    }

    private static int[] merge(int[] left, int[] right) {
        int indexLeft = 0;
        int indexRight = 0;
        int[] result = new int[left.length + right.length];
        for (int i = 0; i < result.length; i++) {
            if (indexLeft == left.length) {
                System.arraycopy(right, indexRight, result, i, right.length - indexRight);
                break;
            }
            if (indexRight == right.length) {
                System.arraycopy(left, indexLeft, result, i, left.length - indexLeft);
                break;
            }
            if (left[indexLeft] < right[indexRight]) {
                result[i] = left[indexLeft++];
            } else {
                result[i] = right[indexRight++];
            }
        }
        return result;
    }
}