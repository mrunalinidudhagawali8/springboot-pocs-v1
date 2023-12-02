package com.thymeleaf.view.resolver;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MyAppService {


    List<MyProduct> getAllProducts()
    {
    	MyProduct prod1 = new MyProduct();
    	prod1.setDescription("A milk choclate");
    	prod1.setId(1L);
    	prod1.setName("Dairy Milk");
    	
    	MyProduct prod2 = new MyProduct();
    	prod2.setId(2L);
    	prod2.setName("Mi 11X Pro");
    	prod2.setDescription("Yet another MI phone");
    	
    	List<MyProduct> list = Arrays.asList(prod1, prod2);
    	
    	return list;
    }
}
