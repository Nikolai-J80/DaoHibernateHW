package ru.nikolai.daohibernetehw.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class DaoController {
    @PostAuthorize("hasAnyRole('WRITE')")
    @GetMapping("/hello")
    public String hello(){return "Hello";}

    @GetMapping("/hi")
    public String hi(){return "Hi get";}

    @Secured("ROLE_READ")
    @GetMapping("/read")
    public String read() {
        return "read";
    }

    @Secured("ROLE_WRITE")
    @PostMapping("/write")
    public String write() {
        return "write";
    }

    @PreAuthorize("hasAnyRole('ROLE_DELETE', 'ROLE_WRITE')")
    @DeleteMapping("/delete")
    public String delete() {
        return "delete";
    }

    @PostAuthorize("#username == authentication.principal.username")
    @GetMapping("/username")
    public String username(@RequestParam("username") String username) {
        return username;
    }


}
