package repository;


import Interface_rep.CityRepository;
import Interface_rep.PersonRepository;
import entity.City;
import entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@org.springframework.stereotype.Repository
@Transactional
public class Repository {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private PersonRepository personRepository;

    @Transactional
    public List<Person> getPersonsByCity(String city) {
        return personRepository.findByCity(cityRepository.findByName(city));
    }

    @Transactional
    public List<Person> getPersonsByAge (int age) {
        return personRepository.findByAgeLessThan(age, Sort.by("age").ascending());
    }

    @Transactional
    public List<Person> getPersonsByNameAndSurname (String name, String surname) {
        return personRepository.findByNameAndSurname(name, surname);
    }
}
