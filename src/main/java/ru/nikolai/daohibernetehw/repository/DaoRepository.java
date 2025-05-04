package ru.nikolai.daohibernetehw.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.nikolai.daohibernetehw.entity.Person;

import java.util.List;

@Repository
public class DaoRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Person> getPersonsByCity(String city) {
        return em.createQuery("SELECT p FROM Person p WHERE p.city_of_living = :city", Person.class)
                .setParameter("city", city)
                .getResultList();
    }
}
