package edu.mum.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.product.domain.Person;
import edu.mum.product.domain.Product;
import edu.mum.product.service.PersonService;

@RestController
@RequestMapping("/personRest")
public class PersonRestController {
	
	@Autowired
	PersonService personService;
	
	
	@RequestMapping(value="/getAllPerson", method = RequestMethod.GET)
	public List<Person> getAllPerson(){
		return personService.findAll();
	}
	
	@RequestMapping(value="/getPerson/{id}", method = RequestMethod.GET)
	public Person getPerson(@PathVariable("id") long id){
		return personService.findById(id);
	}
	
	@RequestMapping(value = "/savePerson", method = RequestMethod.POST)
	public void save(@RequestBody Person person){
	    personService.savePerson(person);
	}
	
}
