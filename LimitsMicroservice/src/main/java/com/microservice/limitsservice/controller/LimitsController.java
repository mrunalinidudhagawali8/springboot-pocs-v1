package com.microservice.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.limitsservice.config.LimitsConfiguration;
import com.microservice.limitsservice.model.Limits;

@RestController
@RefreshScope
public class LimitsController {

	@Autowired
	LimitsConfiguration limitsConfig;

	@GetMapping("/limits")
	public Limits retrieveLimits() {
		return new Limits(limitsConfig.getMinimum(), limitsConfig.getMaximum());
	}
}
