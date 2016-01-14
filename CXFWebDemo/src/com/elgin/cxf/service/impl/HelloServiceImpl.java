package com.elgin.cxf.service.impl;

import javax.jws.WebService;
import com.elgin.cxf.entities.User;
import com.elgin.cxf.service.HelloService;

@WebService(endpointInterface="com.elgin.cxf.service.HelloService",
            targetNamespace="http://service.cxf.elgin.com/")
public class HelloServiceImpl implements HelloService {

	@Override
	public String sayHello(String text ) {
		return "hello " + text;
	}

	@Override
	public User getUserByName(String name) {
		User user=new User(name);
		return user;
	}

}
