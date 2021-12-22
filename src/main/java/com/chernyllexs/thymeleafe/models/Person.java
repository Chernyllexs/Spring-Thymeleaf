package com.chernyllexs.thymeleafe.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {
    private int id;
    @Size(message = "Surname should be between 2 and 20 symbols")
    private String surname;
    @Size(message = "Name should be between 2 and 20 symbols")
    private String name;
    @Size(message = "Patronymic should be between 2 and 20 symbols")
    private String patronymic;
    @
    private int age;
    private double salary;
    @NotEmpty(message = "Should not be empty")
    @Email
    private String email;
    @NotEmpty(message = "Should not be empty")
    private String department;

    public Person() {
    }

    public Person(int id, String surname, String name, String patronymic) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }

    public Person(int id, String surname, String name, String patronymic, int age, double salary, String email, String department) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.age = age;
        this.salary = salary;
        this.email = email;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFio(){
        return surname + " " + name + " " + patronymic;
    }


    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", email='" + email + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
