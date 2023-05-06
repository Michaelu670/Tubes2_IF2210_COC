package org.app.DataStore;

import org.example.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OBJDataAdapterTest {
    @Test
    void obj_adapter_is_consistent() {
        Person budi = new Person().age(20).name("Budi");
        DataAdapter p = new OBJDataAdapter(budi);
        Assertions.assertDoesNotThrow( () -> {
            p.getData("testFile.obj");
            budi.name("bukan Budi");
            budi.age(100);
            p.setData("testFile.obj");
        });

        Assertions.assertTrue(budi.name().equals("Budi"));
        Assertions.assertTrue(budi.age() == 20);
    }
}
