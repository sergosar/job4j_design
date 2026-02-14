package ru.job4j.assertj;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameLoadTest {
    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void checkParseEmpty() {
        NameLoad nameLoad = new NameLoad();
        String[] names = new String[0];

        assertThatThrownBy(()->nameLoad.parse(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Names array is empty");
    }

    void checkValidateNamesContains() {
        NameLoad nameLoad = new NameLoad();
        String[] names = {"a=b","c:d"};

        assertThatThrownBy(()->nameLoad.parse(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Names array is empty");
    }

}