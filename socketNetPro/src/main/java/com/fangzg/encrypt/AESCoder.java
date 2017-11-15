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
	 * �ӽ����㷨/����ģʽ/��䷽ʽ
	 */
	private static String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";
	
	public static byte[] initKey() throws NoSuchAlgorithmException, NoSuchProviderException{
		/**
		 * ��ʼ����Կ������
		 */
//		Security.addProvider("");
		KeyGenerator kg = KeyGenerator.getInstance("AES");
		
		/**
		 * AES Ҫ�󳤶�Ϊ128 192 ���� 256
		 */
		kg.init(256);
		/**
		 * ������Կ
		 */
		SecretKey secretKey = kg.generateKey();
		/**
		 * �����Կ�Ķ����Ʊ�����ʽ
		 */
		return  secretKey.getEncoded();
	}
	
	/**
	 * ת����Կ
	 * @param key
	 * @return
	 */
	public static Key toKey(byte[] key){
		SecretKey secretKey = new SecretKeySpec(key,KEY_ALGORITHM);
		return secretKey;
	}
	
	/**
	 * ���ܷ���
	 * @param secretKey ��Կ
	 * @param data ����������
	 * @return ��������
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public static byte[] encrypt(byte[] secretKey, byte[] data) throws Exception{
		//��ԭkey
		Key key = toKey(secretKey);
		/**
		 * ʵ����
		 */
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
		
		/**
		 * ��ʼ��������Ϊ����ģʽ
		 */
		cipher.init(Cipher.ENCRYPT_MODE, key);
		/**
		 * ִ�м��ܲ���
		 */
		byte[] cipherData = cipher.doFinal(data);
		return cipherData;
	}
	
	public static byte[] decrypt(byte[] key,byte[] data) throws Exception{
		//��ԭ��Կ
		Key key2 = toKey(key);
		/**
		 * ʵ����
		 */
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
		/**
		 * ��ʼ��������Ϊ����ģʽ
		 */
		cipher.init(Cipher.DECRYPT_MODE, key2);
		/**
		 * ִ�н��ܲ���
		 */
		byte[] clearData = cipher.doFinal(data);
		/**
		 * ������������
		 */
		return clearData;
	}
	
	
}
