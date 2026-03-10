package ru.job4j.algo;

import java.util.*;

public class IntervalMerger {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> result = new ArrayList<>();
        Iterator<int[]> it = Arrays.asList(intervals).iterator();
        int[] current = it.next();
        while (it.hasNext()) {
            int[] next = it.next();
            if (current[1] >= next[0]) {
                current[1] = Math.max(current[1], next[1]);
            } else {
                result.add(current);
                current = next;
            }
        }
        result.add(current);
        return result.toArray(new int[result.size()][]);
    }
}