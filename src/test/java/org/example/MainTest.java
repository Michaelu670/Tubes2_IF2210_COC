package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void method_two_should_return_an_integer_equals_two() {
        Assertions.assertTrue(Main.two() == 2);
    }
}
