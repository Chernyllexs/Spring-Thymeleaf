package com.chernyllexs.thymeleafe.controllers;

import com.chernyllexs.thymeleafe.dao.PersonDAO;
import com.chernyllexs.thymeleafe.models.Person;
import com.chernyllexs.thymeleafe.models.SearchPerson;
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
    public String index(Model model){
        model.addAttribute("people",personDAO.index());
        return "/people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("person", personDAO.show(id));
        return "/people/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person){
        return "/people/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "/people/new";
        personDAO.add(person);
        return "redirect:/people";
    }

    @GetMapping("/find")
    public String findPerson(@ModelAttribute("person") SearchPerson searchPerson){
        return "/people/find";
    }

    @PostMapping()
    public String find(@ModelAttribute("searchPerson") @Valid SearchPerson searchPerson, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors())
            return "/people/find";
        //personDAO.search(searchPerson);
        model.addAttribute("searchPerson", personDAO.search(searchPerson));
        return "/people/show";
    }
}
