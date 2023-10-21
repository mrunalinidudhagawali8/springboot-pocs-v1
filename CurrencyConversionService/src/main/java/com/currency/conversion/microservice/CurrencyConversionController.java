package com.currency.conversion.microservice;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeProxy currencyExchangeProxy;

	@GetMapping("/currencyconversion/{from}/to/{to}/qty/{qty}")
	public CurrencyConversion calculateCurrencyConversion(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal qty) {

		HashMap<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConversion> entityClass = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVariables);
		CurrencyConversion currencyConversionObj = entityClass.getBody();
		currencyConversionObj.setTotalCalculatedAmt(
				qty.multiply(currencyConversionObj.getConversionMultiple()));
		return currencyConversionObj;

	}
	
	@GetMapping("/currencyconversion-feign/{from}/to/{to}/qty/{qty}")
	public CurrencyConversion calculateCurrencyConversionFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal qty) {
		
		HashMap<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
		CurrencyConversion currencyConversionObj = currencyExchangeProxy.calculateCurrencyConversion(from, to);
		currencyConversionObj.setQuantity(qty);
		currencyConversionObj.setTotalCalculatedAmt(
				qty.multiply(currencyConversionObj.getConversionMultiple()));
		
		return currencyConversionObj;
		
	}
}
