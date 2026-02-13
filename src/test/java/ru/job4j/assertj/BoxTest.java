package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 6);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Tetrahedron");
    }

    @Test
    void isThisSphereHasZeroVertex() {
        Box box = new Box(0, 10);
        int vertex = box.getNumberOfVertices();
        assertThat(vertex).isZero();
    }

    @Test
    void isThisTetrahedronHasFourVertices() {
        Box box = new Box(4, 6);
        int vertices = box.getNumberOfVertices();
        assertThat(vertices).isEqualTo(4);
    }

    @Test
    void isThisUnknownExist() {
        Box box = new Box(3, 8);
        boolean exist = box.isExist();
        assertThat(exist).isFalse();
    }

    @Test
    void isThisCubeExist() {
        Box box = new Box(8, 12);
        boolean exist = box.isExist();
        assertThat(exist).isTrue();
    }

    @Test
    void isThisCubeAreaEqual_6() {
        Box box = new Box(8, 1);
        double area = box.getArea();
        assertThat(area).isEqualTo(6);
    }

    @Test
    void isThisSphereAreaEqual_4piR2() {
        Box box = new Box(0, 1);
        double area = box.getArea();
        assertThat(area).isEqualTo(4 * Math.PI);
    }
}