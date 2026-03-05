package ru.job4j.algo.hash;


import java.util.HashMap;
import java.util.Map;

public class LongestUniqueSubstring {
    public static String longestUniqueSubstring(String str) {
        int left = 0;
        int maxLeft = 0;
        int maxRight = 0;
        Map<Character, Integer> count = new HashMap<>();
        for (int right = 0; right < str.length(); right++) {
            char c = str.charAt(right);
            count.put(c, count.getOrDefault(c, 0) + 1);
            while (count.get(c) > 1) {
                char leftChar = str.charAt(left);
                count.put(leftChar, count.get(leftChar) - 1);
                left++;
            }
            if (right - left > maxRight - maxLeft) {
                maxLeft = left;
                maxRight = right;
            }
        }
        int actualEnd = Math.min(maxRight + 1, str.length());
        return str.substring(maxLeft, actualEnd);
    }
}