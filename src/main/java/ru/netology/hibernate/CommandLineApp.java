package ru.netology.hibernate;

import Interface_rep.CityRepository;
import Interface_rep.PersonRepository;
import entity.City;
import entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Sort;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CommandLineApp implements CommandLineRunner {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private PersonRepository personRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        var names = List.of("Вася", "Петя", "Коля", "Саша");

        var surnames = List.of("Иванов", "Петров", "Сидоров", "Смирнов");
        List<City> cities = Stream.of("Москва", "Самара", "Казань", "Астрахань")
                .map(n -> City.builder()
                        .name(n)
                        .build())
                .collect(Collectors.toUnmodifiableList());
        cityRepository.saveAll(cities);

        var random = new Random();

        IntStream.range(0, 50)
                .forEach(i -> {
                    var person = Person.builder()
                            .name(names.get(random.nextInt(names.size())))
                            .surname(surnames.get(random.nextInt(surnames.size())))
                            .age(random.nextInt(50))
                            .phone_number("4124125")
                            .city(cities.get(random.nextInt(cities.size())))
                            .build();
                    personRepository.save(person);
                });

        personRepository.findByNameAndSurname("Вася", "Иванов")
                .forEach(System.out::println);

        personRepository.findByAgeLessThan(40, Sort.by("age").ascending())
                .forEach(System.out::println);

        personRepository.findByCity(cityRepository.findByName("Москва"))
                .forEach(System.out::println);
    }
}
