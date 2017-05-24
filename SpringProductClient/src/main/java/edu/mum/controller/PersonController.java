package edu.mum.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.product.domain.Address;
import edu.mum.product.domain.Person;
import edu.mum.product.domain.Product;
import edu.mum.restclient.PersonRestClient;

@Controller
public class PersonController {
	
	@Autowired
	PersonRestClient personRestClient;
	

	@RequestMapping(value="/addPerson", method = RequestMethod.GET)
	public String getCreate(){
		return "createperson";
	}
	
	@RequestMapping(value="/addPerson", method = RequestMethod.POST)
	public String create(String firstName, String lastName, String email, String phone, String city, String state, String zipcode,String country, String enable){
		Address newAdd = new Address(city, state, country, zipcode);
		Person newP = new Person(firstName,lastName, email, newAdd, phone, (enable.equals("1")? true : false));
		newP.setFirstName(firstName);
		newP.setLastName(lastName);
		newP.setEmail(email);
		newP.setPhone(phone);
		personRestClient.create(newP);
		
		return "redirect:/personlist";
	}
	
	@RequestMapping(value="/personlist", method = RequestMethod.GET)
	public String getAllPerson(Model model){
		model.addAttribute("persons", personRestClient.getAllPerson());		
		return "personlist";
	}
}
