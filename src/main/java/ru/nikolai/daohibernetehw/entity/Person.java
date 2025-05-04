package ru.nikolai.daohibernetehw.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
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

    @Column(nullable = false)
    private String city_of_living;

}
