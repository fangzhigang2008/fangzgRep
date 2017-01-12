package com.fangzg.proxy.controller;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import com.fangzg.proxy.service.SubjectService;
import com.fangzg.proxy.service.impl.SubjectServiceImpl;
import com.fangzg.proxy.service.proxy.DynamicProxy;

public class ClientController {
	public static void main(String[] args) {
		SubjectService subjectService = new SubjectServiceImpl();
		
		InvocationHandler handler = new DynamicProxy(subjectService);
		
		SubjectService subjectServiceProxy = (SubjectService) Proxy.newProxyInstance(
				handler.getClass().getClassLoader(),
				subjectService.getClass().getInterfaces(), handler);
		
		subjectServiceProxy.rent();
		subjectServiceProxy.hello("fangzhigang");
		
	}
}
