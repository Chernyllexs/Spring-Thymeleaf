package com.chernyllexs.thymeleafe.util;

import com.chernyllexs.thymeleafe.models.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileIO {
    private static final String FILE_NAME = "src\\people.txt";

    public static List<Person> readFromFile() {
        List<Person> people = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_NAME))) {
            while (bufferedReader.ready()) {
                Person person = getPerson(bufferedReader.readLine());
                people.add(person);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return people;
    }

    private static Person getPerson(String line) {
        String[] splitLine = line.split("/");

        int id = Integer.parseInt(splitLine[0]);
        String surname = splitLine[1];
        String name = splitLine[2];
        String patronymic = splitLine[3];
        int age = Integer.parseInt(splitLine[4]);
        double salary = Double.parseDouble(splitLine[5]);
        String email = splitLine[6];
        String department = splitLine[7];

        return new Person(id, surname, name, patronymic, age, salary, email, department);
    }

    public static void writeToFile(List<Person> people) {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_NAME))) {
            /*for (Person person : people) {
                bufferedWriter.write(person.toString() + '\n');
            }*/
            for (int i = 0; i < people.size(); i++) {
                String line = people.get(i).toString();
                if(i != people.size() - 1)
                    line += '\n';
                bufferedWriter.write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
