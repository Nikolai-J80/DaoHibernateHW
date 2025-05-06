package ru.nikolai.daohibernetehw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nikolai.daohibernetehw.entity.Person;

import java.util.List;
import java.util.Optional;


@Repository
public interface DaoRepository extends JpaRepository<Person, Long> {

    List<Person> findByCityOfLiving(String city);

    List<Person> findByAgeLessThanOrderByAgeAsc(Integer age);

    Optional<Person> findByNameAndSurname(String name, String surname);

}
