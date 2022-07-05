package Service;

import Repository.Repository;
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
}
