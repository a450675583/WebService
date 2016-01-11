package com.elgin.cxf.publish;

import javax.xml.ws.Endpoint;

import com.elgin.cxf.service.impl.HelloServiceImpl;

public class Server {
	   public static void main(String[] args) {
		System.out.println("cxf service start..");
		HelloServiceImpl serviceImpl=new HelloServiceImpl();
		String address="http://localhost:8080/service/hello";
		Endpoint.publish(address, serviceImpl);
	   }
}
