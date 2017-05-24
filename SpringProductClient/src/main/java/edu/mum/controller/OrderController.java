package edu.mum.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.product.domain.Order;
import edu.mum.product.domain.Orderline;
import edu.mum.product.domain.Person;
import edu.mum.restclient.OrderRestClient;
import edu.mum.restclient.PersonRestClient;
import edu.mum.restclient.ProductRestClient;

@Controller
public class OrderController {
	
	@Autowired
	OrderRestClient orderRestClient;
	
	@Autowired
	PersonRestClient personRestClient;
	
	@Autowired
	ProductRestClient productRestClient;
	
	@RequestMapping(value="/orderlist", method= RequestMethod.GET)
	public String getAllOrder(Model model){
		model.addAttribute("orders", orderRestClient.getAllOrder());
		return "orderlist";
	}
	
	@RequestMapping(value="/addOrder", method= RequestMethod.GET)
	public String addOrder(){

		Order or = new Order();
		or.setOrderDate(new Date());
		or.setPerson(personRestClient.getPerson(6));
		Orderline ol = new Orderline();
		ol.setProduct(productRestClient.getProduct(1));
		ol.setQuantity(4);
		Orderline ol2 = new Orderline();
		ol2.setProduct(productRestClient.getProduct(2));
		ol2.setQuantity(3);
		or.addOrderLine(ol);
		or.addOrderLine(ol2);
		orderRestClient.createOrder(or);
		
		return "redirect:/orderlist";
	}
}
