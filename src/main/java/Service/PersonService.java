package Service;

import Repository.Person;
import Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person create(Person person) {
        return personRepository.save(person);
    }

    public Person readById(Long id) {
        return personRepository.findById(id).isPresent() ? personRepository.findById(id).get() : null;
    }

    public List<Person> readAll(){
        Iterable<Person> personIterable = personRepository.findAll();
        List<Person> personList = new ArrayList<>();

        personIterable.forEach(personList::add);
        return personList;
    }

    public Person update(Long id, String name){
        Person updatePerson = readById(id);
        updatePerson.setName(name);
        personRepository.save(updatePerson);
        return updatePerson;
    }

    public Person delete(Long id){
        Person deleted = readById(id);
        personRepository.deleteById(id);
        return deleted;
    }
}
