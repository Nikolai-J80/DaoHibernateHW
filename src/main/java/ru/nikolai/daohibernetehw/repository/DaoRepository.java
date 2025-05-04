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

    public List<String> getPersonsByCity(String city) {
        List<String> str = em.createNativeQuery("SELECT p.* \n" +
                        "FROM Person p\n" +
                        "RIGHT JOIN City c ON p.city_of_living_id = c.id\n" +
                        "WHERE c.name = :city", Person.class)
                .setParameter("city", city)
                .getResultList();
        return str;
    }

}
