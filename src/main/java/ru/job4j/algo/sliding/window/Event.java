package ru.job4j.algo.sliding.window;

public class Event {
    int coord;
    EventType type;

    enum EventType {
        START(1),
        END(-1);
        private final int value;

        EventType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public Event(int coord, EventType type) {
        this.coord = coord;
        this.type = type;
    }
}
