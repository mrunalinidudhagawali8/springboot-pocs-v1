package com.fiegn.client.employee;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="feign-client-address-service", url="localhost:8881")
public interface AddressFiegnClientProxy {

	@GetMapping("/address/{id}")
	public String getAddressById(@PathVariable Long id);

}
