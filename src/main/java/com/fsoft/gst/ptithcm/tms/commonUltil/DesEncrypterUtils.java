package com.fsoft.gst.ptithcm.tms.commonUltil;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class DesEncrypterUtils.
 */
public final class DesEncrypterUtils {
	
	/** The log. */
	private transient  Log log = LogFactory.getLog(DesEncrypterUtils.class);
	
	/** The instance. */
	private static DesEncrypterUtils instance = new DesEncrypterUtils();
	
	/** The Constant SECURITY_PHASE. */
//	private static final String SECURITY_PHASE = "vmsReport";
	
	/** The key. */
	private SecretKey key;
	
	/** The param spec. */
	private AlgorithmParameterSpec paramSpec;

	/**
	 * Gets the single instance of DesEncrypterUtils.
	 *
	 * @return single instance of DesEncrypterUtils
	 */
	public static DesEncrypterUtils getInstance() {
		return instance;
	}

	/**
	 * Instantiates a new des encrypter utils.
	 */
//	private DesEncrypterUtils() {
//		try {
//			// 8-bytes Salt
//			byte[] salt = { (byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32, (byte) 0x56, (byte) 0x34, (byte) 0xE3, (byte) 0x03 };
//
//			int iterationCount = 19;
//			KeySpec keySpec = new PBEKeySpec(SECURITY_PHASE.toCharArray(), salt, iterationCount);
//
//			key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);
//			paramSpec = new PBEParameterSpec(salt, iterationCount);
//
//		} catch (NoSuchAlgorithmException e) {
//			log.error(e.getMessage());
//		} catch (InvalidKeySpecException e) {
//			log.error(e.getMessage(), e);
//		}
//	}

	/**
	 * Encrypt.
	 *
	 * @param str the str
	 * @return the string
	 */
	@SuppressWarnings({ "hiding", "restriction" })
	public String encrypt(String str) {
		try {
			Cipher ecipher = Cipher.getInstance(key.getAlgorithm());
			ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
			byte[] utf8 = str.getBytes("UTF8");
			byte[] enc = ecipher.doFinal(utf8);
			return new sun.misc.BASE64Encoder().encode(enc);
		} catch (BadPaddingException e) {
			log.error(e.getMessage());
		} catch (IllegalBlockSizeException e) {
			log.error(e.getMessage());
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage());
		} catch (java.io.IOException e) {
			log.error(e.getMessage());
		} catch (InvalidKeyException e) {
			log.error(e.getMessage(), e);
		} catch (NoSuchAlgorithmException e) {
			log.error(e.getMessage(), e);
		} catch (NoSuchPaddingException e) {
			log.error(e.getMessage(), e);
		} catch (InvalidAlgorithmParameterException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * Decrypt.
	 *
	 * @param str the str
	 * @return the string
	 */
	@SuppressWarnings("restriction")
	public String decrypt(String str) {
		try {
			Cipher dcipher = Cipher.getInstance(key.getAlgorithm());
			dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);

			byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str);
			byte[] utf8 = dcipher.doFinal(dec);
			return new String(utf8, "UTF8");
		} catch (BadPaddingException e) {
			log.error(e.getMessage());
		} catch (IllegalBlockSizeException e) {
			log.error(e.getMessage());
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage());
		} catch (java.io.IOException e) {
			log.error(e.getMessage());
		} catch (InvalidKeyException e) {
			log.error(e.getMessage(), e);
		} catch (NoSuchAlgorithmException e) {
			log.error(e.getMessage(), e);
		} catch (NoSuchPaddingException e) {
			log.error(e.getMessage(), e);
		} catch (InvalidAlgorithmParameterException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		try {
			System.out.println("aaaaaaaaaaaa");
			System.out.println(getInstance().encrypt("123456"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
