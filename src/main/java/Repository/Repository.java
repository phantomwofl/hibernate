package Repository;


import entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@org.springframework.stereotype.Repository
@Transactional
public class Repository {

    @PersistenceContext
    private EntityManager entityManager;

    public void setEntityManager() {
        var names = List.of("Вася", "Петя", "Коля", "Саша");
        var surnames = List.of("Иванов", "Петров", "Сидоров", "Смирнов");
        var cities = List.of("Москва", "Самара", "Казань", "Астрахань");
        var random = new Random();

        IntStream.range(0, 50)
                .forEach(i -> {
                    var person = Person.builder()
                            .name(cities.get(random.nextInt(names.size())))
                            .surname(surnames.get(random.nextInt(surnames.size())))
                            .age(random.nextInt(50))
                            .phone_number("4124125")
                            .city(cities.get(random.nextInt(cities.size())))
                            .build();
                    entityManager.persist(person);
                });
    }

    public List<Person> getPersonsByCity (String city) {
        setEntityManager();
        List<Person> persons = null;
        Query query = entityManager.createQuery("select p from Person p where p.city = :city");
        query.setParameter("city", city);
        query.getResultList().containsAll(persons);
        return persons;
    }
}
