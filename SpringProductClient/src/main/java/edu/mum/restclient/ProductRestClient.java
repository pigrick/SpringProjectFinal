package edu.mum.restclient;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import edu.mum.product.domain.Product;




@Service
public class ProductRestClient{
	
	@Autowired
	RestTemplate restTemplate;
	
	public List<Product> getAllProductList(){	
		Product[] products = restTemplate.getForObject("http://localhost:8080/productRest/getAllProduct", Product[].class);
		List<Product> prods = Arrays.asList(products);
		return prods;
	}
	
	public Product getProduct(int id){
		Product product = restTemplate.getForObject("http://localhost:8080/productRest/getProduct/" + id, Product.class);		
		return product;
	}
	
	public void createProduct(Product product){
		restTemplate.postForObject("http://localhost:8080/productRest/saveProduct", product, Product.class);
	}
	
	public void updateProduct(Product product){
		restTemplate.postForObject("http://localhost:8080/productRest/saveProduct", product, Product.class);
	}
	
	public void removeProduct(Product product){
		restTemplate.postForObject("http://localhost:8080/productRest/removeProduct", product, Product.class);
	}


}
