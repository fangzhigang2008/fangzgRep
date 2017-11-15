package com.fangzg.encrypt;

import org.apache.commons.codec.binary.Base64;


/**
 * DESede�����࣬����Ϊһ��������
 * @author geeqhsios
 *
 */
public class DESedeCoderTest {	
	public static void main(String[] args) throws Exception {
		String text = "Hello ,�ҽ�MT";
		System.out.println("ԭ����ֵ��" + text);
		
		byte[] encodeBase64 = Base64.encodeBase64(text.getBytes());
		System.out.println("base64������ԭ����ֵ��" + new String(encodeBase64));
		
		byte[] key = DESedeCoder.initKey();
		System.out.println("base64��������Կֵ��"+ Base64.encodeBase64String(key));
		
		byte[] cipherData = DESedeCoder.encrypt(encodeBase64, key);
		System.out.println("���ܺ������ֵ����base64������ֵΪ��"+ Base64.encodeBase64String(cipherData));
		
		byte[] decrypt = DESedeCoder.decrypt(cipherData, key);
		System.out.println("���ܺ�base64����ֵ��" + new String(decrypt));
		
		System.out.println("���ܺ������ֵ��" + new String(Base64.decodeBase64(decrypt)));
	}
}
