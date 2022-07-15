package controller;

import service.Service;
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
    public List<Person> getPersonsByCity (@RequestParam ("city") String city) {
       return service.getPersonsByCity(city);
    }
}
