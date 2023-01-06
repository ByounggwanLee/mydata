package com.abl.mydata.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="test", url="${prop.test.url}")
public interface SampleFeign {
	@GetMapping("/hellogWorld/{name}")
	String helloName(@PathVariable("name") String name);
}
