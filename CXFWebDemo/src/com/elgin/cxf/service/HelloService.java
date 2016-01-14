package com.elgin.cxf.service;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.elgin.cxf.entities.User;

@WebService
public interface HelloService {
   
	public String sayHello(@WebParam(name="text")String text);
	
	public User getUserByName(String name);
}
