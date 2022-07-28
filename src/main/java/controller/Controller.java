package controller;

import services.Service;
import entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private Service service = new Service();

    @GetMapping("/persons/by-city")
    public List<Person> getPersonsByCity(@RequestParam("city") String city) {
        return service.getPersonsByCity(city);
    }

    @GetMapping("/persons/by-age")
    public List<Person> getPersonsByAge(@RequestParam("age") int age) {
        return service.getPersonsByAge(age);
    }

    @GetMapping("/persons/by-name&surname")
    public List<Person> getPersonsByNameAndSurname(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return service.getPersonsByNameAndSurname(name, surname);
    }
}
