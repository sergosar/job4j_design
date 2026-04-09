package ru.job4j.algo.sliding.window;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static int[] findMaxOverlapInterval(List<Interval> intervals) {
        if (intervals.isEmpty()) {
            return new int[]{-1, -1};
        }
        List<Event> events;

        int maxOverlap = 0;
        int maxStart = -1;
        int maxEnd = -1;

        events = intervals.stream().
                flatMap(interval -> Stream.of(new Event(interval.start, Event.EventType.START), new Event(interval.end, Event.EventType.END))).
                collect(Collectors.toList());
        events.sort((a, b) -> {
            if (a.coord != b.coord) {
                return Integer.compare(a.coord, b.coord);
            }
            return Integer.compare(
                    b.type.getValue(),
                    a.type.getValue()
            );
        });

        for (Event event : events) {

        }

        return new int[]{
                maxStart, maxEnd
        };
    }


    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 4));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(3, 5));
        intervals.add(new Interval(7, 8));

        int[] result = findMaxOverlapInterval(intervals);

        System.out.println("Interval that overlaps the maximum number of intervals: [" + result[0] + ", " + result[1] + "]");
    }
}