package org.app.DataStore;

import org.app.Setting.Setting;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DataStoreTest {
    @Test
    void setting_save_and_load_test() {
        DataStore store = new DataStore();
        Setting.getInstance().setStoragePath("dataStore");
        store.save();
        Setting.getInstance().setStoragePath("");
        store.loadSettings();
        Assertions.assertEquals(Setting.getInstance().getStoragePath(), "dataStore");
    }

    @Test
    void data_store_as_data_initializer() {
        DataStore store = new DataStore();
        store.load();
        Assertions.assertNotNull(store.inventory());
        store.save();
    }
}
