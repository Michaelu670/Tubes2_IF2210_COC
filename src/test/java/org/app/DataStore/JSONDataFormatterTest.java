package org.app.DataStore;

import org.example.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JSONDataFormatterTest {
    @Test
    public void json_string_format_valid() {
        DataFormatter p = new JSONDataFormatter(Person.class);
        try {
            String ret = p.toSaveFormat(new Person().age(20).name("Budi"));
        }
        catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void json_format_consistent() {
        DataFormatter<Person> p = new JSONDataFormatter(Person.class);
        try {
            String ret = p.toSaveFormat(new Person().age(20).name("Budi"));
            Person person = p.toObject(ret);
            Assertions.assertTrue(person.age() == 20);
            Assertions.assertTrue(person.name().equals("Budi"));
        }
        catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }

}
