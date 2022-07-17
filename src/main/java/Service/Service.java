package service;

import interface_rep.CityRepository;
import interface_rep.PersonRepository;
import org.springframework.data.domain.Sort;
import entity.Person;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getPersonsByCity(String city) {
        return personRepository.findByCity(cityRepository.findByName(city));
    }

    public List<Person> getPersonsByAge(int age) {
        return personRepository.findByAgeLessThan(age, Sort.by("age").ascending());
    }

    public List<Person> getPersonsByNameAndSurname(String name, String surname) {
        return personRepository.findByNameAndSurname(name, surname);
    }
}
