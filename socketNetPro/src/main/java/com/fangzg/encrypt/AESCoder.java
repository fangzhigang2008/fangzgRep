package com.fangzg.encrypt;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AESCoder {
	private static String KEY_ALGORITHM = "AES";
	
	/**
	 * 加解密算法/工作模式/填充方式
	 */
	private static String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";
	
	public static byte[] initKey() throws NoSuchAlgorithmException, NoSuchProviderException{
		/**
		 * 初始化密钥生成器
		 */
//		Security.addProvider("");
		KeyGenerator kg = KeyGenerator.getInstance("AES");
		
		/**
		 * AES 要求长度为128 192 或者 256
		 */
		kg.init(256);
		/**
		 * 生成密钥
		 */
		SecretKey secretKey = kg.generateKey();
		/**
		 * 获得密钥的二进制编码形式
		 */
		return  secretKey.getEncoded();
	}
	
	/**
	 * 转换密钥
	 * @param key
	 * @return
	 */
	public static Key toKey(byte[] key){
		SecretKey secretKey = new SecretKeySpec(key,KEY_ALGORITHM);
		return secretKey;
	}
	
	/**
	 * 加密方法
	 * @param secretKey 密钥
	 * @param data 待加密数据
	 * @return 加密数据
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public static byte[] encrypt(byte[] secretKey, byte[] data) throws Exception{
		//还原key
		Key key = toKey(secretKey);
		/**
		 * 实例化
		 */
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
		
		/**
		 * 初始化，设置为加密模式
		 */
		cipher.init(Cipher.ENCRYPT_MODE, key);
		/**
		 * 执行加密操作
		 */
		byte[] cipherData = cipher.doFinal(data);
		return cipherData;
	}
	
	public static byte[] decrypt(byte[] key,byte[] data) throws Exception{
		//还原密钥
		Key key2 = toKey(key);
		/**
		 * 实例化
		 */
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
		/**
		 * 初始化，设置为解密模式
		 */
		cipher.init(Cipher.DECRYPT_MODE, key2);
		/**
		 * 执行解密操作
		 */
		byte[] clearData = cipher.doFinal(data);
		/**
		 * 返回明文数据
		 */
		return clearData;
	}
	
	
}
