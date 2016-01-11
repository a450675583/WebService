package com.elgin.cxf.client;


import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import com.elgin.cxf.entities.User;
import com.elgin.cxf.service.HelloService;

public class Client {
	private static final QName SERVICE_NAME 
    = new QName("http://impl.service.cxf.elgin.com/", "HelloService");
    private static final QName PORT_NAME 
    = new QName("http://impl.service.cxf.elgin.com/", "HelloServicePort");


	private Client() {} 

	public static void main(String args[]) throws Exception {
	     rightInvoker();
	     exceptionInvoker();
	}
	
   /* 
	* @Title: rightInvoker
	* @Description: �ɳɹ����ã�������ȷ�Ľ��
	* @throws Exception    ����
	*/
	public static void rightInvoker() throws Exception  {
		// Endpoint Address
	    String endpointAddress = "http://localhost:8080/service/hello";
	    URL url=new URL(endpointAddress);
	    Service service = Service.create(url,SERVICE_NAME);
	   
	    HelloService hs = service.getPort(HelloService.class);
	    System.out.println(hs.sayHello("World"));
	
	    User user = new User("Jack");
	    System.out.println(hs.sayHellloToUser(user));
	}
	
   /*
	* @Title: exceptionInvoker
	* @Description: ����ʱ�����쳣������Ϣ��
	* 
	* Exception in thread "main" javax.xml.ws.WebServiceException: 
	* WSDL Metadata not available to create the proxy, 
	* either Service instance or ServiceEndpointInterface com.elgin.cxf.service.HelloService should have WSDL information
	* 
	* ������������쳣�ľ���ԭ���в���ȷ�����п�����ȱ��CXFĳ��jar������
	*/
	public static void exceptionInvoker(){
		// Endpoint Address
		Service service = Service.create(SERVICE_NAME);
	    String endpointAddress = "http://localhost:8080/service/hello";
	    service.addPort(PORT_NAME, SOAPBinding.SOAP11HTTP_BINDING, endpointAddress);
	    HelloService hs = service.getPort(HelloService.class);
	    System.out.println(hs.sayHello("World"));
	
	    User user = new User("Jack");
	    System.out.println(hs.sayHellloToUser(user));
	}
}

