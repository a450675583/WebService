package com.elgin.cxf.service.impl;

import javax.jws.WebService;

import com.elgin.cxf.entities.User;
import com.elgin.cxf.service.HelloService;


@WebService(endpointInterface="com.elgin.cxf.service.HelloService",serviceName="helloCXF")
public class HelloServiceImpl implements HelloService {

	@Override
	public String sayHello(String text) {
		
		return "hello" + text;
	}

	@Override
	public String sayHellloToUser(User user) {
		
		return "hello" + user.getName();
	}

}
