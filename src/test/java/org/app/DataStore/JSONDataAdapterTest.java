package org.app.DataStore;

import org.example.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JSONDataAdapterTest {
    @Test
    void json_adapter_is_consistent() {
        Person budi = new Person().age(20).name("Budi");
        JSONDataAdapter p = new JSONDataAdapter(budi);
        Assertions.assertDoesNotThrow( () -> {
            p.saveData("testFile.json");
            budi.name("bukan Budi");
            budi.age(100);
            p.loadData("testFile.json");
        });

        Assertions.assertTrue(budi.name().equals("Budi"));
        Assertions.assertTrue(budi.age() == 20);

    }
}
