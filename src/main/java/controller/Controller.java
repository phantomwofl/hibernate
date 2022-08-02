package controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import services.Service;
import entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private Service service = new Service();

    @Secured({"READ"})
    @GetMapping("/persons/by-city")
    public List<Person> getPersonsByCity(@RequestParam("city") String city) {
        return service.getPersonsByCity(city);
    }

    @PreAuthorize("hasAnyRole('WRITE' or 'DELETE')")
    @GetMapping("/persons/by-age")
    public List<Person> getPersonsByAge(@RequestParam("age") int age) {
        return service.getPersonsByAge(age);
    }

    @RolesAllowed({"WRITE"})
    @GetMapping("/persons/by-name&surname")
    public List<Person> getPersonsByNameAndSurname(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return service.getPersonsByNameAndSurname(name, surname);
    }

    @PreAuthorize("#username == authentication.principal.username")
    @GetMapping("/persons")
    public String greetingUser(@RequestParam("username") String username) {
        return "Hello from secure app, " + username;
    }
}
