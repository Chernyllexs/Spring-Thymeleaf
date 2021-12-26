package com.chernyllexs.thymeleafe.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class SearchPerson {
    @NotEmpty(message = "Should not be empty")
    @Size(message = "Surname should be between 2 and 20 symbols")
    private String surname;
    @NotEmpty(message = "Should not be empty")
    @Size(message = "Name should be between 2 and 20 symbols")
    private String name;

    public SearchPerson(String surname, String name) {
        this.surname = surname;
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
