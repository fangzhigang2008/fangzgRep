package com.fangzg.proxy.service.impl;

import com.fangzg.proxy.service.SubjectService;

public class SubjectServiceImpl implements SubjectService{

	@Override
	public void rent() {
		System.out.println("I want to rent my house");
		
	}

	@Override
	public void hello(String str) {
		System.out.println("Hello:"+str);
		
	}

}
