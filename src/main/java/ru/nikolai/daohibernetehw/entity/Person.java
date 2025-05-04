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
    @Id
    @Column(nullable = false, length = 1023)
    private String surname;
    @Id
    @Column(nullable = false)
    private int age;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private City cityOfLiving;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
