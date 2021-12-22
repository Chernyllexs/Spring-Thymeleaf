package com.chernyllexs.thymeleafe.dao;

import com.chernyllexs.thymeleafe.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT,"Anderson","Tom","Ivanovich",49,22800.777,"tom@mai.ru","NNTU"));
        people.add(new Person(++PEOPLE_COUNT,"Akimov","Gleb","Igorevich", 35,777.777,"gleb@mail.ru","NC"));
        people.add(new Person(++PEOPLE_COUNT,"Saveliev","Vitaly ","Alekseevich",22,100,"vit@mail.ru","NC"));
        people.add(new Person(++PEOPLE_COUNT,"Alekseyev ","Rostislav  ","Evgenievich",55,500,"alex@mail.ru","KFC"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId()==id).findAny().orElse(null);
    }

    public void add(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }
}
