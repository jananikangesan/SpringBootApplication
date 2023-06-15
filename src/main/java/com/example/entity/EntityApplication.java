package com.example.entity;

import com.example.entity.model.Product;
import com.example.entity.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class EntityApplication implements CommandLineRunner {

	private ProductRepository productRepository;
	private Logger LOG=LoggerFactory.getLogger(EntityApplication.class);

	@Autowired
	public void productRepository(ProductRepository productRepository) {
		this.productRepository=productRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(EntityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		Product product1=new Product();
		product1.setName("Tester Product");
		product1.setCategory("TEST");
		product1.setType("GENERAL");
		product1.setDescription("Product1");
		product1.setPrice(10.0);
		product1.setSector("Science");

		productRepository.save(product1);

		Product product2=new Product();
		product2.setName("Another Tester Product");
		product2.setCategory("TEST");
		product2.setType("CUSTOM");
		product2.setDescription("This is a tester product");
		product2.setPrice(15.0);
		product2.setSector("IT");

		productRepository.save(product2);

		Product product3=new Product();
		product3.setName("Tester Product");
		product3.setCategory("TEST");
		product3.setType("SPECIFIC");
		product3.setDescription("description");
		product3.setPrice(19.0);
		product3.setSector("MATHS");

		productRepository.save(product3);


//		List<Product> products =productRepository.findAll();
//		for(Product product:products){
//			LOG.info("Products found :"+product.toString());
//		}

//		Product resultProduct= productRepository.findByType("GENERAL");
//		LOG.info("GENERAL type of products found: "+ resultProduct.toString());

//		List<Product> results= productRepository.findByDescriptionAndCategory("This is a tester product","TEST");
//
//		for(Product product:results){
//			LOG.info("Matching results are:"+ product.toString());
//		}

		List <String> names=new ArrayList<>();
		names.add("Tester Product");
		//names.add("Another Tester Product");

		List<Product> resultProducts=productRepository.findByCategoryAndNameIn("TEST",names);

		for(Product product: resultProducts){
			LOG.info("Matching results for findByCategoryAndNameIn:"+ product.toString());
		}

	}

}
