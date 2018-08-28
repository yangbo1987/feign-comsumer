package com.spring.cloud.es.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cloud.es.bean.User;
import com.spring.cloud.es.service.HelloService;


@RestController
public class ComsumerController {
	
	@Autowired
	private HelloService helloService;
	
	@RequestMapping(value="/feign-comsumer",method=RequestMethod.GET)
	public String hello(){
		return helloService.hello();
	}
	
	@RequestMapping(value="/feign-comsumer2",method=RequestMethod.GET)
	public String hello2(){
		StringBuilder sb=new StringBuilder();
		sb.append(helloService.hello1("YB")).append("\n");
		sb.append(helloService.hello2("YB", 31)).append("\n");
		sb.append(helloService.hello3(new User("YB",31))).append("\n");
		return sb.toString();
	}
	
	
}
