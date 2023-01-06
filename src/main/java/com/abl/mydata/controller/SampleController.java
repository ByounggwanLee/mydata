package com.abl.mydata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.abl.mydata.feign.SampleFeign;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "테스트 Controller")
public class SampleController {
	@Autowired 
	SampleFeign sampleFeign;
	
	
	@GetMapping("/hellogWorld/string")
	@ResponseBody
	public String helloWorldString() {
		return "hello ";		
	}
	
	@GetMapping("/hellogWorld/{name}")
	@ResponseBody
	public String helloName(@PathVariable("name")String name) {
		return "hello " + name;		
	}
	
	@GetMapping("/feignSample/{name}")
	@ResponseBody
	public String feignSample(@PathVariable("name")String name) {
		return "Feign Client " + sampleFeign.helloName(name) + "!!!!";		
	}
}
