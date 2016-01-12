package com.elgin.cxf.service.impl;

import javax.jws.WebService;

import com.elgin.cxf.entities.User;
import com.elgin.cxf.service.HelloService;


@WebService(endpointInterface="com.elgin.cxf.service.HelloService")
public class HelloServiceImpl implements HelloService {

	@Override
	public String sayHello(String text) {
		System.out.println("param text is :" + text);
		return "hello " + text;
	}

	@Override
	public String sayHellloToUser(User user) {
		System.out.println("param user is :" +user);
		return "hello " + user.getName();
	}

}
