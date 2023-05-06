package org.app.Setting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SettingTest {
    @Test
    void get_instance_is_singleton() {
        Setting s1 = Setting.getInstance();
        Setting s2 = Setting.getInstance();

        Assertions.assertEquals(s1, s2);
    }
}
