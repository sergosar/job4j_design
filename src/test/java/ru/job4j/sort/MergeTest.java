package ru.job4j.sort;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MergeTest {

    @Test
    void whenSortedThenOk() {
        int[] array = {10, 4, 6, 4, 8, -13, 2, 3};
        assertThat(Merge.mergesort(array)).containsExactly(-13, 2, 3, 4, 4, 6, 8, 10);
    }

    @Test
    void whenOneElementThenOk() {
        int[] array = {1};
        assertThat(Merge.mergesort(array)).containsExactly(1);
    }

    @Test
    void whenNoElementsThenOk() {
        int[] array = {};
        assertThat(Merge.mergesort(array)).containsExactly();
    }

    @Test
    void whenContainSeveralEqualElementsThenOk() {
        int[] array = {10, 4, 6, 6, 4, -13, 8, -13, 2, 3, -13};
        assertThat(Merge.mergesort(array)).containsExactly(-13, -13, -13, 2, 3, 4, 4, 6, 6, 8, 10);
    }
}