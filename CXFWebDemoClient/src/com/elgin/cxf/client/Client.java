package com.elgin.cxf.client;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.elgin.cxf.service.HelloService;

public class Client {
    
	
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloService helloService=(HelloService) ctx.getBean("helloService");
		String  result = helloService.sayHello("World");
		System.out.println(result);
	    
	}
	
}
