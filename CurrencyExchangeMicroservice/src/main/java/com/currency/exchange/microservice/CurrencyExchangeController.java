package com.currency.exchange.microservice;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment environment;

	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepo;

	@GetMapping("/currency-exchanges")
	public List<CurrencyExchange> retrieveAllExchangeValue() {
		List<CurrencyExchange> allCurrencyExchanges = currencyExchangeRepo.findAll();
		return allCurrencyExchanges;
	}

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		CurrencyExchange currencyExchangeObj = currencyExchangeRepo.findByFromAndTo(from, to);
		if(currencyExchangeObj==null)
		{
			throw new RuntimeException("Unable to find the CurrencyExchange values for " + from +" to " + to);
		}
		String port = environment.getProperty("local.server.port");
		currencyExchangeObj.setEnvironment(port);
		return currencyExchangeObj;
	}
	
}
