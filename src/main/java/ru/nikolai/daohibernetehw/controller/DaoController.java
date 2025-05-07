package ru.nikolai.daohibernetehw.controller;

import com.fasterxml.jackson.core.PrettyPrinter;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.nikolai.daohibernetehw.entity.Person;
import ru.nikolai.daohibernetehw.repository.DaoRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class DaoController {
    private final DaoRepository daorepository;

    public DaoController(DaoRepository daorepository) {
        this.daorepository = daorepository;
    }
    @GetMapping("/persons/by-city")
    public List<Person> personsByCity(@RequestParam("city") String city) {
        return daorepository.findByCity(city);
    }

    @GetMapping("/persons/by-age")
    public List<Person> personsByAge(@RequestParam("age") Integer age) {
        return daorepository.findByAge(age);
    }

    @GetMapping("/persons/by-name-surname")
    public Optional<Person> personsByNameSurname(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return daorepository.findByNameAndSurname(name, surname);
    }


}
