package com.fangzg.encrypt;

import org.apache.commons.codec.binary.Base64;

public class AESCoderTest {
	public static void main(String[] args) {
		String text ="Hello 大家好，我是BANANA!";
		try {
			byte[] initKey = AESCoder.initKey();
			System.out.println(new String(initKey,"gbk"));
			String base64Key = Base64.encodeBase64String(initKey);
			System.out.println(base64Key);
			
			
			System.out.println(new String(Base64.decodeBase64(base64Key),"gbk"));
			byte[] cipherData = AESCoder.encrypt(Base64.decodeBase64(base64Key), text.getBytes());
			byte[] clearData = AESCoder.decrypt(Base64.decodeBase64(base64Key), cipherData);
			
			System.err.println(new String(clearData));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
