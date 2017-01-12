package com.fangzg.encrypt;

import org.apache.commons.codec.binary.Base64;


/**
 * DESede加密类，定义为一个抽象类
 * @author geeqhsios
 *
 */
public class DESedeCoderTest {	
	public static void main(String[] args) throws Exception {
		String text = "Hello ,我叫MT";
		System.out.println("原明文值：" + text);
		
		byte[] encodeBase64 = Base64.encodeBase64(text.getBytes());
		System.out.println("base64编码后的原明文值：" + new String(encodeBase64));
		
		byte[] key = DESedeCoder.initKey();
		System.out.println("base64编码后的密钥值："+ Base64.encodeBase64String(key));
		
		byte[] cipherData = DESedeCoder.encrypt(encodeBase64, key);
		System.out.println("加密后的密文值经过base64编码后的值为："+ Base64.encodeBase64String(cipherData));
		
		byte[] decrypt = DESedeCoder.decrypt(cipherData, key);
		System.out.println("解密后base64编码值：" + new String(decrypt));
		
		System.out.println("解密后的明文值：" + new String(Base64.decodeBase64(decrypt)));
	}
}
