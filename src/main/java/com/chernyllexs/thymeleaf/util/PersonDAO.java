package com.chernyllexs.thymeleaf.util;

import com.chernyllexs.thymeleaf.models.Person;
import com.chernyllexs.thymeleaf.models.SearchPerson;
import com.chernyllexs.thymeleaf.util.FileIO;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.util.List;

@Component
public class PersonDAO {
    private static final String FILE_DATABASE_NAME = "src\\people.txt";
    private List<Person> people = FileIO.readFromFile(FILE_DATABASE_NAME);

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void add(Person person) {
        person.setId(people.size() + 1);
        people.add(person);
        FileIO.writeToFile(people, FILE_DATABASE_NAME);
    }

    public Person search(SearchPerson searchPerson) {
        return people.stream().filter(person -> person.getName().equals(searchPerson.getName()) && person.getSurname().equals(searchPerson.getSurname())).findAny().orElse(null);
    }

    public void uploadPerson(Path path) {
        if (path == null)
            return;
        people.addAll(FileIO.readFromFile(path.toString()));

        for (int i = 0; i < people.size(); i++) {
            people.get(i).setId(i + 1);
        }
        FileIO.writeToFile(people, FILE_DATABASE_NAME);
    }
}
