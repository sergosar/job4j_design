package ru.job4j.algo;

import java.util.Arrays;

public class SmallestRangeFinder {
    public static int[] findSmallestRange(int[] nums, int k) {
        int length = k;
        while (length <= nums.length - 1) {
            int left = 0;
            int right = length - 1;
            while (right <= nums.length - 1) {
                boolean flag = true;
                for (int i = left; i < right; i++) {
                    if (nums[i] == nums[i + 1]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return new int[]{left, right};
                }
                left++;
                right++;
            }
            length++;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9};
        int k = 3;
        int[] result = findSmallestRange(nums, k);
        if (result != null) {
            System.out.println("Наименьший диапазон с " + k + " различными элементами: " + Arrays.toString(result));
        } else {
            System.out.println("Такой диапазон не существует.");
        }
    }
}