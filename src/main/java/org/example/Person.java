package org.example;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;
import lombok.experimental.Accessors;
import org.app.Inventory.Loadable;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

@Setter @Getter
@Accessors(fluent = true)
@ToString
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Person implements Loadable {
    private int age;
    private @NonNull String name;

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
