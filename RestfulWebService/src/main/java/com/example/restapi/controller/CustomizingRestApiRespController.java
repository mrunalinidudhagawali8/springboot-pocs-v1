package com.example.restapi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.model.SomeBean;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class CustomizingRestApiRespController {

	/**
	 * Customizing RestAPI responses:
	 * 
	 * Serialization : converting model object to stream(json)
	 * 
	 * 1. To Customize field names in responses
	 * use @JsonProperty
	 * 
	 * 2. Filtering:return only selected fields
	 * 
	 * there are 2 types of filtering:
	 * a. Static (Same filtering of a bean across different RESTApi) eg. you want to hide password field in all responses 
	 * 				(@JsonIgnoreProperties, @JsonIgnore)
	 *	a.1)@JsonIgnoreProperties can be used on class level - ("field1")
	 *	a.2)@JsonIgnore can be used on field-level
	 * 
	 * b. Dynamic (Customize filtering for a bean for specific RESTApi, can be only applied on restController method)
	 *  			(@JsonFilter along with FilterProvider)
	 *  
	 *  NOTE: If a field is marked as ignored statically, even if we want to fetch that field dynamically, its not possible
	 *  
	 */

	@GetMapping("/static/fields")
	public SomeBean filterFieldTwo() {
		return new SomeBean("value1", "value2", "value3", "value4", "value5");
	}

	@GetMapping("/static/some-bean-list")
	public List<SomeBean> retrievBeansList() {
		return Arrays.asList(new SomeBean("value1", "value2", "value3", "value4", "value5"),
				new SomeBean("value1", "value2", "value3", "value4", "value5"));
	}

	@GetMapping("/dynamic/fields")
	public MappingJacksonValue retrievBeanUsingDynamicFilter() {
		//3. 
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3", "field5");

		SomeBean aSomeBean = new SomeBean("value1", "value2", "value3", "value4", "value5");
		//1. Create a mapping bean for serialization(conversion of json obj)
		MappingJacksonValue mappingBean = new MappingJacksonValue(aSomeBean);

		//2. define a Filter
		//requires filtername defined on bean and filter
		//to create a filter on a bean use: @JsonFilter("filtername")
		FilterProvider filters = new SimpleFilterProvider().addFilter("JustAnotherSomeBeanDynamicFilterName", filter);

		mappingBean.setFilters(filters);

		return mappingBean;

	}

	@GetMapping("/dynamic/fields-list")
	public MappingJacksonValue retrievBeansListUsingDynamicFilter() {
		//3. 
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3", "field5");

		SomeBean aSomeBean1 = new SomeBean("value1", "value2", "value3", "value4", "value5");
		SomeBean aSomeBean2 = new SomeBean("value1", "value2", "value3", "value4", "value5");
		
		//1. Create a mapping bean for serialization(conversion of json obj)
		MappingJacksonValue mappingBean = new MappingJacksonValue(Arrays.asList(aSomeBean1, aSomeBean2));

		//2. define a Filter
		//requires filtername defined on bean and filter
		//to create a filter on a bean use: @JsonFilter("filtername")
		FilterProvider filters = new SimpleFilterProvider().addFilter("JustAnotherSomeBeanDynamicFilterName", filter);

		mappingBean.setFilters(filters);

		return mappingBean;

	}
}
