package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> input = new SimpleStack<>();
    private final SimpleStack<T> output = new SimpleStack<>();
    int inputSize = 0;
    int outputSize = 0;

    public T poll() {
        if (inputSize == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        for (int i = 0; i < inputSize; i++) {
            output.push(input.pop());
        }
        outputSize = --inputSize;
        return output.pop();
    }

    public void push(T value) {
        for (int i = 0; i < outputSize; i++) {
            input.push(output.pop());
        }
        input.push(value);
        inputSize++;
    }
}