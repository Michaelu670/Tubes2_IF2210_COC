package org.app.DataStore;

import org.example.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class XMLDataAdapterTest {
    @Test
    void xml_adapter_is_consistent() {
        Person budi = new Person().age(20).name("Budi");
        DataAdapter p = new XMLDataAdapter(budi);
        Assertions.assertDoesNotThrow( () -> {
            p.saveData("testFile.xml");
            budi.name("bukan Budi");
            budi.age(100);
            p.loadData("testFile.xml");
        });

        Assertions.assertTrue(budi.name().equals("Budi"));
        Assertions.assertTrue(budi.age() == 20);
    }
}
