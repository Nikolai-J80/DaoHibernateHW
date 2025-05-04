package ru.nikolai.daohibernetehw.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.nikolai.daohibernetehw.repository.DaoRepository;

@RestController
public class DaoController {
    private final DaoRepository daorepository;

    public DaoController(DaoRepository daorepository) {
        this.daorepository = daorepository;
    }

    @GetMapping("/persons/by-city")
    public String getPersonsByCity(@RequestParam String city) {
        return daorepository.getPersonsByCity(city).toString();
    }
}
