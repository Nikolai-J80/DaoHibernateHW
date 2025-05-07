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

    @Id
    @Column(nullable = false, length = 1023)
    private String surname;

    @Id
    @Column(nullable = false)
    private int age;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "city_of_living", nullable = false)
    private String cityOfLiving;

}
