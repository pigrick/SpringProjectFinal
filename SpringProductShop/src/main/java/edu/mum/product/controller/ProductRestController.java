package edu.mum.product.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.product.domain.Product;
import edu.mum.product.domain.ProductType;
import edu.mum.product.service.ProductService;

@RestController
@RequestMapping("/productRest")
public class ProductRestController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value="/getAllProduct", method = RequestMethod.GET)
	public List<Product> getAllProductList(){
		return productService.getAllProduct();
	}
	
	@RequestMapping(value="/getProduct/{id}", method = RequestMethod.GET)
	public Product getAllProductList(@PathVariable("id") int id){
		return productService.getProduct(id);
	}
	
	@RequestMapping(value="/saveProduct", method = RequestMethod.POST)
	public void saveProduct(@RequestBody Product product){
		productService.save(product);
	}
	
	@RequestMapping(value="/removeProduct", method = RequestMethod.POST)
	public void removeProduct(@RequestBody Product product){
		productService.delete(product);
	}
	
}
