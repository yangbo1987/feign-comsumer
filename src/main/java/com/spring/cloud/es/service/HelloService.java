package com.spring.cloud.es.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.cloud.es.bean.User;

@FeignClient("hello-service")
public interface HelloService {

	@RequestMapping("/hello")
	String hello();
	
	@RequestMapping(value="/hello1",method=RequestMethod.GET)
	String hello1(@RequestParam("name") String name);
	
	@RequestMapping(value="/hello2",method=RequestMethod.GET)
	public User hello2(@RequestHeader("name") String name,@RequestHeader("age") Integer age);
	
	@RequestMapping(value="/hello3",method=RequestMethod.POST)
	public String hello3(@RequestBody User user);
}
