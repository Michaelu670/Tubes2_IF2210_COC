package org.app.DataStore;

import org.example.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class XMLDataFormatterTest {
    @Test
    public void xml_is_valid() {
        DataFormatter<Person> formatter = new XMLDataFormatter(Person.class);
        Assertions.assertDoesNotThrow(
                () -> {
                    String s = formatter.toSaveFormat(new Person().age(21).name("Budi"));
                }
        );
    }

}
