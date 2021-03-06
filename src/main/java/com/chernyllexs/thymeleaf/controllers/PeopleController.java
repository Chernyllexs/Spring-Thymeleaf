package com.chernyllexs.thymeleaf.controllers;

import com.chernyllexs.thymeleaf.util.PersonDAO;
import com.chernyllexs.thymeleaf.models.Person;
import com.chernyllexs.thymeleaf.models.SearchPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people", personDAO.index());
        return "/people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDAO.show(id));
        return "/people/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "/people/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "/people/new";
        personDAO.add(person);
        return "redirect:/people";
    }

    @GetMapping("/find")
    public String findPerson(@ModelAttribute("searchPerson") SearchPerson searchPerson) {
        return "/people/find";
    }

    @PostMapping("/find")
    public String find(@ModelAttribute("searchPerson") @Valid SearchPerson searchPerson, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "/people/find";

        Person person = personDAO.search(searchPerson);
        if (person != null)
            return "redirect:/people/" + person.getId();
        else
            return "redirect:/people/not-found";
    }

    @GetMapping("/not-found")
    public String showNotFound() {
        return "/people/not-found";
    }
}
