package com.fangzg.encrypt;

import java.security.Key;
import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

/**
 * DESede�����࣬����Ϊһ��������
 * @author geeqhsios
 *
 */
public abstract class DESedeCoder {
	private static final String KEY_ALGORITHM = "DESede";
	
	private static final String CIPHER_ALGORITHM = "DESede/ECB/ISO10126Padding";
	
	public static byte[] initKey() throws Exception{
		/**
		 * ���һ����Կ������
		 */
		KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGORITHM);
		
		/**
		 * ��ʼ����Կ��������������Կ�ĳ���
		 */
		kg.init(168);
		
		SecretKey key = kg.generateKey();
		return key.getEncoded();
	}
	
	private static Key toKey(byte[] key) throws Exception{
		KeySpec dks = new DESedeKeySpec(key);
		SecretKeyFactory factory = SecretKeyFactory.getInstance(KEY_ALGORITHM);
		Key secretKey = factory.generateSecret(dks);
		return secretKey;
	}
	
	public static byte[] encrypt(byte[] data, byte[] key) throws Exception{
		Key key2 = toKey(key);
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, key2);
		byte[] doFinal = cipher.doFinal(data);
		return doFinal;
		
	}
	
	public static byte[] decrypt(byte[] cipherData, byte[] key) throws Exception{
		Key key2 = toKey(key);
		
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, key2);
		byte[] doFinal = cipher.doFinal(cipherData);
		
		return doFinal;
	}
}
