package edu.mum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.product.domain.Product;
import edu.mum.product.domain.ProductType;
import edu.mum.restclient.PersonRestClient;
import edu.mum.restclient.ProductRestClient;

@Controller
public class ProductController {
	
	@Autowired
	ProductRestClient productRestClient;
	
	@RequestMapping(value="/productlist", method=RequestMethod.GET)
	public String getAllProductList(Model model){	
		
		model.addAttribute("products", productRestClient.getAllProductList());
		return "productlist";
	}
	
	@RequestMapping(value="/product/{id}", method=RequestMethod.GET)
	public String getProduct(@PathVariable("id") int id, Model model){		
		model.addAttribute("product", productRestClient.getProduct(id));
		return "index";
	}
	
	@RequestMapping(value="/createProduct", method=RequestMethod.GET)
	public String getCreateProduct(){			
		return "createproduct";
	}
	
	@RequestMapping(value="/createProduct", method=RequestMethod.POST)
	public String createProduct(String productName, String description, double price, String productType){			
		Product newP = new Product(productName, description, price, ProductType.valueOf(productType));
		productRestClient.createProduct(newP);
		return "redirect:/productlist";
	}
	
}
