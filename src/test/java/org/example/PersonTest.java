package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonTest {

    @Test
    void fluent_getter_test() {
        Person p = new Person().age(10);
        assertTrue(p.age() == 10);
    }
}
