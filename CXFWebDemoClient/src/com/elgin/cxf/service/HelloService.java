package com.elgin.cxf.service;

import javax.jws.WebParam;
import javax.jws.WebService;


@WebService
public interface HelloService {
   
	public String sayHello(@WebParam(name="text")String text);
	
}
