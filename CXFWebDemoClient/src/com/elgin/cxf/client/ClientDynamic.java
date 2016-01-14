package com.elgin.cxf.client;

import javax.xml.namespace.QName;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import com.elgin.cxf.service.User;

public class ClientDynamic {
    
	public static void main(String[] args) {
	         //method1();
		     method2();
	}
	
	public static void method1(){
		//创建 JaxWsDynamicClientFactory 工厂实例
		JaxWsDynamicClientFactory factory=JaxWsDynamicClientFactory.newInstance();
		//创建客户端
		Client client=factory.createClient("http://localhost:8080/CXFWebDemo/services/hello?wsdl");
		Object [] result;
		QName qname;
		try {
			//根据指定的命名空间（接口类包名）、方法名新建QName对象
			qname=new QName("http://service.cxf.elgin.com/", "sayHello");
			result=client.invoke(qname, "World");
			System.out.println(result[0]);
			qname=new QName("http://service.cxf.elgin.com/", "getUserByName");
			result=client.invoke(qname, "Jack");
			User user=(User) result[0];
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void method2() {
		JaxWsDynamicClientFactory factory=JaxWsDynamicClientFactory.newInstance();
		Client client=factory.createClient("http://localhost:8080/CXFWebDemo/services/hello?wsdl");
		Object [] result;
		try {
			result=client.invoke("sayHello", "World");
			System.out.println(result[0]);
			result=client.invoke("getUserByName", "Jack");
			User user=(User) result[0];
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
