package com.fangzg.proxy.service.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {
	private Object subjectService;
	public DynamicProxy(Object subjectService){
		this.subjectService = subjectService;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)throws Throwable {
		System.out.println("proxy start....");
//		System.out.println("Object proxy:"+proxy);
		System.out.println("before rent house");
		
		System.out.println("Method:"+method);
		
		method.invoke(subjectService, args);
		
		System.out.println("after rent my house ");
		
		return null;
	}



}
