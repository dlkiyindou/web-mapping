package fr.scholanova.group.java.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(
    		@RequestParam("firstName") String firstName, 
    		@RequestParam("lastName") String lastName) {
    	User user =  new User();
    	user.setLastName(lastName);
    	user.setFirstName(firstName);
    	
    	userService.save(user);
    	
        return user.toString();
    }
    
    @RequestMapping("/get")
    public Collection<User> get(
    		@RequestParam(value = "firstName", required = false) String firstName,
    		@RequestParam(value = "lastName", required = false) String lastName
    		) {
    	
    	Collection<User> response = null;
    	
    	if (lastName != null && firstName == null) {
    		response = userService.getByLastName(lastName);
    	} else if (lastName == null && firstName != null) {
    		response = userService.getByFirstName(firstName);
    	} else if (lastName != null && firstName != null) {
//    		response = userService.getByName(firstName, lastName);
    	}
    	
    	return response;
    }
    
}