package edu.mum.restclient;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import edu.mum.product.domain.Order;
import edu.mum.product.domain.Orderline;
import edu.mum.product.domain.Person;

@Service
public class OrderRestClient {

	@Autowired
	RestTemplate restTemplate;
	
	public List<Order> getAllOrder(){
		return Arrays.asList(restTemplate.getForObject("http://localhost:8080/orderRest/getAllOrder", Order[].class));
	}
	
	public Order getOrder(int id){
		return restTemplate.getForObject("http://localhost:8080/orderRest/getOrder/"+ id, Order.class);
	}
	
	public List<Order> getOrderByPerson(Person person){
		return Arrays.asList(restTemplate.getForObject("http://localhost:8080/orderRest/getOrderbyPerson/" + person.getId(), Order[].class));
	}
	
	public void createOrder(Order order){
		restTemplate.postForObject("http://localhost:8080/orderRest/saveOrder", order, Order.class);
	}
	
	
	
}
