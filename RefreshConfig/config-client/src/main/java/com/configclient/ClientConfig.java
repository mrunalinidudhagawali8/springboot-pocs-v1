package com.configclient;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("key")
public class ClientConfig {
	
	private int source;

	public int getSource() {
		return source;
	}

	public void setSource(int source) {
		this.source = source;
	}
	

}
