package org.app.Inventory;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class DataHolder implements Loadable{
    @Override
    public void setData(Loadable data) throws Exception {
        assert(data.getClass() == this.getClass());
        for (Field field: this.getClass().getDeclaredFields()) {
            if (Modifier.isFinal(field.getModifiers()) || Modifier.isStatic(field.getModifiers())) {
                continue;
            }
            field.setAccessible(true);
            field.set(this, field.get(data));
        }
    }
}
