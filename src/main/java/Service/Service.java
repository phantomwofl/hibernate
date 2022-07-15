package service;

import repository.Repository;
import entity.Person;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private Repository repository = new Repository();

    public List<Person> getPersonsByCity(String city) {
        return repository.getPersonsByCity(city);
    }

    public List<Person> getPersonsByAge(int age) {
        return repository.getPersonsByAge(age);
    }

    public List<Person> getPersonsByNameAndSurname(String name, String surname) {
        return repository.getPersonsByNameAndSurname(name, surname);
    }
}
