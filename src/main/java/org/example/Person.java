package org.example;

import lombok.*;
import lombok.experimental.Accessors;

@Setter @Getter
@Accessors(fluent = true)
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private int age;
    private @NonNull String name;
}
