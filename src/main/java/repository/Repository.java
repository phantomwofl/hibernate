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

//    @PersistenceContext
//    private EntityManager entityManager;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private PersonRepository personRepository;

   // @Transactional
//    public void setEntityManager() {
//        var names = List.of("Вася", "Петя", "Коля", "Саша");
//
//        var surnames = List.of("Иванов", "Петров", "Сидоров", "Смирнов");
//        List<City> cities = Stream.of("Москва", "Самара", "Казань", "Астрахань")
//                        .map(n -> City.builder()
//                                .name(n)
//                                .build())
//                                .collect(Collectors.toUnmodifiableList());
//        cityRepository.saveAll(cities);
//
//        var random = new Random();
//
//        IntStream.range(0, 50)
//                .forEach(i -> {
//                    var person = Person.builder()
//                            .name(names.get(random.nextInt(names.size())))
//                            .surname(surnames.get(random.nextInt(surnames.size())))
//                            .age(random.nextInt(50))
//                            .phone_number("4124125")
//                            .city(cities.get(random.nextInt(cities.size())))
//                            .build();
//                    personRepository.save(person);
//                });
//    }
//    @Transactional
//    public List<Person> getPersonsByCity (String city) {
//        setEntityManager();
//        List<Person> persons = null;
//        Query query = entityManager.createQuery("select p from Person p where p.city = :city");
//        query.setParameter("city", city);
//        query.getResultList().containsAll(persons);
//        return persons;
//    }

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
