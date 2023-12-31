package Brent.Cubbage.CRUDpractice.Controller;

import Brent.Cubbage.CRUDpractice.Service.PersonService;
import Brent.Cubbage.CRUDpractice.Repository.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping(value = "/person")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @PostMapping (value = "/create")
    public ResponseEntity<Person> create(@RequestBody Person person){
        personService.create(person);
        return ResponseEntity.status(HttpStatus.OK).body(person);
    }

    @GetMapping(value = "/read")
    public ResponseEntity<List<Person>> readAll(){
        List<Person> personList = personService.readAll();
        return ResponseEntity.status(HttpStatus.OK).body(personList);
    }

    @GetMapping(value = "/read/{id}")
    public ResponseEntity<Person> readById(@PathVariable Long id){
        Person person = personService.readById(id);
        return ResponseEntity.status(HttpStatus.OK).body(person);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Person> update(@PathVariable Long id, @RequestBody Person person){
        Person updatedPerson = personService.update(id, person);

        return ResponseEntity.status(HttpStatus.OK).body(updatedPerson);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Person> delete(@PathVariable Long id){
        Person deletedPerson = personService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(deletedPerson);
    }

}
