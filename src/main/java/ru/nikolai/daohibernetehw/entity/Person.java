package ru.nikolai.daohibernetehw.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@IdClass(CompositeKey.class)
public class Person {
    @Id
    @Column(nullable = false, length = 1023)
    private String name;

    @Column(nullable = false, length = 1023)
    private String surname;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String phone_number;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private City city_of_living;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
