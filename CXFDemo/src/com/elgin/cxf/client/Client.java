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
	* @Description: 可成功调用，返回正确的结果
	* @throws Exception    参数
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
	* @Description: 调用时出现异常错误信息：
	* 
	* Exception in thread "main" javax.xml.ws.WebServiceException: 
	* WSDL Metadata not available to create the proxy, 
	* either Service instance or ServiceEndpointInterface com.elgin.cxf.service.HelloService should have WSDL information
	* 
	* 对于造成上述异常的具体原因尚不明确，很有可能是缺少CXF某个jar包引起
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

