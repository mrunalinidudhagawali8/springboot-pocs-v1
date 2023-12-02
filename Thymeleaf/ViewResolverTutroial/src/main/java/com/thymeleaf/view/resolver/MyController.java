package com.thymeleaf.view.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MyController {
	
	@Autowired
	private MyAppService service;

	@GetMapping("/products1")
	public String getProductList(Model model)
	{
		List<MyProduct> list = service.getAllProducts();
		model.addAttribute("products", list);
		
		return "index";
	}
	
	
	@GetMapping("/products2")
	public String getProductList2(Model model)
	{
		List<MyProduct> list = service.getAllProducts();
		model.addAttribute("products", list);
		
		return "index-2";
	}
	
	
	@GetMapping("/products3")
	public String getProductList3(Model model)
	{
		List<MyProduct> list = service.getAllProducts();
		model.addAttribute("products", list);
		
		return "index-3";
	}
	
}
