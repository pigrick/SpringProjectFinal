package edu.mum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.mum.product.domain.Order;
import edu.mum.restclient.PersonRestClient;

@Controller
@SessionAttributes(value={"order", "person"})
public class HomeController {
	
	@Autowired
	PersonRestClient personRestClient;
	
	@RequestMapping("/")
	public String getIndex(Model model){
		if(!model.containsAttribute("order")){
			model.addAttribute("order", new Order());
		}
		if(!model.containsAttribute("person")){
			model.addAttribute("person", personRestClient.getPerson(1));
		}
		return "index";
	}
}
