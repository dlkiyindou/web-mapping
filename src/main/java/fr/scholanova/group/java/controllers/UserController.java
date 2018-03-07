package fr.scholanova.group.java.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.scholanova.group.java.entities.User;
import fr.scholanova.group.java.services.UserService;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("user")
@Slf4j
@RestController
public class UserController {
    @Autowired
	private UserService userService;
    @RequestMapping({"", "/"})
    public Collection<User> index() {
        return userService.getAll();
    }
    
    @RequestMapping("/add")
    public String add() {
        return "Add user";
    }
    
}