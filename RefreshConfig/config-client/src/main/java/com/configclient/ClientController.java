package com.configclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ClientController {
	
	@Autowired
	ClientConfig clientconfig;
	
	@GetMapping("/value")
	public ClientRespModel retrieveValues()
	{
		return new ClientRespModel(clientconfig.getSource());
	}
	
	

}
