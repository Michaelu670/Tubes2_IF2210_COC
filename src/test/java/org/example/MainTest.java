package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void methodTwoShouldReturnAnIntegerEqualsTwo() {
        Assertions.assertTrue(Main.two() == 2);
    }
}
