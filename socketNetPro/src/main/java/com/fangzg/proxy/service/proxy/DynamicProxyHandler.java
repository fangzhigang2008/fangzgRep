package com.fangzg.proxy.service.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/**
 * 个人理解此类不能叫做动态代理，应该叫做动态代理Handler，由Proxy.newProxyInstance(...)方法生成的对象
 * 才能叫做动态代理，
 * @author geeqhsios
 *
 */
public class DynamicProxyHandler implements InvocationHandler {
	private Object subjectService;
	public DynamicProxyHandler(Object subjectService){
		this.subjectService = subjectService;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)throws Throwable {
		System.out.println("proxy start....");
		System.out.println("===========================");
		System.out.println("Object proxy:"+proxy.getClass().getName());
		System.out.println("Object proxy:"+proxy.getClass().getModifiers());
		System.out.println("Object proxy:"+proxy.getClass().getMethods().length);
		for(Method m : proxy.getClass().getMethods()){
			System.out.println(m.getName());
		}
		
		System.out.println("===========================");
		System.out.println("before rent house");
		
		System.out.println("Method:"+method);
		
		method.invoke(subjectService, args);
		
		System.out.println("after rent my house ");
		
		return null;
	}



}
