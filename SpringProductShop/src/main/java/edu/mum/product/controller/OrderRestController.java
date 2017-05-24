package edu.mum.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.product.domain.Order;
import edu.mum.product.domain.Orderline;
import edu.mum.product.domain.Person;
import edu.mum.product.service.OrderService;
import edu.mum.product.service.PersonService;

@RestController
@RequestMapping("/orderRest")
public class OrderRestController {
	
	@Autowired
	OrderService orderService;
	@Autowired
	PersonService personService;
	
	
	@RequestMapping(value="/getAllOrder", method = RequestMethod.GET)
	public List<Order> getAllOrder(){
		List<Order> orders= orderService.findAll();
		for(Order order: orders){
			for(Orderline orderline : order.getOrderLines()){
				orderline.setOrder(null);
			}
		}
		return orders;
	}
	
	@RequestMapping(value="/getOrder/{id}", method = RequestMethod.GET)
	public Order getOrder(@PathVariable("id") int id){
		return orderService.findById(id);
	}
	@RequestMapping(value="/getOrderByPerson/{id}", method = RequestMethod.GET)
	public List<Order> findByPerson(@PathVariable("id") long id) {
		return orderService.findByPerson(personService.findById(id));
	}
	
	@RequestMapping(value="/saveOrder", method = RequestMethod.POST)
	public void saveOrder(@RequestBody Order order){
		orderService.save(order);
	}
	

}
