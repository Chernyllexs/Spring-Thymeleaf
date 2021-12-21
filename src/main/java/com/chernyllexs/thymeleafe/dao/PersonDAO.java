package com.chernyllexs.thymeleafe.dao;

import com.chernyllexs.thymeleafe.models.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT,"Anderson","Tom","Ivanovich"));
        people.add(new Person(++PEOPLE_COUNT,"Akimov","Gleb","Igorevich"));
        people.add(new Person(++PEOPLE_COUNT,"Saveliev","Vitaly ","Alekseevich"));
        people.add(new Person(++PEOPLE_COUNT,"Alekseyev ","Rostislav  ","Evgenievich"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId()==id).findAny().orElse(null);
    }
}
