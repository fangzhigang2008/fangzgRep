package com.fangzg.proxy.controller;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import com.fangzg.proxy.service.SubjectService;
import com.fangzg.proxy.service.impl.SubjectServiceImpl;
import com.fangzg.proxy.service.proxy.DynamicProxyHandler;

public class ClientController {
	public static void main(String[] args) {
		SubjectService subjectService = new SubjectServiceImpl();
		
		InvocationHandler handler = new DynamicProxyHandler(subjectService);
		
		SubjectService subjectServiceProxy = (SubjectService) Proxy.newProxyInstance(
				handler.getClass().getClassLoader(),
				subjectService.getClass().getInterfaces(),
				handler);
		
		subjectServiceProxy.rent();
		
		System.out.println("-----------------------");
		subjectServiceProxy.hello("fangzhigang");
		
	}
}
