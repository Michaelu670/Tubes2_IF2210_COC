package org.example;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;
import lombok.experimental.Accessors;
import org.app.DataStore.DataHolder;

@Setter @Getter
@Accessors(fluent = true)
@ToString
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Person extends DataHolder {
    private int age;
    private @NonNull String name;


}
